package demo5_hibernate_association_mappings.one_to_many_bi;

import demo5_hibernate_association_mappings.one_to_many_bi.entity.Course;
import demo5_hibernate_association_mappings.one_to_many_bi.entity.Instructor;
import demo5_hibernate_association_mappings.one_to_many_bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleterCourseDemo {
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

            // get a course
            int theId = 11;
            Course tempCourse = session.get(Course.class, theId);

            // delete course
            System.out.println("Course: " + tempCourse);
            session.delete(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
