package org.example;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class ObjectDBUtil {

    private final static EntityManagerFactory entityManagerFactory;
    private static final Logger log = Logger.getLogger(ObjectDBUtil.class.getName());

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return ObjectDBUtil.entityManagerFactory;
    }
}
