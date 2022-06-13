package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PrintBillController implements Initializable {


    @FXML
    private JFXButton btn_print;

    @FXML
    private Label lbl_orderDate;

    @FXML
    private Label lbl_orderID;

    @FXML
    private Label lbl_orderTime;

    @FXML
    private TextArea ta_texBill;
    @FXML
    private Label lbl_CashUsername;
    @FXML
    private Label lbl_iitem;


    public void print() {
        Stage stage = (Stage) btn_print.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lbl_orderID.setText(String.valueOf(Cart.OrderID));
        lbl_orderDate.setText(String.valueOf(Cart.Date));
        lbl_orderTime.setText(String.valueOf(Cart.Time));
        lbl_CashUsername.setText(String.valueOf(Cart.CashUsername));
        lbl_iitem.setText(String.valueOf(Cart.Bill));


    }
}
