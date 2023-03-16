package engineeromer.com.controllers;

import engineeromer.com.dto.request.ChooseOrganizationRequestDto;
import engineeromer.com.dto.response.UserOrganizationResponseDto;
import engineeromer.com.service.UserOrganizationLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/userOrganization")
public class UserOrganizationController {

    private final UserOrganizationLogService userOrganizationLogService;

    @PostMapping("/ornekLog")
    public ResponseEntity<UserOrganizationResponseDto> chooseOrganization(@RequestBody ChooseOrganizationRequestDto chooseOrganizationRequestDto){
        return new ResponseEntity<>(userOrganizationLogService.userJoiningOrganizations(chooseOrganizationRequestDto), HttpStatus.OK);
    }
}
