package modals;

import com.github.javafaker.Faker;
import tests.base.Constants;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFactory {

    public static String randomString() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        int len = 8;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static User get() {
        Faker faker = new Faker();

        List<String> UserTheme = new ArrayList<>();
        UserTheme.add(Constants.NewUserThemeDark.getValue());
        UserTheme.add(Constants.NewUserThemeClassic.getValue());
        UserTheme.add(Constants.NewUserThemeModern.getValue());
        int randomTheme = new Random().nextInt(UserTheme.size());

        List<String> NewUserAccess = new ArrayList<>();
        NewUserAccess.add(Constants.ProjectAddDefaultAccessDesigner.getValue());
        NewUserAccess.add(Constants.ProjectAddDefaultAccessLead.getValue());
        NewUserAccess.add(Constants.ProjectAddDefaultAccessRead.getValue());
        NewUserAccess.add(Constants.ProjectAddDefaultAccessTester.getValue());
        int digitNewUserAccess = new Random().nextInt(NewUserAccess.size());


        return User.builder()
                .fullName(faker.name().fullName())
                .emailAddress(faker.internet().emailAddress())
                .enableEmailNotifications(faker.random().nextBoolean())
                .language("English")
                .theme(UserTheme.get(randomTheme))
                .locate(faker.country().name())
                .timeZone(faker.country().capital())
                .typeOfInvite(Constants.typeOfInvite.getValue())
                .role(NewUserAccess.get(digitNewUserAccess))
                .thisUserIsActive(faker.random().nextBoolean())
                .thisUserIaAnAdministrator(faker.random().nextBoolean())
                .password(randomString())
                .build();
    }
}
