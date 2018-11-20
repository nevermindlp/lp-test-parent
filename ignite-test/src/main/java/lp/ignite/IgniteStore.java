package lp.ignite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.cache.Cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.resources.IgniteInstanceResource;

import lp.ignite.vo.City;
import lp.ignite.vo.Person;
import lp.ignite.vo.PersonKey;

/**
 * Created by lvpeng01 on 2018/10/11.
 */
public class IgniteStore {

    private static void prepareDdl() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
        Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1");
        try {
            Statement stmt = conn.createStatement();
            // Create table based on REPLICATED template.
            stmt.executeUpdate("CREATE TABLE City (" +
                    " id LONG PRIMARY KEY, name VARCHAR) " +
                    " WITH \"template=replicated\"");

            // Create table based on PARTITIONED template with one backup.
            stmt.executeUpdate("CREATE TABLE Person ("
                    + " id LONG, name VARCHAR, city_id LONG,"
                    + " PRIMARY KEY (id, city_id)) "
                    + " WITH \"backups=1, affinityKey=city_id\"");
            stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");
            stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void prepareData(Ignite ignite) {
        IgniteCache<Long, City> cityCache = ignite.cache("SQL_PUBLIC_CITY");

        IgniteCache<PersonKey, Person> personCache = ignite.cache("SQL_PUBLIC_PERSON");

        SqlFieldsQuery query = new SqlFieldsQuery("INSERT INTO City (id, name) VALUES (?, ?)");
        cityCache.query(query.setArgs(1, "Forest Hill")).getAll();
        cityCache.query(query.setArgs(2, "Denver")).getAll();
        cityCache.query(query.setArgs(3, "St. Petersburg")).getAll();

        query = new SqlFieldsQuery("INSERT INTO Person (id, name, city_id) VALUES (?, ?, ?)");
        personCache.query(query.setArgs(1, "John Doe", 3)).getAll();
        personCache.query(query.setArgs(2, "Jane Roe", 2)).getAll();
        personCache.query(query.setArgs(3, "Mary Major", 1)).getAll();
        personCache.query(query.setArgs(4, "Richard Miles", 2)).getAll();

    }

    public static void queryData(Ignite ignite) {
        IgniteCache<Long, City> cityCache = ignite.cache("SQL_PUBLIC_CITY");
        SqlFieldsQuery query = new SqlFieldsQuery("SELECT p.name, c.name "
                + "FROM Person p, City c WHERE p.city_id = c.id");
        FieldsQueryCursor<List<?>> cursor = cityCache.query(query);
        Iterator<List<?>> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            List<?> row = iterator.next();
            System.out.println(row.get(0) + ", " + row.get(1));
        }
    }

    public static void exactlyQueryData(Ignite ignite) {
        long cityId = 2; // Id for Denver

        // Sending the logic to a cluster node that stores Denver and its residents.
        ignite.compute().affinityRun("SQL_PUBLIC_CITY", cityId, new IgniteRunnable() {

            @IgniteInstanceResource
            Ignite ignite;

            @Override
            public void run() {
                // Getting an access to Persons cache.
                IgniteCache<BinaryObject, BinaryObject> people = ignite.cache(
                        "SQL_PUBLIC_PERSON").withKeepBinary();

                ScanQuery<BinaryObject, BinaryObject> query =
                        new ScanQuery<>();

                try (QueryCursor<Cache.Entry<BinaryObject, BinaryObject>> cursor =
                             people.query(query)) {

                    // Iteration over the local cluster node data using the scan query.
                    for (Cache.Entry<BinaryObject, BinaryObject> entry : cursor) {
                        BinaryObject personKey = entry.getKey();

                        // Picking Denver residents only only.
                        if (personKey.<Long>field("CITY_ID") == cityId) {
                            BinaryObject object = entry.getValue();
                            System.out.println("city value is : " + object.field("NAME"));
                            // Sending the warning message to the person.
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Ignite ignite = Ignition.start();
        prepareDdl();
        prepareData(ignite);
        queryData(ignite);
        exactlyQueryData(ignite);
    }



}
