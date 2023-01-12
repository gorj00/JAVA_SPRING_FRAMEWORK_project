package java_spring_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton") //default, keep it only for demonstration
public class TennisCoach implements Coach {

    // FIELD INJECTION with reflection
    @Autowired
    @Qualifier("happyFortuneService") // multiple FortuneService services, must id the right one
    private FortuneService fortuneService;

    // CONSTRUCTOR INJECTION
    /*
    @Autowired // looks for Component implementing this service, i.e. HappyFortuneService
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
     */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // SETTER INJECTION (OR METHOD INJECTOR - name not important
    /*
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside setFortuneService");
        this.fortuneService = fortuneService;
    }
    */

    @PostConstruct // os of Java 9, needs to be imported from external package
    public void doInitOperations() {
        System.out.println("Tennis coach: init hook");
    }

    @PreDestroy // os of Java 9, needs to be imported from external package
    public void doDestroyOperations() {
        System.out.println("Tennis coach: destroy hook");
    }

}
