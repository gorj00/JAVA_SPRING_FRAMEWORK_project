package annotations_spring_configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "annotations_spring_configuration/applicationContext.xml"
        );

        // get bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
