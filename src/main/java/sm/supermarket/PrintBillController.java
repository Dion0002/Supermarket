package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PrintBillController implements Initializable {


    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
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
    private TextArea ta_texBill;
    @FXML
    private TableView<Cart> tbl_OrderBill;


    /**
     * Save all the order receipt in to a text file
     * @throws IOException
     */
    public void print() throws IOException {
        String orderid = lbl_orderID.getText();
        String orderDate = lbl_orderDate.getText();
        String cash = lbl_CashUsername.getText();
        String dis = lbl_discount.getText();
        String total = lbl_total.getText();
        List data = new ArrayList();


        File file = new File("C:\\Users\\Dionb\\OneDrive\\Desktop\\SuperMarket\\receipt\\'"+orderid+"'-Order.txt");
        PrintWriter w = new PrintWriter(file);

        w.println("Order ID     Order Date       Cashier");
        w.println("\n"+orderid+"         "+orderDate+"       "+cash);
        w.println("\nProduct      Price   Quantity  Total");
        try{

            String query = "select Item_Name,ItemPrice,Item_Qty,Total from orderitems where OrderItemID='"+orderid+"'";
            Statement st = conDB.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String Itemname = rs.getString("Item_Name");
                String ItemPrice = rs.getString("ItemPrice");
                String ItemQty = rs.getString("Item_Qty");
                String ItemTotal = rs.getString("Total");

                data.add(Itemname+"        "+ItemPrice+"       "+ItemQty+"         "+ItemTotal);

            }
            for(Object s : data){
                w.println(s.toString());

            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }


        w.println("\nDiscount :                     "+dis);
        w.println("Total    :                     "+total);
        w.close();


        Stage stage = (Stage) btn_print.getScene().getWindow();
        stage.close();
    }


    /**
     * This table is for showing all the customer items into a receipt and selecting them by their order id
     */
    public void tableOrder() {
        final ObservableList<Cart> carts = FXCollections.observableArrayList();


        try {
            String query = "select ItemID,Item_Name,Item_Dec,ItemPrice,Item_Qty,Total from orderitems where OrderItemID=?";
            pst = conDB.prepareStatement(query);
            pst.setString(1, Cart.getOrderID());
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
