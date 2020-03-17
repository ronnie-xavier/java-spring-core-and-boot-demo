package cloud.itsu.springcoredemo.config;

import cloud.itsu.springcoredemo.components.SpellChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="cloud.itsu.springcoredemo")
public class AppConfig {
    @Bean
    public SpellChecker spellChecker2() {
        return new SpellChecker();
    }
}
