package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;

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
    private JFXRadioButton cashier;

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
    private Label lbl_photoPath;

    @FXML
    private Label lbl_role;

    @FXML
    private Label lbl_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private JFXRadioButton rb_admin;

    @FXML
    private JFXRadioButton rb_female;

    @FXML
    private JFXRadioButton rb_male;

    @FXML
    private ToggleGroup role;

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

    private FileInputStream fis;
    private FileChooser fileChooser;
    private File file;
    private final Desktop desktop = Desktop.getDesktop();
    private Stage stage;
    private Image image;

    @FXML
    public void addBtn(ActionEvent event) {
        addEmployee();
        empty();

    }

    @FXML
    public void addPhoto() {

        FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("Image Files ", "*.png", "*.jpg", "*.gif");
        FileChooser.ExtensionFilter ex2 = new FileChooser.ExtensionFilter("All Files", "*.*");

        btn_addPhoto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(ex1, ex2);
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    lbl_photoPath.setText(file.getPath());
                    img_photo.setImage(new Image(file.toURI().toString()));
                }

            }
        });
    }


    public void addEmployee() {
        DBConnection conn = new DBConnection();
        Connection conDB = conn.getConnection();

        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        int phoneNumber = Integer.parseInt(tf_phoneNo.getText());
        String username = tf_username.getText();
        String password = pf_password.getText();
        String address = ta_address.getText();

        JFXRadioButton selectedRB = (JFXRadioButton) gender.getSelectedToggle();
        String togglevalue = selectedRB.getText();

        LocalDate locald = dp_dob.getValue();

        JFXRadioButton selectRole = (JFXRadioButton) role.getSelectedToggle();
        String toggleRole = selectRole.getText();

        String photoPath = lbl_photoPath.getText();


        String insertFields = "INSERT INTO employees(firstname,lastname,birthday,gender,address,phonenumber,username,password,role,photo) VALUES ('";
        String inserValues = firstname + "','" + lastname + "','" + locald + "','" + togglevalue +
                "','" + address + "','" + phoneNumber + "','" + username + "','"
                + password + "','" + toggleRole + "','" + photoPath + "')";
        String inserSingup = insertFields + inserValues;
        try {
            Statement st = conDB.createStatement();
            st.executeUpdate(inserSingup);
            System.out.println("yes");


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }


    public void empty() {
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_username.setText("");
        pf_password.setText("");
        ta_address.setText("");
        tf_phoneNo.setText("");
        dp_dob.setValue(null);
        Image image = new Image(getClass().getResourceAsStream("..\\..\\img\\buying_64px.png"));
        img_photo.setImage(image);
        JFXRadioButton selectedRB = (JFXRadioButton) gender.getSelectedToggle();
        selectedRB.setSelected(false);
        JFXRadioButton selectRole = (JFXRadioButton) role.getSelectedToggle();
        selectRole.setSelected(false);
    }

}
