package engineeromer.com.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrganizationResponseDto {

    private List<String> organizationName = new ArrayList<>();

    public void addOrganization(String organization){
        organizationName.add(organization);
    }
}
