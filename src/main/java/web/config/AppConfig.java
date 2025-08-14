package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"web.dao","web.config","web.model"})

@Import({PersistenceConfig.class, WebConfig.class})
public class AppConfig {

}