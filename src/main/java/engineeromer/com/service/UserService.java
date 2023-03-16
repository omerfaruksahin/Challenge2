package engineeromer.com.service;

import engineeromer.com.dao.UserDao;
import engineeromer.com.dto.request.DeleteUserRequestDto;
import engineeromer.com.dto.request.UserSaveRequestDto;
import engineeromer.com.dto.response.OrganizationResponseDto;
import engineeromer.com.dto.response.UserJoinedAllOrganizationResponseDto;
import engineeromer.com.dto.response.UserResponseDto;
import engineeromer.com.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserDao userDao;

    public UserResponseDto saveUser(UserSaveRequestDto userSaveRequestDto){
        User user = modelMapper.map(userSaveRequestDto,User.class);
        user.setCreatedDate(LocalDate.now());
        userDao.save(user);
        return modelMapper.map(user,UserResponseDto.class);
    }

    public boolean deleteUser(DeleteUserRequestDto deleteUserRequestDto){
        int id = deleteUserRequestDto.getUserId();
        User user = userDao.findById(id).orElseThrow();
        userDao.deleteById(user.getUserId());
        return !userDao.existsById(id);
    }

    public List<UserResponseDto> getAllUser(){
        return userDao.findAll().stream().map(item->modelMapper.map(item,UserResponseDto.class)).toList();
    }

    public List<UserJoinedAllOrganizationResponseDto> getAllUserJoinedOrganization(){
        return userDao.findAll().stream().map(
                        user -> UserJoinedAllOrganizationResponseDto.builder()
                                .fullName(user.getFullName())
                                .organizationResponseDtos(user.getOrganizationList().stream().map(t -> modelMapper.map(t, OrganizationResponseDto.class)).toList()
                                ).build())
                .toList();
    }

    public UserResponseDto findNormalizedNameAccordingtoUser(String normalizedName){
        User user = userDao.findByNormalizedName(normalizedName);
        return modelMapper.map(user,UserResponseDto.class);
    }

    public UserResponseDto findUserAccordingToEmail(String email) {
        User user = userDao.findByEmail(email);
        return modelMapper.map(user,UserResponseDto.class);
    }

    public User findById(int userId){
        return userDao.findById(userId).orElseThrow();
    }
}
