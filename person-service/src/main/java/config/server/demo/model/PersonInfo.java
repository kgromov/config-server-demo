package config.server.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.javamoney.moneta.Money;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ToString
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties("person")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class PersonInfo {
    private String name;
    private int age;
    private int height;
    private int weight;
    @JsonIgnore
    private Money salary;

    public String getSalaryToString() {
        return salary.toString();
    }
}
