package demo4_hibernate_crud;

import demo4_hibernate_crud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo4_hibernate_crud/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 4;
            // new session and transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the generated id
            /*
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Deleting student: " + myStudent);
            session.delete(myStudent);
            // no need for save as persistent object is being modified, commiting is enough
            // commit the transaction
            session.getTransaction().commit();
*/
            // WITH QUERY
            System.out.println("Deleting student with id=2");
            session.createQuery("delete from Student where id=2")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
