package demo3_java_spring_configuration;

import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("demo3_java_spring_configuration") used with @Component
@PropertySource("classpath:demo3_java_spring_configuration/sport.props")
public class SportConfig  {

    @Bean // name is bean ID `sadFortuneService`
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        // injection
        return new SwimCoach(sadFortuneService());
    }

}
