package engineeromer.com.service;

import engineeromer.com.dao.OrganizationDao;
import engineeromer.com.dao.UserDao;
import engineeromer.com.dto.request.ChooseOrganizationRequestDto;
import engineeromer.com.dto.response.UserOrganizationResponseDto;
import engineeromer.com.model.Organization;
import engineeromer.com.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserOrganizationLogService {

    private final UserService userService;
    private final OrganizationService organizationService;
    private final UserDao userDao;
    private final OrganizationDao organizationDao;

    public UserOrganizationResponseDto userJoiningOrganizations(ChooseOrganizationRequestDto chooseOrganizationRequestDto){
        User user = userService.findById(chooseOrganizationRequestDto.getUserId());
        List<Integer> organizationId = chooseOrganizationRequestDto.getOrganizationId();
        UserOrganizationResponseDto userOrganizationResponseDto = new UserOrganizationResponseDto();
        for(Integer integer:organizationId){
            Organization organization = organizationService.findById(integer);
            user.addOrganization(organization);
            userOrganizationResponseDto.addOrganization(organization.getOrganizationName());
        }
        userDao.save(user);
        return userOrganizationResponseDto;
    }


}
