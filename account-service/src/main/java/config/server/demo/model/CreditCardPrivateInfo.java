package config.server.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ToString
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties("credit.card")
public class CreditCardPrivateInfo {
    private String owner;
    private String cvv;
}
