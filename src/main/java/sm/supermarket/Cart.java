package sm.supermarket;

public class Cart {
    protected static String CashUsername;
    protected static int id;
    protected static String ItemName;
    protected static String ItemDescription;
    protected static int price;
    protected static String quantity;
    protected static int total;
    protected static String OrderID;
    protected static String Date;
    protected static String Time;
    protected static int totalDis;
    protected static int dis;
    protected static String Bill;


    public Cart() {
    }


    public Cart(int id, String itemName, String itemDescription, int price, String quantity, int total, String orderID, String date, String time, int totalDis, int dis, String bill, String cashUsername) {
        Cart.id = id;
        ItemName = itemName;
        ItemDescription = itemDescription;
        Cart.price = price;
        Cart.quantity = quantity;
        Cart.total = total;
        OrderID = orderID;
        Date = date;
        Time = time;
        Cart.totalDis = totalDis;
        Cart.dis = dis;
        Bill = bill;
        CashUsername = cashUsername;

    }

    public static String getCashUsername() {
        return CashUsername;
    }

    public static void setCashUsername(String cashUsername) {
        CashUsername = cashUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Cart.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        Cart.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        Cart.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        Cart.total = total;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getTotalDis() {
        return totalDis;
    }

    public void setTotalDis(int totalDis) {
        Cart.totalDis = totalDis;
    }

    public int getDis() {
        return dis;
    }

    public void setDis(int dis) {
        Cart.dis = dis;
    }

    public String getBill() {
        return Bill;
    }

    public void setBill(String bill) {
        Bill = bill;

    }
}
