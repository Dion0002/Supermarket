package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PrintBillController implements Initializable {

    ObservableList<Cart> cart = FXCollections.observableArrayList();


    @FXML
    private JFXButton btn_print;

    @FXML
    private TableColumn<Cart, String> column_ItemDescription;

    @FXML
    private TableColumn<Cart, String> column_itemID;

    @FXML
    private TableColumn<Cart, String> column_itemName;

    @FXML
    private TableColumn<Cart, String> column_price;

    @FXML
    private TableColumn<Cart, String> column_quantity;

    @FXML
    private TableColumn<Cart, String> column_total;

    @FXML
    private Label lbl_CashUsername;

    @FXML
    private Label lbl_discount;

    @FXML
    private Label lbl_orderDate;

    @FXML
    private Label lbl_orderID;

    @FXML
    private Label lbl_total;

    @FXML
    private Label lbl_username;

    @FXML
    private TextArea ta_texBill;


    @FXML
    private TableView<Cart> tbl_OrderBill;


    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void print() {
        Stage stage = (Stage) btn_print.getScene().getWindow();
        stage.close();
    }

  public void tableOrder(){
      final ObservableList<Cart> carts = FXCollections.observableArrayList();
      String OrderID = lbl_orderID.getText();

      try {
          String query = "select ItemID,Item_Name,Item_Dec,ItemPrice,Item_Qty,Total from orderitems where OrderItemID=?";
          pst = conDB.prepareStatement(query);
          pst.setString(1,Cart.getOrderID());
          rs = pst.executeQuery();
          {
              while (rs.next()) {
                  carts.add(new Cart(
                          rs.getString("ItemID"),
                          rs.getString("Item_Name"),
                          rs.getString("Item_Dec"),
                          rs.getString("ItemPrice"),
                          rs.getString("Item_Qty"),
                          rs.getString("Total")


                  ));
              }

          }

          column_itemID.setCellValueFactory(new PropertyValueFactory<>("id"));
          column_itemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
          column_ItemDescription.setCellValueFactory(new PropertyValueFactory<>("ItemDescription"));
          column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
          column_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
          column_total.setCellValueFactory(new PropertyValueFactory<>("total"));
          tbl_OrderBill.setItems(carts);

      } catch (SQLException e) {
          e.printStackTrace();
          e.getCause();
      }
  }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       tableOrder();


        lbl_orderID.setText(String.valueOf(Cart.OrderID));
        lbl_orderDate.setText(String.valueOf(Cart.Date));
        lbl_CashUsername.setText(String.valueOf(Cart.CashUsername));
        lbl_total.setText(String.valueOf(Cart.totalDis));
        lbl_discount.setText(String.valueOf(Cart.dis));

    }
}
