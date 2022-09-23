package config.server.demo;

import com.github.javafaker.Faker;
import config.server.demo.model.CreditCard;
import config.server.demo.model.CreditCardPrivateInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(value = {CreditCardPrivateInfo.class})
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/account-service")
@RequiredArgsConstructor
class AccountController {
    private final CreditCardPrivateInfo creditCardPrivateInfo;

    @GetMapping("/accounts/{accountNumber}")
    public CreditCard getCreditCard(@PathVariable String accountNumber) {
        return new CreditCard(new Faker().business());
    }

    @GetMapping("/accounts/{accountNumber}/private")
    public CreditCardPrivateInfo getCreditCardPrivateInfo(@PathVariable String accountNumber) {
        return creditCardPrivateInfo;
    }
}
