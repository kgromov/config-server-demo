package config.server.demo;

import config.server.demo.model.PersonInfo;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableConfigurationProperties(value = {PersonInfo.class})
@SpringBootApplication
public class PersonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/person-service")
@RequiredArgsConstructor
class PersonController {
    private final PersonInfo personInfo;

    @GetMapping("/configuration")
    public PersonInfo getPersonConfiguration() {
        return personInfo;
    }
}

@Component
@ConfigurationPropertiesBinding
class MoneyConverter implements Converter<String, Money> {
    @Override
    public Money convert(String source) {
        return Money.parse(source);
    }
}
