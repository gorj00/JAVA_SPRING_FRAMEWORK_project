package demo5_hibernate_association_mappings.many_to_many;

import demo5_hibernate_association_mappings.many_to_many.entity.Course;
import demo5_hibernate_association_mappings.many_to_many.entity.Instructor;
import demo5_hibernate_association_mappings.many_to_many.entity.InstructorDetail;
import demo5_hibernate_association_mappings.many_to_many.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo5_hibernate_association_mappings/many_to_many/hibernate.cfg.xml")
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

            // create a course
            Course tempCourse = new Course("Pacman - How to score milion points");

            // add some reviews
            tempCourse.addReview(new Review("Rev1"));
            tempCourse.addReview(new Review("Rev2"));
            tempCourse.addReview(new Review("Rev3"));

            // save the course and reviews via cascade
            System.out.println("Saving the course: " + tempCourse);
            session.save(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
