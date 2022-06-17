package sm.supermarket;

import javafx.beans.property.SimpleStringProperty;

public class Cart {
    protected static String CashUsername;
    private  final SimpleStringProperty id;
    private  final SimpleStringProperty ItemName;
    private  final SimpleStringProperty ItemDescription;
    private  final SimpleStringProperty price;
    private  final SimpleStringProperty quantity;
    private  final SimpleStringProperty total;
    protected static String OrderID;
    protected static String Date;
    protected static String Time;
    protected static int totalDis;
    protected static int dis;


    public Cart(String orderID, String date, String time, int totalDis, int dis, String cashUsername, String quantity,String id,String price ,String itemName,String itemDescription,String total) {
        OrderID = orderID;
        Date = date;
        Time = time;
        this.totalDis = totalDis;
        this.dis = dis;
        CashUsername = cashUsername;
        this.id = new SimpleStringProperty(id);
        this.ItemName =  new SimpleStringProperty(itemName);
        this.ItemDescription = new SimpleStringProperty(itemDescription);
        this.price =  new SimpleStringProperty(price);
        this.quantity =  new SimpleStringProperty(quantity);
        this.total =  new SimpleStringProperty(total);


    }


    public Cart(String id, String itemName, String itemDescription, String price, String quantity, String total) {
        this.id = new SimpleStringProperty(id);
        this.ItemName =  new SimpleStringProperty(itemName);
        this.ItemDescription = new SimpleStringProperty(itemDescription);
        this.price =  new SimpleStringProperty(price);
        this.quantity =  new SimpleStringProperty(quantity);
        this.total =  new SimpleStringProperty(total);
    }



    public static String getCashUsername() {
        return CashUsername;
    }

    public static void setCashUsername(String cashUsername) {
        CashUsername = cashUsername;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getItemName() {
        return ItemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        this.ItemName.set(itemName);
    }

    public String getItemDescription() {
        return ItemDescription.get();
    }

    public SimpleStringProperty itemDescriptionProperty() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.ItemDescription.set(itemDescription);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getTotal() {
        return total.get();
    }

    public SimpleStringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }

    public static String getOrderID() {
        return OrderID;
    }

    public static void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String date) {
        Date = date;
    }

    public static String getTime() {
        return Time;
    }

    public static void setTime(String time) {
        Time = time;
    }

    public static int getTotalDis() {
        return totalDis;
    }

    public static void setTotalDis(int totalDis) {
        Cart.totalDis = totalDis;
    }

    public static int getDis() {
        return dis;
    }

    public static void setDis(int dis) {
        Cart.dis = dis;
    }
}
