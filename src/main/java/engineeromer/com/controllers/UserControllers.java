package engineeromer.com.controllers;

import engineeromer.com.dto.request.DeleteUserRequestDto;
import engineeromer.com.dto.request.UserSaveRequestDto;
import engineeromer.com.dto.response.UserJoinedAllOrganizationResponseDto;
import engineeromer.com.dto.response.UserResponseDto;
import engineeromer.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserControllers {
    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        return new ResponseEntity<>(userService.saveUser(userSaveRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody DeleteUserRequestDto deleteUserRequestDto){
        return new ResponseEntity<>(userService.deleteUser(deleteUserRequestDto),HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<List<UserResponseDto>> getUserList(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("/userJoinedOrganizationList")
    public ResponseEntity<List<UserJoinedAllOrganizationResponseDto>> getAllUserHaveBookList(){
        return new ResponseEntity<>(userService.getAllUserJoinedOrganization(),HttpStatus.OK);
    }

    @GetMapping("/getFullNameAccordinToNormalizedName")
    public ResponseEntity<UserResponseDto> getNormalizedNameUser(@RequestParam String normalizedName){
        return new ResponseEntity<>(userService.findNormalizedNameAccordingtoUser(normalizedName),HttpStatus.OK);
    }

    @GetMapping("/getFullNameAccordinToNormalizedName")
    public ResponseEntity<UserResponseDto> getUserAccordingToEmail(@RequestParam String email){
        return new ResponseEntity<>(userService.findUserAccordingToEmail(email),HttpStatus.OK);
    }
}
