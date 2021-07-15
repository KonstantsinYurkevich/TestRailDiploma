package modals;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVariable {
    String label;
    String description;
    String systemName;
    String type;
    String fallBack;


}
