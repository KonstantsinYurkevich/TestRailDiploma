package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InviteUser {
    String FullName;
    String EmailAddress;
    boolean enableEmailNotifications;
    String language;
    String theme;
    String locate;
    String timeZone;
    String TypeOfInvite;
    String Role;
    String password;
    boolean ThisUserIsActive;
    boolean ThisUserIaAnAdministrator;
}
