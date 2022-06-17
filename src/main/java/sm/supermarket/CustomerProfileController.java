package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class CustomerProfileController implements Initializable {
    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private JFXButton btn_add;
    @FXML
    private JFXButton btn_addPhoto;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_update;
    @FXML
    private JFXComboBox<String> cb_role;


    @FXML
    private DatePicker dp_dob;
    @FXML
    private ToggleGroup gender;
    @FXML
    private ImageView img_photo;
    @FXML
    private javafx.scene.control.Label lbl_address;
    @FXML
    private javafx.scene.control.Label lbl_birthday;
    @FXML
    private javafx.scene.control.Label lbl_customerID;
    @FXML
    private javafx.scene.control.Label lbl_firstname;
    @FXML
    private javafx.scene.control.Label lbl_gender;
    @FXML
    private javafx.scene.control.Label lbl_lastname;
    @FXML
    private javafx.scene.control.Label lbl_password;
    @FXML
    private javafx.scene.control.Label lbl_phoneNo;
    @FXML
    private javafx.scene.control.Label lbl_role;
    @FXML
    private javafx.scene.control.Label lbl_username;

    @FXML
    private PasswordField pf_password;
    @FXML
    private JFXRadioButton rb_female;
    @FXML
    private JFXRadioButton rb_male;
    @FXML
    private javafx.scene.control.TextArea ta_address;

    @FXML
    private javafx.scene.control.TextField tf_customerID;
    @FXML
    private javafx.scene.control.TextField tf_firstname;
    @FXML
    private javafx.scene.control.TextField tf_lastname;
    @FXML
    private javafx.scene.control.TextField tf_phoneNo;
    @FXML
    private javafx.scene.control.TextField tf_search;
    @FXML
    private TextField tf_username;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }



    public void getData(String username){
        System.out.println(username);
                    try {

                        String query = "select * from customers where Username = ?";
                        PreparedStatement ps = conDB.prepareStatement(query);
                        ps.setString(1, username);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            tf_customerID.setText(rs.getString("ID"));
                            tf_firstname.setText(rs.getString("Firstname"));
                            tf_lastname.setText(rs.getString("Lastname"));
                            dp_dob.getEditor().setText(rs.getString("Birthday"));


                            if (null != rs.getString("Gender")) switch (rs.getString("Gender")) {
                                case "Male":
                                    rb_male.setSelected(true);
                                    break;
                                case "Female":
                                    rb_female.setSelected(true);
                                    break;
                                default:
                                    rb_male.setSelected(false);
                                    rb_female.setSelected(false);
                            }
                            else {
                                rb_male.setSelected(false);
                                rb_female.setSelected(false);
                            }

                            ta_address.setText(rs.getString("Address"));
                            tf_phoneNo.setText(rs.getString("Phone"));
                            tf_username.setText(rs.getString("Username"));
                            pf_password.setText(rs.getString("Password"));
                            cb_role.setValue(rs.getString("Role"));


                        }

                        ps.close();
                        rs.close();


                    } catch (Exception ex) {
                        ex.printStackTrace();
                        ex.getCause();
                    }}







}//class














