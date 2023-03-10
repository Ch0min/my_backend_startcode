package dtos;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDTO {

    private String userName;
    private String userEmail;
    private String userPass;
    private List<String> roles;

    public UserDTO(User user){
        if(user.getUserName() != null){
            this.userName = user.getUserName();
        }
        this.userEmail = user.getUserEmail();
        this.userPass = user.getUserPass();
        this.roles = user.getRolesAsStrings();
    }

    public User getEntity(){
        User user = new User();
        if(this.userName != null){
            user.setUserName(this.userName);
        }
        user.setUserEmail(this.userEmail);
        user.setUserPass(this.userPass);
        user.getRolesAsStrings();
        return user;
    }

    public static List<UserDTO> getUserDTOs(List<User> users){
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user->userDTOs.add(new UserDTO(user)));
        return userDTOs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getUserName().equals(userDTO.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPass='" + userPass + '\'' +
                ", roleList=" + roles +
                '}';
    }
}
