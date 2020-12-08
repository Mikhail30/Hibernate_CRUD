package com.kozyrev.iLoveHibernate;

import com.kozyrev.iLoveHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        try {
          int studentID = 1;

            //get a new student and start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Saved student, generated ID: " + studentID);

            //retrieve student based on the id:
            Student myStudent = session.get(Student.class, studentID);

            System.out.println("Updating student...");

            myStudent.setFirstName("Scooby");
            //commit the transaction
            System.out.println("get complete: " + myStudent);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            //updating email for all students
            System.out.println("updating email for all students");

            session.createQuery("update  Student set email='foo@gmail.ru'").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Everything is done");
        } finally {
            factory.close();
        }
    }
}
