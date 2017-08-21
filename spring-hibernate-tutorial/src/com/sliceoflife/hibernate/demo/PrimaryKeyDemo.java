package com.sliceoflife.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import info.sliceoflife.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create tree student objects
			System.out.println("creating 3 student objects");
			Student tempStudent1 = new Student("John", "Doe", "john@sol.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@sol.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@sol.com");


			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}

}
