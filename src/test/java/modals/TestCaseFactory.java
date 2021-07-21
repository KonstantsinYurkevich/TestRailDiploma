package modals;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestCaseFactory {

    public static TestCase get() {

        Faker faker = new Faker();
        String typeId = String.valueOf(new Random().nextInt(13));
        String priorityId = String.valueOf(new Random().nextInt(5));
        String templateId = String.valueOf(new Random().nextInt(4));
        return TestCase.builder()
                .title(faker.harryPotter().spell())
                .typeId(typeId)
                .priorityId(priorityId)
                .templateId(templateId)
                .build();
    }
}
