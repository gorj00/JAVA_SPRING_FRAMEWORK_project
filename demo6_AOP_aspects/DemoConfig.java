package demo6_AOP_aspects;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("demo6_AOP_aspects") // important for aspect, since they injerit from component
public class DemoConfig {
}
