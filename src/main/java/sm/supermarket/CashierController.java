package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.TRANSPARENT;

public class CashierController implements Initializable {


    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    ObservableList<Cart> cart = FXCollections.observableArrayList();

    @FXML
    private JFXButton btn_ShowBill;
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
    private TableView<Cart> tbl_cart;
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
    @FXML
    private Label lbl_description;
    @FXML
    private Label lbl_totalDiscount;
    @FXML
    private JFXButton btn_calculateDiscount;
    @FXML
    private Label lbl_qtyPrice;

    /**
     * generate random Id code for the order
     */
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
        String Oid = lbl_orderID.getText();
        Cart.OrderID = Oid;

    }

    /**
     * genederate the date and time
     */
    public void generateDateTime() {
        lbl_OrderDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, (e) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            lbl_time.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1.0D)));
        timeline.setCycleCount(-1);
        timeline.play();

        String time = lbl_time.getText();
        Cart.Time = time;
    }

    /**
     * logout button
     *
     * @param event
     */
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

    /**
     * Show all the items that are inserted into the cart(table)
     *
     * @param event
     */
    public void ShowBill(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PrintBill.fxml"));
            Stage PrintBill = new Stage();
            Scene scene = new Scene(root);
            PrintBill.initStyle(StageStyle.TRANSPARENT);
            PrintBill.setScene(scene);
            PrintBill.show();
            scene.setFill(TRANSPARENT);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        empty();
        tbl_cart.getItems().clear();
        lbl_ItemCount.setText(String.valueOf(0));
        lbl_total.setText(String.valueOf(0));
        lbl_Discount.setText(String.valueOf(0));
        lbl_totalDiscount.setText(String.valueOf(0));
        generateCode();
        generateDateTime();


    }

    /**
     * Search item by their id
     */
    public void searchItem() {
        String id = tf_ItemID.getText();

        String sql = "Select Item_Name ,Price,Description from add_item where ID='" + id + "'";
        boolean found = false;

        try (PreparedStatement pst = conDB.prepareStatement(sql)) {

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    found = true;
                    tf_ItemName.setText(rs.getString("Item_Name"));
                    tf_price.setText(rs.getString("Price"));
                    lbl_description.setText(rs.getString("Description"));


                }

            } catch (SQLException e) {
                e.printStackTrace();
                e.getCause();
            }

            if (!found) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Items");
                alert.setHeaderText("Searched item not found");
                alert.setContentText("Try again");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Search Customer by there username
     */
    public void searchCustomer() {
        String Uname = tf_username.getText();


        String sql = "Select Firstname,Lastname,Phone,Birthday from customers where Username='" + Uname + "'";
        boolean found = false;

        try (PreparedStatement pst = conDB.prepareStatement(sql)) {

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    found = true;
                    tf_firstname.setText(rs.getString("Firstname"));
                    tf_lastname.setText(rs.getString("Lastname"));
                    tf_phoneNumber.setText(rs.getString("Phone"));
                    dp_dob.setValue(LocalDate.parse(rs.getString("Birthday")));
                    lbl_Discount.setText(String.valueOf(10));
                    String dis = lbl_Discount.getText();
                    Cart.dis = Integer.parseInt(dis);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                e.getCause();
            }

            if (!found) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Customer");
                alert.setHeaderText("Searched Customer not found");
                alert.setContentText("Try again");
                alert.showAndWait();
                lbl_Discount.setText(String.valueOf(0));
                empty();


            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Display the cashier username from login
     */
    public void cashUser() {
        lbl_cachierUsername.setText(String.valueOf(UserRole.username));
    }

    /**
     * Clear fields
     */
    public void empty() {
        tf_username.setText("");
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_phoneNumber.setText("");
        dp_dob.getEditor().setText("");
        tf_ItemID.setText("");
        tf_ItemName.setText("");
        tf_price.setText("");
        tf_quantity.setText("");
        lbl_description.setText("");


    }

    /**
     * Add items to the cart
     */
    public void addCart() {


        int price = Integer.parseInt(tf_price.getText());
        int qunatity = Integer.parseInt(tf_quantity.getText());


        String OrderID = lbl_orderID.getText();
        String ItemID = tf_ItemID.getText();
        String ItemName = tf_ItemName.getText();
        String decrip = lbl_description.getText();

        String Itemprice = tf_price.getText();
        String ItemQty = tf_quantity.getText();
        String QtyPrice = Integer.toString(price * qunatity);
        lbl_qtyPrice.setText(QtyPrice);

        String Total = lbl_qtyPrice.getText();

        try {

            pst = conDB.prepareStatement("INSERT INTO orderitems(ItemID,OrderItemID,Item_Name,Item_Dec,ItemPrice,Item_QTY,Total) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, ItemID);
            pst.setString(2, OrderID);
            pst.setString(3, ItemName);
            pst.setString(4, decrip);
            pst.setString(5, Itemprice);
            pst.setString(6, ItemQty);
            pst.setString(7, Total);
            pst.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        tableOrder();
        ItemCount();
        FinalTotal();

    }

    public void RemoveItem(ActionEvent event) {

        int id = Integer.parseInt(tf_ItemID.getText());
        String orderID = lbl_orderID.getText();
        String query = "delete from orderitems where ItemID = ? AND OrderItemID = ?";
        try {

            pst = conDB.prepareStatement(query);
            pst.setString(1, String.valueOf(id));
            pst.setString(2, orderID);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Remove Item");
        alert.setTitle("Do you want to remove this items");
        alert.setContentText("Item Removed");
        alert.showAndWait();
        tableOrder();
        ItemCount();
        FinalTotal();
        empty();


    }

    private void tableOrder() {
        final ObservableList<Cart> carts = FXCollections.observableArrayList();
        String OrderID = lbl_orderID.getText();

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
            tbl_cart.setItems(carts);

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

        tbl_cart.setOnMouseClicked(e -> {
            try {


                Cart orderCart = tbl_cart.getSelectionModel().getSelectedItem();
                String query = "select * from orderitems where ItemID = ?";
                PreparedStatement ps = conDB.prepareStatement(query);
                ps.setString(1, orderCart.getId());
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    tf_ItemID.setText(rs.getString("ItemID"));
                    tf_ItemName.setText(rs.getString("Item_Name"));
                    lbl_description.setText(rs.getString("Item_Dec"));
                    tf_price.setText(rs.getString("ItemPrice"));
                    tf_quantity.setText(rs.getString("Item_QTY"));


                }


            } catch (Exception ex) {
                ex.printStackTrace();
                ex.getCause();
            }

        });

    }


    public void ItemCount() {

        int quantity = 0;
        for (Cart value : tbl_cart.getItems()) {
            quantity += Integer.parseInt(value.getQuantity());
            lbl_ItemCount.setText(String.valueOf(quantity));
        }

    }

    public void FinalTotal() {

        int total = 0;
        for (int i = 0; i < tbl_cart.getItems().size(); i++) {
            total = total + Integer.valueOf(String.valueOf(tbl_cart.getColumns().get(5).getCellObservableValue(i).getValue()));
            lbl_total.setText(String.valueOf(total));
            lbl_totalDiscount.setText(String.valueOf(total));
            Cart.totalDis = total;
        }
    }

    public void TotalDiscount() {
        int total = Integer.parseInt(lbl_total.getText());
        double dis = Integer.parseInt(lbl_Discount.getText());
        total = (int) (total - (total * dis / 100));
        lbl_totalDiscount.setText(String.valueOf(total));
        Cart.totalDis = total;
    }

    public void SaveOrder() {

        String OrderID = lbl_orderID.getText();
        String CashierUsername = lbl_cachierUsername.getText();
        String OrderDate = lbl_OrderDate.getText();
        String OrderTime = lbl_time.getText();
        String CustomerUsername = tf_username.getText();
        String Total = lbl_total.getText();
        String TotalDiscount = lbl_totalDiscount.getText();

        String sql = "INSERT INTO cashierorder_table(OrderID,CashierUsername,OrderDate,OrderTime,CustomerUsername,Total,Total_With_Discount)VALUES(?,?,?,?,?,?,?)";
        try {
            pst = conDB.prepareStatement(sql);
            pst.setString(1, OrderID);
            pst.setString(2, CashierUsername);
            pst.setString(3, OrderDate);
            pst.setString(4, OrderTime);
            pst.setString(5, CustomerUsername);
            pst.setString(6, Total);
            pst.setString(7, TotalDiscount);
            pst.executeUpdate();


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Order");
            alert.setTitle("New Order");
            alert.setContentText("Order Saved");
            alert.showAndWait();


            //updateQuantity();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cashUser();
        generateCode();
        generateDateTime();
        tableOrder();


        String Cname = lbl_cachierUsername.getText();
        Cart.CashUsername = Cname;
        String date = lbl_OrderDate.getText();
        Cart.Date = date;


    }
}
