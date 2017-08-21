package com.sliceoflife.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import info.sliceoflife.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query the students
			List<Student> students = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(students);

			// query students: lastName = 'Doe'
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			// display the students
			displayStudents(students);

			// query students: lastName = 'Doe' OR firstName='Daffy
			students = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();

			// display the students
			displayStudents(students);
			
			// query students: with like clause where email ends on sol.com
			students = session.createQuery("from Student s where" + " s.email LIKE '%sol.com'")
								.getResultList();

			// display the students
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}
}
