package xml_spring_configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "xml_spring_configuration/applicationContext.xml"
                );

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // calls methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
