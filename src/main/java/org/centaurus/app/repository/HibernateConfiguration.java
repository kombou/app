package org.centaurus.app.repository;


import org.centaurus.app.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfiguration {

    private SessionFactory sessionFactory;

    public HibernateConfiguration() {
        configure();
        createSessionFactory();

    }

    private SessionFactory createSessionFactory() {

        sessionFactory = configure().buildSessionFactory();
        return sessionFactory;
    }

    private Configuration configure() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:./GLOBALS;INIT=CREATE SCHEMA IF NOT EXISTS GLOBALS")
                .setProperty("hibernate.default_schema", "GLOBALS")
                .setProperty("hibernate.connection.username", "sa")
                .setProperty("hibernate.connection.password", "")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(User.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
