package com.kozyrev.iLoveHibernate;

import com.kozyrev.iLoveHibernate.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudentDemo {

    public static void main(String[] args) throws ParseException {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        try {
            try {
                // create a student object
                System.out.println("creating a new student object ...");

                String theDateOfBirthStr = "31/12/1998";

                Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

                Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);

                // start transaction
                session.beginTransaction();

                // save the student object
                System.out.println("Saving the student ...");
                session.save(tempStudent);

                // commit transaction
                session.getTransaction().commit();

                System.out.println("Success!");
            }catch (HibernateException e) {
                e.printStackTrace();
            }
            } finally {
                factory.close();
            }

        }
    }

