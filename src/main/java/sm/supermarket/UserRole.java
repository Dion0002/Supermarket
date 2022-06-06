package sm.supermarket;

/**
 * This class for getting and setting the user login info for username , password and his role
 */
public class UserRole {
    public static String username, password, role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        UserRole.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UserRole.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        UserRole.role = role;
    }


}
