package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {
    private final Desktop desktop = Desktop.getDesktop();
    int myIndex;
    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
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
    private JFXRadioButton rb_cashier;
    @FXML
    private TableColumn<Employee, String> column_address;
    @FXML
    private TableColumn<Employee, String> column_birthday;
    @FXML
    private TableColumn<Employee, String> column_firstname;
    @FXML
    private TableColumn<Employee, String> column_gender;
    @FXML
    private TableColumn<Employee, String> column_id;
    @FXML
    private TableColumn<Employee, String> column_lastname;
    @FXML
    private TableColumn<Employee, String> column_password;
    @FXML
    private TableColumn<Employee, String> column_phone;
    @FXML
    private TableColumn<Employee, String> column_photo;
    @FXML
    private TableColumn<Employee, String> column_role;
    @FXML
    private TableColumn<Employee, String> column_username;
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
    private TableView<Employee> tbl_employee;
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
    private Stage stage;
    private Image image;


    @FXML
    public void addBtn(ActionEvent event) {
        addEmployee();
        empty();
        table();


    }

    @FXML
    void updateEmployee(ActionEvent event) {
        updateEmp();
        table();

    }

    /**
     * Open A file to add a photo into the database
     */
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

    /**
     * Add new employee
     */
    public void addEmployee() {

        DBConnection conn = new DBConnection();
        Connection conDB = conn.getConnection();
        PreparedStatement pst;

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

        try {
            pst = conDB.prepareStatement("INSERT INTO employees(firstname,lastname,birthday,gender,address,phonenumber,username,password,role,photo) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setDate(3, Date.valueOf(locald));
            pst.setString(4, togglevalue);
            pst.setString(5, address);
            pst.setInt(6, phoneNumber);
            pst.setString(7, username);
            pst.setString(8, password);
            pst.setString(9, toggleRole);
            pst.setString(10, photoPath);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Employee Registration");
            alert.setTitle("Add Employee");
            alert.setContentText("Employee Added");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Remove all the filled field after adding new employee
     */
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

    /**
     * Fetch all the data from the database and display them on a table
     */
    public void table() {


        final ObservableList<Employee> employees = FXCollections.observableArrayList();
        try {
            ResultSet rs = conDB.createStatement().executeQuery("select * from employees");
            {
                while (rs.next()) {
                    employees.add(new Employee(rs.getString("id"), rs.getString("firstname"), rs.getString("lastname"),
                            rs.getString("birthday"), rs.getString("gender"), rs.getString("address"),
                            rs.getString("phonenumber"), rs.getString("username"), rs.getString("password"),
                            rs.getString("role"), rs.getString("photo")));

                }

            }
            tbl_employee.setItems(employees);
            column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            column_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            column_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            column_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
            column_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            column_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            column_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
            column_username.setCellValueFactory(new PropertyValueFactory<>("username"));
            column_password.setCellValueFactory(new PropertyValueFactory<>("password"));
            column_role.setCellValueFactory(new PropertyValueFactory<>("role"));
            column_photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        // When a row is clicked than all the information is displayed on the certain field
        tbl_employee.setOnMouseClicked(e -> {
            try {


                Employee emp = tbl_employee.getSelectionModel().getSelectedItem();
                String query = "select * from employees where ID = ?";
                PreparedStatement ps = conDB.prepareStatement(query);
                ps.setString(1, emp.getId());
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    tf_employeeID.setText(rs.getString("ID"));
                    tf_firstname.setText(rs.getString("Firstname"));
                    tf_lastname.setText(rs.getString("Lastname"));
                    dp_dob.getEditor().setText(rs.getString("Birthday"));
                    ta_address.setText(rs.getString("Address"));
                    tf_phoneNo.setText(rs.getString("Phonenumber"));
                    tf_username.setText(rs.getString("Username"));
                    pf_password.setText(rs.getString("Password"));

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

                    if (null != rs.getString("Role")) switch (rs.getString("Role")) {
                        case "Admin":
                            rb_admin.setSelected(true);
                            break;
                        case "Cashier":
                            rb_cashier.setSelected(true);
                            break;
                        default:
                            rb_admin.setSelected(false);
                            rb_cashier.setSelected(false);
                    }
                    else {
                        rb_admin.setSelected(false);
                        rb_cashier.setSelected(false);
                    }


                }

                ps.close();
                rs.close();


            } catch (Exception ex) {
                ex.printStackTrace();
                ex.getCause();
            }
        });

    }

    public void updateEmp(){
        DBConnection conn = new DBConnection();
        Connection conDB = conn.getConnection();
        PreparedStatement pst;
        int id = Integer.parseInt(tf_employeeID.getText());
        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        int phoneNumber = Integer.parseInt(tf_phoneNo.getText());
        String username = tf_username.getText();
        String password = pf_password.getText();
        String address = ta_address.getText();

        JFXRadioButton selectedRB = (JFXRadioButton) gender.getSelectedToggle();
        String togglevalue = selectedRB.getText();

        Date locald = Date.valueOf(dp_dob.getValue());

        JFXRadioButton selectRole = (JFXRadioButton) role.getSelectedToggle();
        String toggleRole = selectRole.getText();

        String photoPath = lbl_photoPath.getText();

        try {
            pst = conDB.prepareStatement("update employees set firstname = ?, lastname = ?, birthday = ?, gender = ?, address = ?," +
                    "phonenumber = ?, username = ?, password = ?, role = ?, photo = ? where id = ?");
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setDate(3, Date.valueOf(String.valueOf(locald)));
            pst.setString(4, togglevalue);
            pst.setString(5, address);
            pst.setInt(6, phoneNumber);
            pst.setString(7, username);
            pst.setString(8, password);
            pst.setString(9, toggleRole);
            pst.setString(10, photoPath);
            pst.setInt(11,id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Employee Editing");
            alert.setTitle("Update Employee");
            alert.setContentText("Employee Updated");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }














    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table();


    }


}
