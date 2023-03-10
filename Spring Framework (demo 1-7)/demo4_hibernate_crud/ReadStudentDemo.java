package demo4_hibernate_crud;

import demo4_hibernate_crud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo4_hibernate_crud/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating a new student object...");
            Student tempStudent = new Student("Ryan", "Nalitt", "email@palw.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Saved student. generated id: " + tempStudent.getId());

            // new session and transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the generated id
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);
            // commit the transaction
            session.getTransaction().commit();






            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
