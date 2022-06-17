package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.TRANSPARENT;

public class LoginFromController implements Initializable {
    private final UserRole role = null;
    public Employee employee;
    //Create a list for the user
    List<UserRole> ListLogin = new ArrayList<UserRole>();
    String password;
    @FXML
    private JFXButton btn_cancel;
    @FXML
    private JFXButton btn_login;
    @FXML
    private JFXButton btn_signUp;
    @FXML
    private ImageView img_dontShowPass;
    @FXML
    private ImageView img_seePass;
    @FXML
    private Label lbl_invalid;
    @FXML
    private AnchorPane loginpage;
    @FXML
    private PasswordField pf_password;
    @FXML
    private TextField tf_showPass;
    @FXML
    private TextField tf_username;

    /**
     * This is for the cancel button to close the program
     *
     * @param event
     */
    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }

    /**
     * This is for the login button to open specific page for the users
     * If user enter his/her credentials that depending on those this function determine what page to open
     * And check for user validation if username or password are incorrect.
     *
     * @param event
     */
    public void loginButtonOnAction(ActionEvent event) {
        if ((tf_username.getText().isBlank() == true && pf_password.getText().isBlank() == true)) {
            lbl_invalid.setText("Please enter username and password");
        } else if (tf_username.getText().isBlank() == true) {
            lbl_invalid.setText("Username cannot be empty");
        } else if (pf_password.getText().isBlank() == true) {
            lbl_invalid.setText("Password cannot be empty");
        } else if (auth() == true) {
        } else {
            lbl_invalid.setText("Incorrect username or password");
        }
    }

    /**
     * User Authentication
     * Open specific page for the users
     * If user enter his/her credentials that depending on those this function determine what page to open
     *
     * @return
     */
    public boolean auth() {
        try {
            ListLogin = validateLogin(tf_username.getText(), pf_password.getText());

            if (UserRole.getRole().equalsIgnoreCase("admin")) {
                AdminLog();
            } else if (UserRole.getRole().equalsIgnoreCase("cashier")) {
                CashLog();
            } else {
                CusLog();
            }
            Stage stage = (Stage) btn_login.getScene().getWindow();
            stage.close();
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * This is for getting the information from the database table and checking if the user input
     * is the same with that of the database
     *
     * @param username
     * @param password
     * @return
     */
    public List validateLogin(String username, String password) {
        DBConnection conn = new DBConnection();
        Connection conDB = conn.getConnection();
        List logLogin = new ArrayList();

        String Uname = tf_username.getText();
        String Pass = pf_password.getText();

        //Enter the query for retrieving the info
        String verifyLogin = "select Username, Password, Role from userlogin where Username ='" + Uname +
                "' and Password ='" + Pass + "'";


        try {
            Statement statement = conDB.createStatement();
            ResultSet rs = statement.executeQuery(verifyLogin);

            while (rs.next()) {
                UserRole ur = new UserRole();
                UserRole.setUsername(rs.getString("username"));
                UserRole.setPassword(rs.getString("password"));
                UserRole.setRole(rs.getString("role"));
                Uname = rs.getString("username");
                UserRole.username = Uname;

                logLogin.add(ur);


            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return logLogin;
    }

    /**
     * SingUp button that call the singup method
     *
     * @param event
     */
    public void SignUpButton(ActionEvent event) {
        SignUP();
    }

    /**
     * Open SignUp page
     */
    public void SignUP() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SignUpForm.fxml"));
            Stage SignUPstage = new Stage();
            Scene scene = new Scene(root);
            SignUPstage.initStyle(StageStyle.TRANSPARENT);
            SignUPstage.setScene(scene);
            SignUPstage.show();
            scene.setFill(TRANSPARENT);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        Stage stage = (Stage) btn_signUp.getScene().getWindow();
        stage.close();
    }

    /**
     * Open Admin Page
     */
    public void AdminLog() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminSideBar.fxml"));
            Stage Loggedstage = new Stage();
            Loggedstage.initStyle(StageStyle.UNDECORATED);
            Loggedstage.setScene(new Scene(root));
            Loggedstage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Open Customer Page
     */
    public void CusLog() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CustomerSideBar.fxml"));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerSideBar.fxml"));
            root = loader.load();

            CustomerSideBarController cs = loader.getController();
            cs.setUsername(tf_username.getText());


            Stage Loggedstage = new Stage();
            Loggedstage.initStyle(StageStyle.UNDECORATED);
            Loggedstage.setScene(new Scene(root));
            Loggedstage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Open Cashier Page
     */
    public void CashLog() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CashierPage.fxml"));
            Stage Loggedstage = new Stage();
            Scene scene = new Scene(root);
            Loggedstage.initStyle(StageStyle.TRANSPARENT);
            Loggedstage.setScene(scene);
            Loggedstage.show();
            scene.setFill(TRANSPARENT);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    void HidePasswordOnAction(KeyEvent event) {
        password = pf_password.getText();
        tf_showPass.setText(password);
    }

    @FXML
    void ShowPasswordOnAction(KeyEvent event) {
        password = tf_showPass.getText();
        pf_password.setText(password);
    }

    @FXML
    void open_eye_onClicked(MouseEvent event) {
        tf_showPass.setVisible(false);
        img_seePass.setVisible(false);
        img_dontShowPass.setVisible(true);
        pf_password.setVisible(true);

    }

    @FXML
    void closed_eye_Onclicked(MouseEvent event) {
        tf_showPass.setVisible(true);
        img_seePass.setVisible(true);
        img_dontShowPass.setVisible(false);
        pf_password.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tf_showPass.setVisible(false);
        img_seePass.setVisible(false);
    }
}


