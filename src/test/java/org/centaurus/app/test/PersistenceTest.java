package org.centaurus.app.test;

import org.centaurus.app.entity.User;
import org.centaurus.app.repository.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceTest {
    private Logger logger = LoggerFactory.getLogger(PersistenceTest.class);
    @Test
    public void saveTest(){
        User user = new User();
        user.setName("name");
        user.setSurname("surname");

        HibernateConfiguration configuration = new HibernateConfiguration();
        SessionFactory sessionFactory = configuration.getSessionFactory();
        Session session = sessionFactory.openSession(); session.beginTransaction();
        session.save(user);
        System.err.println(user.getId());
        logger.info("new id : " + user.getId());
    }
}
