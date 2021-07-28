package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestRun {
    String name;
    @SerializedName("suite_id")
    String suiteId;
    @SerializedName("assignedto_id")
    String assignedtoId;
    @SerializedName("include_all")
    boolean includeAll;
    @SerializedName("case_ids")
    List<Integer> caseIds;
    String refs;
}
