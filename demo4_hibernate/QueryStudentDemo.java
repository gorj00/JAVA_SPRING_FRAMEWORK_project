package demo4_hibernate;

import demo4_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo4_hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(theStudents);

            // query, last name Doe
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            // query, lastName Doe or firstName Mary
            theStudents = session.createQuery(
                    "from Student s where s.lastName='Doe' OR s.firstName='Mary'"
            ).getResultList();
            System.out.println("\n\nStudents who have last name of Doe or first name of Mary");
            displayStudents(theStudents);

            // query, email LIKE
            theStudents = session.createQuery("from Student s where s.email LIKE '%.com'").getResultList();
            System.out.println("\n\nStudents whose email ends with .com");
            displayStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
