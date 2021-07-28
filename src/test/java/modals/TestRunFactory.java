package modals;

import com.github.javafaker.Faker;


public class TestRunFactory {
    public static TestRun get() {

        Faker faker = new Faker();
        return TestRun.builder()
                .name(faker.harryPotter().spell())
                .includeAll(true)
                .build();
    }
}
