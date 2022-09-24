package config.server.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Delegate;
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
    @Delegate
    @JsonIgnore
    private Secret secret;

    @Getter
    @RequiredArgsConstructor
    @ConstructorBinding
    private static class Secret {
        private final String phrase;
        private final String answer;
    }
}
