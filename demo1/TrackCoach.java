package demo1;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void initStartup() {
        System.out.println("TrackCoach: inside method initStartup");
    }

    public void destroyCleanup() {
        System.out.println("TrackCoach: inside method destroyCleanup");
    }
}
