package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Main class.
 */
public class Main {
    public static void main(String[] args) throws NamingException {
        /* Example with sesion factory
        ==============================
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setName("John");
        student.setAge("21");

        session.save(student);
        session.getTransaction().commit();

        System.out.println(student + " saved");
        */


        Student student = new Student();
        student.setName("Belle");
        student.setAge("20");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();


    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        // Need to register all the classes used as entities
        configuration.addAnnotatedClass(Student.class);

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}

