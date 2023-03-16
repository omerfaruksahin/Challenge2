package engineeromer.com.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ChooseOrganizationRequestDto {

    private int userId;

    private List<Integer> organizationId;
}
