package annotations_spring_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
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
}
