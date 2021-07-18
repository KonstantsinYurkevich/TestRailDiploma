package modals;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestCaseFactory {

    public static TestCase get() {

        Faker faker = new Faker();
        int typeId = new Random().nextInt(13);
        int priorityId = new Random().nextInt(5);
        int templateId = new Random().nextInt(4);
        return TestCase.builder()
                .title(faker.harryPotter().spell())
                .type_id(typeId)
                .priority_id(priorityId)
                .template_id(templateId)
                .build();
    }
}
