package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    String title;
    int typeId;
    int priorityId;
    int templateId;
    String estimate;
    String refs;
}
