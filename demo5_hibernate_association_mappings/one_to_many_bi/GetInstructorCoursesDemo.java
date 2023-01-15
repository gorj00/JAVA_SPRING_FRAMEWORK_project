package demo5_hibernate_association_mappings.one_to_many_bi;

import demo5_hibernate_association_mappings.one_to_many_bi.entity.Course;
import demo5_hibernate_association_mappings.one_to_many_bi.entity.Instructor;
import demo5_hibernate_association_mappings.one_to_many_bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo5_hibernate_association_mappings/one_to_many_bi/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

            // get dourses of the instructor
            System.out.println("Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
