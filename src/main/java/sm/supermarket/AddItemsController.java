package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class AddItemsController implements Initializable {

    final ObservableList category = FXCollections.observableArrayList();
    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private JFXButton btn_addCategory;
    @FXML
    private JFXButton btn_addItem;
    @FXML
    private JFXButton btn_deleteCategory;
    @FXML
    private JFXButton btn_deleteItem;
    @FXML
    private JFXButton btn_updateCategory;
    @FXML
    private JFXButton btn_updateItem;
    @FXML
    private TableColumn<Items, String> column_itemPrice;
    @FXML
    private JFXComboBox<String> cmb_category;
    @FXML
    private TableColumn<ItemCategory, String> column_ItemCategory;
    @FXML
    private TableColumn<ItemCategory, String> column_catID;
    @FXML
    private TableColumn<ItemCategory, String> column_descript;
    @FXML
    private TableColumn<Items, String> column_ItemDescription;
    @FXML
    private TableColumn<Items, String> column_ItemID;
    @FXML
    private TableColumn<Items, String> column_ItemName;
    @FXML
    private TableColumn<Items, String> column_Category;
    @FXML
    private TableColumn<Items, String> column_itemQunatity;
    @FXML
    private Label lbl_categoryID;
    @FXML
    private Label lbl_itemID;
    @FXML
    private Label lbl_addItem;
    @FXML
    private Label lbl_addItemCategory;
    @FXML
    private Label lbl_catDescrip;
    @FXML
    private Label lbl_categoryItems;
    @FXML
    private Label lbl_decItem;
    @FXML
    private Label lbl_itemName;
    @FXML
    private Label lbl_itmCat;
    @FXML
    private Label lbl_price;
    @FXML
    private Label lbl_quantity;
    @FXML
    private TextArea ta_categDes;
    @FXML
    private TextArea ta_descriptionItem;
    @FXML
    private TableView<ItemCategory> tbl_category;
    @FXML
    private TableView<Items> tbl_itemes;
    @FXML
    private TextField tf_itemName;
    @FXML
    private TextField tf_itmcategory;
    @FXML
    private TextField tf_price;
    @FXML
    private TextField tf_qunatity;
    @FXML
    private TextField tf_searchItem;
    @FXML
    private TextField tf_searchcategory;

    @FXML
    void btn_AddCat(ActionEvent event) {
        addCategory();
        table();
    }

    @FXML
    void btn_UpdateCat(ActionEvent event) {
        updateCateg();
        table();
    }


    @FXML
    void btn_DeleteCat(ActionEvent event) {
        deleteCateg();
        table();
    }

    @FXML
    void btn_AddItems(ActionEvent event) {
        addItem();
        tableItem();

    }

    @FXML
    void btn_UpdateItems(ActionEvent event) {
        updateItem();
        tableItem();
    }

    @FXML
    void btn_DeleteItem(ActionEvent event) {
        deleteItem();
        tableItem();

    }

    /**
     * Add new category to the database
     */
    public void addCategory() {


        String ItemCategory = tf_itmcategory.getText();
        String Category_Description = ta_categDes.getText();

        try {

            pst = conDB.prepareStatement("INSERT INTO item_category(Item_Category,Description) VALUES(?,?)");
            pst.setString(1, ItemCategory);
            pst.setString(2, Category_Description);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Category");
            alert.setTitle("Add Category");
            alert.setContentText("Category Added");
            alert.showAndWait();
            cmbCateogry();
            empty();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    /**
     * update category
     */
    public void updateCateg() {


        String Item_cat = tf_itmcategory.getText();
        String DescriptionCat = ta_categDes.getText();


        try {
            int id = Integer.parseInt(lbl_categoryID.getText());
            String query = "Update item_category set Item_Category=?, Description=? Where ID ='" + id + "' ";
            pst = conDB.prepareStatement(query);
            pst.setString(1, Item_cat);
            pst.setString(2, DescriptionCat);
            pst.executeUpdate();


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Category Editing");
            alert.setTitle("Update Category");
            alert.setContentText("Category Updated");
            alert.showAndWait();
            cmbCateogry();
            empty();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    /**
     * update category
     */
    public void deleteCateg() {
        int id = Integer.parseInt(lbl_categoryID.getText());
        String query = "delete from item_category where id = ?";
        try {

            pst = conDB.prepareStatement(query);
            pst.setString(1, String.valueOf(id));
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Category Deleting");
        alert.setTitle("Delete Category");
        alert.setContentText("Category Deleted");
        alert.showAndWait();
        cmbCateogry();
        empty();

    }

    /**
     * Add new Items
     */
    public void addItem() {

        String Item_Name = tf_itemName.getText();
        String Quantity = tf_qunatity.getText();
        String Price = tf_price.getText();
        String Category = cmb_category.getSelectionModel().getSelectedItem();
        String Description_item = ta_descriptionItem.getText();


        try {

            pst = conDB.prepareStatement("INSERT INTO add_item(Item_Name,Price,Quantity,Category,Description) VALUES(?,?,?,?,?)");
            pst.setString(1, Item_Name);
            pst.setString(2, Price);
            pst.setString(3, Quantity);
            pst.setString(4, Category);
            pst.setString(5, Description_item);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Item");
            alert.setTitle("Add Item");
            alert.setContentText("Item Added");
            alert.showAndWait();
            emptyItem();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    /**
     * Update Items
     */
    public void updateItem() {


        String Item_Name = tf_itemName.getText();
        String Quantity = tf_qunatity.getText();
        String Price = tf_price.getText();
        String Category = cmb_category.getSelectionModel().getSelectedItem();
        String Description_item = ta_descriptionItem.getText();


        try {
            int id = Integer.parseInt(lbl_itemID.getText());
            String query = "Update add_item set Item_Name=?,  Price=?, Quantity=?, Category=?, Description=? Where ID ='" + id + "' ";
            pst = conDB.prepareStatement(query);
            pst.setString(1, Item_Name);
            pst.setString(2, Price);
            pst.setString(3, Quantity);
            pst.setString(4, Category);
            pst.setString(5, Description_item);
            pst.executeUpdate();


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Item Editing");
            alert.setTitle("Item Category");
            alert.setContentText("Item Updated");
            alert.showAndWait();
            emptyItem();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    /**
     * Delete Items
     */
    public void deleteItem() {
        int id = Integer.parseInt(lbl_itemID.getText());
        String query = "delete from add_item where id = ?";
        try {

            pst = conDB.prepareStatement(query);
            pst.setString(1, String.valueOf(id));
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Item Deleting");
        alert.setTitle("Delete Item");
        alert.setContentText("Item Deleted");
        alert.showAndWait();
        emptyItem();

    }

    /**
     * Show all categories to comobox
     */
    public void cmbCateogry() {
        category.clear();
        String query = "select Item_Category from item_category";
        try {
            pst = conDB.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                category.add(rs.getString("Item_Category"));
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display all categories in to the table
     */
    public void table() {

        final ObservableList<ItemCategory> itemCategories = FXCollections.observableArrayList();


        try {
            String query = "select * from item_category";
            pst = conDB.prepareStatement(query);
            rs = pst.executeQuery();
            {
                while (rs.next()) {
                    itemCategories.add(new ItemCategory(
                            rs.getString("ID"),
                            rs.getString("Item_Category"),
                            rs.getString("Description")
                    ));
                }

            }
            tbl_category.setItems(itemCategories);
            column_catID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            column_ItemCategory.setCellValueFactory(new PropertyValueFactory<>("Item_Category"));
            column_descript.setCellValueFactory(new PropertyValueFactory<>("Description"));
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        tbl_category.setOnMouseClicked(e -> {
                    try {

                        ItemCategory itemCat = tbl_category.getSelectionModel().getSelectedItem();
                        String query = "select * from item_category where ID = ?";
                        PreparedStatement ps = conDB.prepareStatement(query);
                        ps.setString(1, String.valueOf(itemCat.getID()));
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            lbl_categoryID.setText(rs.getString("ID"));
                            tf_itmcategory.setText(rs.getString("Item_Category"));
                            ta_categDes.setText(rs.getString("Description"));

                        }

                        ps.close();
                        rs.close();


                    } catch (Exception ex) {
                        ex.printStackTrace();
                        ex.getCause();
                    }

                    //select categories form the table
                    tbl_category.setOnKeyReleased(f -> {
                        if (f.getCode() == KeyCode.UP || f.getCode() == KeyCode.DOWN) {
                            try {


                                ItemCategory itemCat = tbl_category.getSelectionModel().getSelectedItem();
                                String query = "select * from item_category where ID = ?";
                                PreparedStatement ps = conDB.prepareStatement(query);
                                ps.setString(1, String.valueOf(itemCat.getID()));
                                ResultSet rs = ps.executeQuery();

                                while (rs.next()) {
                                    lbl_categoryID.setText(rs.getString("ID"));
                                    tf_itmcategory.setText(rs.getString("Item_Category"));
                                    ta_categDes.setText(rs.getString("Description"));

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
        //search categories through the search filed
        final FilteredList<ItemCategory> filteredList = new FilteredList<>(itemCategories, e -> true);
        tf_searchcategory.setOnKeyReleased(f -> {
            tf_searchcategory.textProperty().addListener((observableValue, oldValeu, newValue) -> {
                filteredList.setPredicate((Predicate<? super ItemCategory>) itemCat -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCase = newValue.toLowerCase();
                    if (itemCat.getID().contains(newValue)) {
                        return true;
                    } else if (itemCat.getItem_Category().toLowerCase().contains(newValue)) {
                        return true;
                    } else return itemCat.getDescription().toLowerCase().contains(newValue);
                });
            });
            SortedList<ItemCategory> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tbl_category.comparatorProperty());
            tbl_category.setItems(sortedList);
        });

    }

    /**
     * Display all items in to the table
     */
    public void tableItem() {

        final ObservableList<Items> items = FXCollections.observableArrayList();


        try {
            String query = "select * from add_item";
            pst = conDB.prepareStatement(query);
            rs = pst.executeQuery();
            {
                while (rs.next()) {
                    items.add(new Items(
                            rs.getString("ID"),
                            rs.getString("Item_Name"),
                            rs.getString("Price"),
                            rs.getString("Quantity"),
                            rs.getString("Category"),
                            rs.getString("Description")

                    ));
                }

            }
            tbl_itemes.setItems(items);
            column_ItemID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            column_ItemName.setCellValueFactory(new PropertyValueFactory<>("Item_Name"));
            column_itemPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            column_itemQunatity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            column_Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
            column_ItemDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        //select items form the table
        tbl_itemes.setOnMouseClicked(e -> {
                    try {

                        Items item = tbl_itemes.getSelectionModel().getSelectedItem();
                        String query = "select * from add_item where ID = ?";
                        PreparedStatement ps = conDB.prepareStatement(query);
                        ps.setString(1, String.valueOf(item.getID()));
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            lbl_itemID.setText(rs.getString("ID"));
                            tf_itemName.setText(rs.getString("Item_Name"));
                            tf_price.setText(rs.getString("Price"));
                            tf_qunatity.setText(rs.getString("Quantity"));
                            cmb_category.setValue(rs.getString("Category"));
                            ta_descriptionItem.setText(rs.getString("Description"));

                        }

                        ps.close();
                        rs.close();


                    } catch (Exception ex) {
                        ex.printStackTrace();
                        ex.getCause();
                    }


                    tbl_itemes.setOnKeyReleased(f -> {
                        if (f.getCode() == KeyCode.UP || f.getCode() == KeyCode.DOWN) {
                            try {


                                Items item = tbl_itemes.getSelectionModel().getSelectedItem();
                                String query = "select * from add_item where ID = ?";
                                PreparedStatement ps = conDB.prepareStatement(query);
                                ps.setString(1, String.valueOf(item.getID()));
                                ResultSet rs = ps.executeQuery();

                                while (rs.next()) {
                                    lbl_itemID.setText(rs.getString("ID"));
                                    tf_itemName.setText(rs.getString("Item_Name"));
                                    tf_price.setText(rs.getString("Price"));
                                    tf_qunatity.setText(rs.getString("Quantity"));
                                    cmb_category.setValue(rs.getString("Category"));
                                    ta_descriptionItem.setText(rs.getString("Description"));

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
        //search items through the search filed
        final FilteredList<Items> filteredList = new FilteredList<>(items, e -> true);
        tf_searchItem.setOnKeyReleased(f -> {
            tf_searchItem.textProperty().addListener((observableValue, oldValeu, newValue) -> {
                filteredList.setPredicate((Predicate<? super Items>) item -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCase = newValue.toLowerCase();
                    if (item.getID().contains(newValue)) {
                        return true;
                    } else if (item.getItem_Name().toLowerCase().contains(newValue)) {
                        return true;
                    } else return item.getQuantity().toLowerCase().contains(newValue);
                });
            });
            SortedList<Items> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tbl_itemes.comparatorProperty());
            tbl_itemes.setItems(sortedList);
        });

    }

    /**
     * clear the fields
     */
    public void empty() {
        tf_itmcategory.setText("");
        ta_categDes.setText("");
    }

    public void emptyItem() {
        tf_itemName.setText("");
        tf_price.setText("");
        tf_qunatity.setText("");
        ta_descriptionItem.setText("");
        cmb_category.setValue("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table();
        tableItem();
        cmb_category.setItems(category);
        cmbCateogry();

    }
}
