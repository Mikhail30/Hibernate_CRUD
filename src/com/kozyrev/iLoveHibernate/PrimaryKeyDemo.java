package com.kozyrev.iLoveHibernate;

import com.kozyrev.iLoveHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        try {
            //saving the object
Date dateOfBirth = null;
            //create student
            System.out.println("Creating 3 students");
            Student student1 = new Student("Mike", "Holly", "Holly@gmail.com",dateOfBirth);
            Student student2 = new Student("John", "Doe", "Doe@gmail.com",dateOfBirth);
            Student student3 = new Student("Bonita", "Applebaum", "Applebaum@gmail.com",dateOfBirth);

            //start the transaction
            session.beginTransaction();

            //save student
            System.out.println("Saving students");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Everything is done");
        } finally {
            factory.close();
        }
    }
}
