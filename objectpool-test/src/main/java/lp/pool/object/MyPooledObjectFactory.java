package lp.pool.object;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import lp.pool.model.Person;

/**
 * Created by lvpeng01 on 2018/11/8.
 */
public class MyPooledObjectFactory extends BasePooledObjectFactory<Person> {

    @Override
    public Person create() throws Exception {
        Person p = new Person();
        p.setAge(1);
        p.setName("test");
        return p;
    }

    @Override
    public PooledObject<Person> wrap(Person person) {
        return new DefaultPooledObject<>(person);
    }
}
