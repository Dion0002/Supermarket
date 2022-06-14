package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static javafx.scene.control.Alert.AlertType.WARNING;

public class AdCustomerController  implements Initializable {

    final ObservableList<String> opsions = FXCollections.observableArrayList("Customer", "Silver Customer", "Gold Customer");
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
    private Label lbl_customerID;
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
    private TableView<Customer> tbl_customer;
    @FXML
    private TextField tf_customerID;
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


    @FXML
    public void addBtn(ActionEvent event) {
        addCustomer();
        table();


    }

    @FXML
    public void updateCustomer(ActionEvent event) {
        updateCustomer();
        table();

    }

    @FXML
    public void deleteBtn(ActionEvent event) {
        deleteEmp();
        empty();
        table();


    }

    public void addCustomer() {


        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        String birthday = dp_dob.getEditor().getText();
        String gen = ((JFXRadioButton) gender.getSelectedToggle()).getText();
        String address = ta_address.getText();
        String phoneNumber = tf_phoneNo.getText();
        String username = tf_username.getText();
        String password = pf_password.getText();
        String role = cb_role.getSelectionModel().getSelectedItem();


        if (validateFileds()) {
            try {

                pst = conDB.prepareStatement("insert into supermarket.customers(Firstname, Lastname, Username, Password, Gender, Address, Birthday, Phone, Role) VALUES(?,?,?,?,?,?,?,?,?)");
                pst.setString(1, firstname);
                pst.setString(2, lastname);
                pst.setString(3, username);
                pst.setString(4, password);
                pst.setString(5, gen);
                pst.setString(6, address);
                pst.setString(7, birthday);
                pst.setInt(8, Integer.valueOf(phoneNumber));
                pst.setString(9, role);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Customer Registration");
                alert.setTitle("Add Customer");
                alert.setContentText("Customer Added");
                alert.showAndWait();
                empty();
                String sql = "INSERT INTO userlogin(Username,Password,Role) Values('" + username + "','" + password + "','" + role + "')";
                pst.executeUpdate(sql);

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();

            }
        }
    }

    /**
     * Remove all the filled field after adding new employee
     */
    public void empty() {
        tf_customerID.setText("");
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_username.setText("");
        pf_password.setText("");
        ta_address.setText("");
        tf_phoneNo.setText("");
        dp_dob.setValue(null);
        dp_dob.getEditor().setText("");
        rb_female.setSelected(false);
        rb_male.setSelected(false);
        cb_role.setValue("");

    }

    private boolean validateFileds() {
        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        String phoneNumber = String.valueOf(tf_phoneNo.getText());
        String username = tf_username.getText();
        String password = pf_password.getText();
        String address = ta_address.getText();
        String birthday = dp_dob.getEditor().getText();


        if (firstname.isEmpty() | lastname.isEmpty() |
                birthday.isEmpty() | address.isEmpty() | phoneNumber.isEmpty() | username.isEmpty() | password.isEmpty()
        ) {

            Alert alert = new Alert(WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Into The Fields");
            alert.showAndWait();

            return false;

        }

        return true;
    }

    /**
     * Fetch all the data from the database and display them on a table
     */
    public void table() {

        final ObservableList<Customer> customers = FXCollections.observableArrayList();


        try {
            String query = "select * from customers";
            pst = conDB.prepareStatement(query);
            rs = pst.executeQuery();
            {
                while (rs.next()) {
                    customers.add(new Customer(
                            rs.getString("ID"),
                            rs.getString("Firstname"),
                            rs.getString("Lastname"),
                            rs.getString("Birthday"),
                            rs.getString("Gender"),
                            rs.getString("Address"),
                            rs.getString("Phone"),
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getString("Role")
                    ));
                }

            }
            tbl_customer.setItems(customers);
            column_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            column_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            column_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            column_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
            column_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            column_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            column_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
            column_username.setCellValueFactory(new PropertyValueFactory<>("username"));
            column_password.setCellValueFactory(new PropertyValueFactory<>("password"));
            column_role.setCellValueFactory(new PropertyValueFactory<>("role"));

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
//         When a row is clicked than all the information is displayed on the certain field
        tbl_customer.setOnMouseClicked(e -> {
                    try {


                        Customer customer = tbl_customer.getSelectionModel().getSelectedItem();
                        String query = "select * from customers where ID = ?";
                        PreparedStatement ps = conDB.prepareStatement(query);
                        ps.setString(1, String.valueOf(customer.getID()));
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
                    }


                    tbl_customer.setOnKeyReleased(f -> {
                        if (f.getCode() == KeyCode.UP || f.getCode() == KeyCode.DOWN) {
                            try {


                                Customer cus = tbl_customer.getSelectionModel().getSelectedItem();
                                String query = "select * from customers where ID = ?";
                                PreparedStatement ps = conDB.prepareStatement(query);
                                ps.setString(1, String.valueOf(cus.getID()));
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
                                    tf_phoneNo.setText(rs.getString("Phonenumber"));
                                    tf_username.setText(rs.getString("Username"));
                                    pf_password.setText(rs.getString("Password"));
                                    cb_role.setValue(rs.getString("Role"));


                                }

                                ps.close();
                                rs.close();


                            } catch (Exception ex) {
                                ex.printStackTrace();
                                ex.getCause();
                            }
                        }
                    });
                }
        );
        final FilteredList<Customer> filteredList = new FilteredList<>(customers, e -> true);
        tf_search.setOnKeyReleased(f -> {
            tf_search.textProperty().addListener((observableValue, oldValeu, newValue) -> {
                filteredList.setPredicate((Predicate<? super Customer>) customer -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCase = newValue.toLowerCase();
                    if (customer.getID().contains(newValue)) {
                        return true;
                    } else if (customer.getFirstname().toLowerCase().contains(newValue)) {
                        return true;
                    } else return customer.getLastname().toLowerCase().contains(newValue);
                });
            });
            SortedList<Customer> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tbl_customer.comparatorProperty());
            tbl_customer.setItems(sortedList);
        });

    }


    public void updateCustomer() {


        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        String phoneNumber = String.valueOf(tf_phoneNo.getText());
        String username = tf_username.getText();
        String password = pf_password.getText();
        String address = ta_address.getText();

        String gen = ((JFXRadioButton) gender.getSelectedToggle()).getText();

        String birthday = dp_dob.getEditor().getText();


        String role = cb_role.getSelectionModel().getSelectedItem();


        if (validateFileds()) {
            try {
                int id = Integer.parseInt(tf_customerID.getText());
                String query = "Update customers set FirstName=?, Lastname=?, Birthday=?, Gender=?, Address=?, Phone=?, Username=?, Password=?, Role=?  Where ID ='" + id + "' ";
                pst = conDB.prepareStatement(query);
                pst.setString(1, firstname);
                pst.setString(2, lastname);
                pst.setString(3, birthday);
                pst.setString(4, gen);
                pst.setString(5, address);
                pst.setInt(6, Integer.parseInt(phoneNumber));
                pst.setString(7, username);
                pst.setString(8, password);
                pst.setString(9, role);
                pst.executeUpdate();


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Customer Editing");
                alert.setTitle("Update Customer");
                alert.setContentText("Customer Updated");
                alert.showAndWait();
                empty();


            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();

            }
        }
    }


    public void deleteEmp() {
        int id = Integer.parseInt(tf_customerID.getText());
        String query = "delete from employees where id = ?";
        try {

            pst = conDB.prepareStatement(query);
            pst.setString(1, String.valueOf(id));
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Employee Deleting");
        alert.setTitle("Delete Employee");
        alert.setContentText("Employee Deleted");
        alert.showAndWait();
        empty();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table();
        cb_role.setItems(opsions);

    }


}
