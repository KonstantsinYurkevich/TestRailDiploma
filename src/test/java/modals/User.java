package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String fullName;
    String emailAddress;
    boolean enableEmailNotifications;
    String language;
    String theme;
    String locate;
    String timeZone;
    String typeOfInvite;
    String role;
    String password;
    boolean thisUserIsActive;
    boolean thisUserIaAnAdministrator;
}
