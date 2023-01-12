package demo3_java_spring_configuration;

import demo2_annotations_spring_configuration.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
