package modals;

import com.github.javafaker.Faker;

public class SectionFactory {
    public static Section get() {

        Faker faker = new Faker();
        return Section.builder()
                .description(faker.shakespeare().romeoAndJulietQuote())
                .name(faker.harryPotter().character())
                .build();
    }
}
