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
import java.sql.Statement;
import java.time.LocalDate;


public class SignUpController {


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
    private ImageView img_confP1;

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
    private ImageView img_user;

    @FXML
    private ImageView img_userLogo;

    @FXML
    private ImageView img_phoneNumber;

    @FXML
    private Label lbl_confpasserror;

    @FXML
    private Label lbl_regsucc;

    @FXML
    private Label lbl_userReg;

    @FXML
    private PasswordField pf_confPass;

    @FXML
    private PasswordField pf_password;

    @FXML
    private JFXRadioButton rb_female;

    @FXML
    private JFXRadioButton rb_male;

    @FXML
    private TextArea ta_address;

    @FXML
    private TextField tf_firstname;

    @FXML
    private TextField tf_lastname;

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_phoneNo;

    @FXML
    private Label lbl_userrole;

    /**
     * This is for the goback button to open the login page
     *
     * @param event
     */
    public void GoBackButton(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage LoginPage = new Stage();
            LoginPage.initStyle(StageStyle.UNDECORATED);
            LoginPage.setScene(new Scene(root));
            LoginPage.show();

        }catch (Exception e){
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
        uservalidation();
        if (pf_password.getText().equals(pf_confPass.getText())) {
            lbl_confpasserror.setText("");

        } else {
            lbl_confpasserror.setText("*");
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


        JFXRadioButton selectedRB = (JFXRadioButton) gender.getSelectedToggle();
        String togglevalue = selectedRB.getText();

        LocalDate locald = dp_dob.getValue();

        String userrole= lbl_userrole.getText();





        String insertFields = "INSERT INTO customers(Firstname, Lastname, Username, Password, Gender, Address,Birthday,Role) VALUES ('";
        String inserValues = firstname + "','" + lastname + "','" +
                username + "','" + password + "','" + togglevalue + "','" + address + "','" + locald + "','" + userrole + "')";
        String inserSingup = insertFields + inserValues;

        try {
            Statement st = conDB.createStatement();
            st.executeUpdate(inserSingup);

            String sql = "INSERT INTO userlogin(Username,Password,Role) Values('"+username+"','"+password+"','"+userrole+"')";
            st.executeUpdate(sql);
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

