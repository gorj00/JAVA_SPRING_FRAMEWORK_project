package demo5_hibernate_association_mappings.one_to_many_bi;

import demo5_hibernate_association_mappings.one_to_many_bi.entity.Course;
import demo5_hibernate_association_mappings.one_to_many_bi.entity.Instructor;
import demo5_hibernate_association_mappings.one_to_many_bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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

            // create objects
            Instructor tempInstructor = new Instructor("Susan", "Public", "ex@ampleSusan.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://youtube.com",
                    "gaming"
            );

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // save the instructor
            // also saves the details object due to cascadeType.ALL
            System.out.println("Saving instrucotr: " + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
