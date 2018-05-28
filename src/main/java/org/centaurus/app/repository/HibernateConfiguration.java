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
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/app")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(User.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
