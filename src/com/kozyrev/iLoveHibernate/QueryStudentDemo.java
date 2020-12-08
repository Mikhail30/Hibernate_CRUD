package com.kozyrev.iLoveHibernate;

import com.kozyrev.iLoveHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        try {
            //start the transaction
            session.beginTransaction();

            //query students
        List<Student> students = session.createQuery("from Student").getResultList();

            //query students with last name 'Doe'
            students = session.createQuery("from Student s where s.lastName ='Doe'").getResultList();

            //query students with last name 'Doe' OR firstName - Daffy
            students = session.createQuery("from Student s where s.lastName ='Doe' OR s.firstName='Duffy'").getResultList();

            //query students with email like '@gmail.com'
            students = session.createQuery("from Student s where " +
                    " s.email   LIKE '%@gmail.com'").getResultList();

            //display students
            for (Student st: students) {
                System.out.println(st);
            }


            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Everything is done");
        } finally {
            factory.close();
        }
    }
}
