package com.kozyrev.iLoveHibernate;

import com.kozyrev.iLoveHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        try {

            //get a new student and start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

//            System.out.println("Saved student, generated ID: " + studentID);

            //retrieve student based on the id:
//            Student myStudent = session.get(Student.class, studentID);
            //delete student by ID;
//            session.delete(myStudent);
            session.createQuery("delete from Student where id=11").executeUpdate();


            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
