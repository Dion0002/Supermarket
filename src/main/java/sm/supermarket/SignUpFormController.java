package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import static javafx.scene.control.Alert.AlertType.WARNING;
import static javafx.scene.paint.Color.TRANSPARENT;

public class SignUpFormController {

    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private JFXButton btn_goback;
    @FXML
    private JFXButton btn_login;
    @FXML
    private DatePicker dp_dob;
    @FXML
    private ToggleGroup gender;
    @FXML
    private ImageView img_add;
    @FXML
    private ImageView img_confP;
    @FXML
    private ImageView img_dob;
    @FXML
    private ImageView img_firstname;
    @FXML
    private ImageView img_gender;
    @FXML
    private ImageView img_lastname;
    @FXML
    private ImageView img_pass;
    @FXML
    private ImageView img_phoneNumber;
    @FXML
    private ImageView img_user;
    @FXML
    private ImageView img_userLogo;
    @FXML
    private Label lbl_userrole;
    @FXML
    private TextField pf_confPass;
    @FXML
    private TextField pf_password;
    @FXML
    private JFXRadioButton rb_male;
    @FXML
    private JFXRadioButton rb_female;
    @FXML
    private TextArea ta_address;
    @FXML
    private TextField tf_firstname;
    @FXML
    private TextField tf_lastname;
    @FXML
    private TextField tf_phoneNo;
    @FXML
    private TextField tf_username;

    /**
     * This is for the goback button to open the login page
     *
     * @param event
     */
    public void GoBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
            Stage LoginPage = new Stage();
            Scene scene = new Scene(root);
            LoginPage.initStyle(StageStyle.TRANSPARENT);
            LoginPage.setScene(scene);
            LoginPage.show();
            scene.setFill(TRANSPARENT);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


        Stage stage = (Stage) btn_goback.getScene().getWindow();
        stage.close();
    }


    /**
     * Checking if the user password is equal with the confirmation password
     *
     * @param event
     */
    public void registrionButton(ActionEvent event) {

        if (!(pf_password.getText().equals(pf_confPass.getText()))) {
            Alert alert = new Alert(WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("Password are not the same");
            alert.showAndWait();

        } else {
            uservalidation();
            Stage stage = (Stage) btn_login.getScene().getWindow();
            stage.close();
            login();
        }

    }

    public void login() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
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
     * Adding the user input in the database
     */
    public void uservalidation() {
        DBConnection conn = new DBConnection();
        Connection conDB = conn.getConnection();

        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        String username = tf_username.getText();
        String password = pf_password.getText();
        String address = ta_address.getText();
        String phone = tf_phoneNo.getText();
        JFXRadioButton selectedRB = (JFXRadioButton) gender.getSelectedToggle();
        String togglevalue = selectedRB.getText();
        LocalDate birthday = dp_dob.getValue();
        String userrole = lbl_userrole.getText();


        try {
            String sql1 = "INSERT INTO customers(Firstname, Lastname, Username, Password, Gender, Address,Birthday,Phone,Role) VALUES (?,?,?,?,?,?,?,?,?)";
            pst = conDB.prepareStatement(sql1);
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, username);
            pst.setString(4, password);
            pst.setString(5, togglevalue);
            pst.setString(6, address);
            pst.setString(7, String.valueOf(birthday));
            pst.setInt(8, Integer.parseInt(phone));
            pst.setString(9, userrole);
            pst.executeUpdate();


            String sql = "INSERT INTO userlogin(Username,Password,Role) Values('" + username + "','" + password + "','" + userrole + "')";
            pst = conDB.prepareStatement(sql);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Customer Registration");
            alert.setTitle("Sign UP");
            alert.setContentText("Registration Successfully");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

}
