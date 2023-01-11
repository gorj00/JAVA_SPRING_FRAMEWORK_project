package annotations_spring_configuration;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
