package demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                "demo1/applicationContext.xml"
        );

        // retrieve bean from teh spring container
        CricketCoach theCoach = context.getBean(
                "myCricketCoach", CricketCoach.class
        );

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
