package demo5_hibernate_association_mappings.eager_vs_lazy;

import demo5_hibernate_association_mappings.eager_vs_lazy.entity.Course;
import demo5_hibernate_association_mappings.eager_vs_lazy.entity.Instructor;
import demo5_hibernate_association_mappings.eager_vs_lazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerLazyDemoExHandling {
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
            // Instructor tempInstructor = session.get(Instructor.class, theId);

            // option 1 - call getter method while session is open
            // System.out.println("x Courses: " + tempInstructor.getCourses());

            // option 2 - Hibernate query with HQL
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                            + "JOIN FETCH i.courses where i.id=:theInstructorId",
                            Instructor.class);

            // set param on the query
            query.setParameter("theInstructorId", theId);

            // execute the query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("x Instructor: " + tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            // closes session befire lazily getting the courses, throws an exception
            session.close();
            System.out.println("\nSession is closed\n");

            // get dourses of the instructor
            System.out.println("x Courses: " + tempInstructor.getCourses());

            System.out.println("x Done!");
        } finally {
            // session.close();
            factory.close();
        }
    }
}
