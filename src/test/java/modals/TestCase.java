package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    String title;
    @SerializedName("type_id")
    String typeId;
    @SerializedName("priority_id")
    String priorityId;
    @SerializedName("template_id")
    String templateId;
    String estimate;
    String refs;
}
