package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//TODO просто переименовать в класс User
public class InviteUser {
    //TODO названия переменных с маленькой буквы
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
