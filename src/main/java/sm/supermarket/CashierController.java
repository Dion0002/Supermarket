package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.TRANSPARENT;

public class CashierController implements Initializable {

    UserRole ur = new UserRole();
    LoginFromController login = new LoginFromController();
    Items items;
    @FXML
    private JFXButton btn_PrintBill;
    @FXML
    private JFXButton btn_SaveOrder;
    @FXML
    private JFXButton btn_addCart;
    @FXML
    private JFXButton btn_logout;
    @FXML
    private JFXButton btn_remove;
    @FXML
    private JFXButton btn_searchCustomer;
    @FXML
    private JFXButton btn_searchItemNAme;
    @FXML
    private TableColumn<?, ?> column_ItemDescription;
    @FXML
    private TableColumn<?, ?> column_itemID;
    @FXML
    private TableColumn<?, ?> column_itemName;
    @FXML
    private TableColumn<?, ?> column_price;
    @FXML
    private TableColumn<?, ?> column_quantity;
    @FXML
    private DatePicker dp_dob;
    @FXML
    private Label lbl_Discount;
    @FXML
    private Label lbl_ItemCount;
    @FXML
    private Label lbl_OrderDate;
    @FXML
    private Label lbl_cachierUsername;
    @FXML
    private Label lbl_orderID;
    @FXML
    private Label lbl_time;
    @FXML
    private Label lbl_total;
    @FXML
    private TableView<?> tbl_cart;
    @FXML
    private TextField tf_ItemID;
    @FXML
    private TextField tf_ItemName;
    @FXML
    private TextField tf_firstname;
    @FXML
    private TextField tf_lastname;
    @FXML
    private TextField tf_phoneNumber;
    @FXML
    private TextField tf_price;
    @FXML
    private TextField tf_quantity;
    @FXML
    private TextField tf_username;

    private void generateCode() {


        String code = "ABCDEFGHIKLMNOPQRSTVXYZ0123456789";
        String randCode = "";
        int length = 4;
        Random r = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = code.charAt(r.nextInt(code.length()));

            for (int j = 0; j < i; j++) {
                if (text[i] == text[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < text.length; i++) {
            randCode += text[i];
        }
        lbl_orderID.setText(randCode);


    }

    public void generateDateTime() {
        lbl_OrderDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, (e) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            lbl_time.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1.0D)));
        timeline.setCycleCount(-1);
        timeline.play();
    }

    public void logout(ActionEvent event) {
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

        Stage stage = (Stage) btn_logout.getScene().getWindow();
        stage.close();
    }


    public void searchItem() {
        try {
            String itemName = tf_ItemName.getText();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void cashUser() {

        lbl_cachierUsername.setText(String.valueOf(UserRole.username));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cashUser();
        generateCode();
        generateDateTime();
    }
}
