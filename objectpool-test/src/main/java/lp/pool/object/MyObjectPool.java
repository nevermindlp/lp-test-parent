package lp.pool.object;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import lp.pool.model.Person;

/**
 * Created by lvpeng01 on 2018/11/8.
 */
public class MyObjectPool {

    private final GenericObjectPool<Person> pool;

    public MyObjectPool() {
        MyPooledObjectFactory factory = new MyPooledObjectFactory();
        this.pool = new GenericObjectPool<>(factory);
        this.pool.setMaxIdle(12);
        this.pool.setMinIdle(2);
        this.pool.setMaxTotal(12);
        this.pool.setMaxWaitMillis(1000L);
    }

    public Person getObject() throws Exception {
        return this.pool.borrowObject();
    }

    public ObjectPool getPool() {
        return this.pool;
    }

}
