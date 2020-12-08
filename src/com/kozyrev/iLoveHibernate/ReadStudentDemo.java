package com.kozyrev.iLoveHibernate;

import com.kozyrev.iLoveHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ReadStudentDemo {

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
            System.out.println("Create a student");
            Student theStudent = new Student("Duffy", "Duck", "Duck@gmail.com", dateOfBirth);

            //start the transaction
            session.beginTransaction();

            //save student
            session.save(theStudent);
            System.out.println(theStudent);

            //commit the transaction
            session.getTransaction().commit();

            //find out student's id:
            System.out.println("generated id for student: " + theStudent.getId());

            //get a new student and start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id:
            Student myStudent = session.get(Student.class, theStudent.getId());

            //commit the transaction
            System.out.println("get complete: " + myStudent);
            session.getTransaction().commit();


            System.out.println("Everything is done");
        } finally {
            factory.close();
        }
    }
}
