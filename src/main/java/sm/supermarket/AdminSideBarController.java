package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSideBarController implements Initializable {

    @FXML
    private BorderPane BoardPaneAdmin;

    @FXML
    private JFXButton btn_addItem;

    @FXML
    private JFXButton btn_allbuttons;

    @FXML
    private JFXButton btn_customer;

    @FXML
    private JFXButton btn_dashboard;

    @FXML
    private JFXButton btn_employees;

    @FXML
    private JFXButton btn_inventory;

    @FXML
    private JFXButton btn_logout;

    @FXML
    private VBox hbox_left;

    @FXML
    private ImageView img_addItem;

    @FXML
    private ImageView img_customer;

    @FXML
    private ImageView img_dash;

    @FXML
    private ImageView img_inventory;

    @FXML
    private ImageView img_logo;

    @FXML
    private ImageView img_logout;

    @FXML
    private ImageView img_reports;

    @FXML
    private ImageView img_staff;

    @FXML
    private Label lbl_fast;

    @FXML
    private Label lbl_market;

    @FXML
    private void add_item(MouseEvent event) {
        loadPage("AddItems");

    }

    @FXML
    private void all_reports(MouseEvent event) {
        loadPage("Reports");

    }

    @FXML
    private void customer(MouseEvent event) {
        loadPage("AdCustomer");
    }

    @FXML
    private void dashboard(MouseEvent event) {
        loadPage("Dashboard");

    }

    @FXML
    private void employees(MouseEvent event) {
        loadPage("Employees");

    }

    @FXML
    private void logout(MouseEvent event) {
        Stage stage = (Stage) btn_logout.getScene().getWindow();
        stage.close();

    }

    @FXML
    void inventory(MouseEvent event) {
        loadPage("Inventory");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadPage(String Page)  {
        Parent root = null;
        try {
           root = FXMLLoader.load(getClass().getResource(Page + ".fxml"));
        }catch (IOException e){
            e.printStackTrace();
            e.getCause();
        }
        BoardPaneAdmin.setCenter(root);

    }
}
