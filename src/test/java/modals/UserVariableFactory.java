package modals;

import com.github.javafaker.Faker;
import tests.base.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class UserVariableFactory {

    public static UserVariable get() {
        Faker faker = new Faker();
        List<String> Type = new ArrayList<>();
        Type.add(Constants.UserVariableTypeString.getValue());
        Type.add(Constants.UserVariableTypePassword.getValue());
        Random random = new Random();
        int digit = random.nextInt(Type.size());
        return UserVariable.builder()
                .label(faker.harryPotter().spell())
                .description(faker.shakespeare().hamletQuote())
                .systemName(faker.name().firstName().toLowerCase(Locale.ROOT))
                .type(Type.get(digit))
                .build();
    }
}
