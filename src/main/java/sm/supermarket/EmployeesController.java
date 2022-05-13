package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class EmployeesController {

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_addPhoto;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXButton btn_search;

    @FXML
    private JFXButton btn_update;

    @FXML
    private JFXComboBox<?> cb_role;

    @FXML
    private DatePicker dp_dob;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ImageView img_photo;

    @FXML
    private Label lbl_address;

    @FXML
    private Label lbl_birthday;

    @FXML
    private Label lbl_empID;

    @FXML
    private Label lbl_firstname;

    @FXML
    private Label lbl_gender;

    @FXML
    private Label lbl_lastname;

    @FXML
    private Label lbl_password;

    @FXML
    private Label lbl_phoneNo;

    @FXML
    private Label lbl_role;

    @FXML
    private Label lbl_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private JFXRadioButton rb_female;

    @FXML
    private JFXRadioButton rb_male;

    @FXML
    private TextArea ta_address;

    @FXML
    private TableView<?> tbl_employee;

    @FXML
    private TextField tf_employeeID;

    @FXML
    private TextField tf_firstname;

    @FXML
    private TextField tf_lastname;

    @FXML
    private TextField tf_phoneNo;

    @FXML
    private TextField tf_search;

    @FXML
    private TextField tf_username;

}
