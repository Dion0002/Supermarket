package sm.supermarket;

/**
 * This class for getting and setting the user login info for username , password and his role
 */
public class UserRole {
    protected static String username, password, role;

    public UserRole() {
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserRole.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserRole.password = password;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        UserRole.role = role;
    }
}
