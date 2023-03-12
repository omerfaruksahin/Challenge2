package engineeromer.com.controllers;

import engineeromer.com.dto.request.DeleteOrganizationRequestDto;
import engineeromer.com.dto.request.OrganizationSaveRequestDto;
import engineeromer.com.dto.response.OrganizationResponseDto;
import engineeromer.com.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("organization")
public class OrganizationControllers {
    private final OrganizationService organizationService;

    @PostMapping("/saveOrganization")
    public ResponseEntity<OrganizationResponseDto> saveOrganization(@RequestBody OrganizationSaveRequestDto organizationSaveRequestDto){
        return new ResponseEntity<>(organizationService.saveOrganization(organizationSaveRequestDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteOrganization(@RequestBody DeleteOrganizationRequestDto deleteOrganizationRequestDto){
        return new ResponseEntity<>(organizationService.deleteOrganization(deleteOrganizationRequestDto),HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<List<OrganizationResponseDto>> getUserList(){
        return new ResponseEntity<>(organizationService.getAllOrganization(),HttpStatus.OK);
    }

    @GetMapping("/getOrganizationAccordinToRegisterNumber")
    public ResponseEntity<OrganizationResponseDto> getOrganizationAccordingToEmail(@RequestParam int registryNumber){
        return new ResponseEntity<>(organizationService.findOrganizationAccordingToEmail(registryNumber),HttpStatus.OK);
    }
}
