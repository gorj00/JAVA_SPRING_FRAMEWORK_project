package java_spring_configuration;

import annotations_spring_configuration.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
