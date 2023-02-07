package demo5_hibernate_association_mappings.one_to_many_bi;

import demo5_hibernate_association_mappings.one_to_one_bi.entity.Instructor;
import demo5_hibernate_association_mappings.one_to_one_bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("demo5_hibernate_association_mappings/one_to_one_uni/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            int id = 2;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor() );

            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);

            // For non cascade.remove , ewmove the associated object reference
            // break bi-bidirectional link
             tempInstructorDetail.getInstructor().setInstructorDetail(null);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
