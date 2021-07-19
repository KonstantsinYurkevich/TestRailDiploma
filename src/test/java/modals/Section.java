package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Section {
    String name;
    int parentId;
    String description;
}
