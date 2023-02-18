package demo5_hibernate_association_mappings.many_to_many;

import demo5_hibernate_association_mappings.many_to_many.entity.Course;
import demo5_hibernate_association_mappings.many_to_many.entity.Instructor;
import demo5_hibernate_association_mappings.many_to_many.entity.InstructorDetail;
import demo5_hibernate_association_mappings.many_to_many.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo5_hibernate_association_mappings/one_to_many_uni/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
