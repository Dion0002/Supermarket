package sm.supermarket;

import java.util.ArrayList;
import java.util.List;

/**
 * This class for getting and setting the user login info for username , password and his role
 */
public class UserRole {
    String username,password,role;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
