package modals;

import com.github.javafaker.Faker;
import tests.base.Enum;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InviteUserFactory {

    public static String randomString() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        int len = 8;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static InviteUser get() {
        Faker faker = new Faker();

        List<String> UserTheme = new ArrayList<>();
        UserTheme.add(Enum.NewUserThemeDark.getValue());
        UserTheme.add(Enum.NewUserThemeClassic.getValue());
        UserTheme.add(Enum.NewUserThemeModern.getValue());
        int randomTheme = new Random().nextInt(UserTheme.size());

        List<String> NewUserAccess = new ArrayList<>();
        NewUserAccess.add(Enum.ProjectAddDefaultAccessDesigner.getValue());
        NewUserAccess.add(Enum.ProjectAddDefaultAccessLead.getValue());
        NewUserAccess.add(Enum.ProjectAddDefaultAccessNo.getValue());
        NewUserAccess.add(Enum.ProjectAddDefaultAccessRead.getValue());
        NewUserAccess.add(Enum.ProjectAddDefaultAccessTester.getValue());
        int digitNewUserAccess = new Random().nextInt(NewUserAccess.size());


        return InviteUser.builder()
                .FullName(faker.name().fullName())
                .EmailAddress(faker.internet().emailAddress())
                .enableEmailNotifications(faker.random().nextBoolean())
                .language("English")
                .theme(UserTheme.get(randomTheme))
                .locate(faker.country().name())
                .timeZone(faker.country().capital())
                .TypeOfInvite(Enum.typeOfInvite.getValue())
                .Role(NewUserAccess.get(digitNewUserAccess))
                .ThisUserIsActive(faker.random().nextBoolean())
                .ThisUserIaAnAdministrator(faker.random().nextBoolean())
                .password(randomString())
                .build();
    }
}
