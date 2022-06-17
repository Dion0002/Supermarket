package sm.supermarket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import javax.swing.table.TableColumn;
import javax.swing.text.TabableView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class CartList implements Initializable {

    // List of products
    @FXML
    private javafx.scene.control.TextField  searchItem;

    @FXML
    private TableView<Items> tb_product;

    @FXML
    private javafx.scene.control.TableColumn<Items, String> itemName;

    @FXML
    private javafx.scene.control.TableColumn<Items, String> itemPrice;

    @FXML
    private javafx.scene.control.TableColumn<Items, String> itemCategory;

    @FXML
    private Button addToList;

    //Cart List
    @FXML
    private TableView<Items>tb_cartList;

    @FXML
    private javafx.scene.control.TableColumn<Items, String>  listItemName;

    @FXML
    private javafx.scene.control.TableColumn<Items, String>  listItemPrice;

    @FXML
    private javafx.scene.control.TableColumn<Items, String>  listItemCategory;



    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;

    private void populateListItemTable() throws SQLException {

        final ObservableList<Items> items = FXCollections.observableArrayList();
        final ObservableList<Items> cartItems = FXCollections.observableArrayList();



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
            tb_product.setItems(items);
            itemName.setCellValueFactory(new PropertyValueFactory<>("Item_Name"));
            itemPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            itemCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
             } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        final FilteredList<Items> filteredList = new FilteredList<>(items, e -> true);
        searchItem.setOnKeyReleased(f -> {
            searchItem.textProperty().addListener((observableValue, oldValeu, newValue) -> {
                filteredList.setPredicate((Predicate<? super Items>) item -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCase = newValue.toLowerCase();
                    if (item.getID().contains(newValue)) {
                        return true;
                    } else if (item.getItem_Name().toLowerCase().contains(newValue)) {
                        return true;
                    } else return item.getCategory().toLowerCase().contains(newValue);
                });
            });
            SortedList<Items> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tb_product.comparatorProperty());
            tb_product.setItems(sortedList);
        });

        //Populate the cartlist by clicking the list of items

        tb_product.setOnMouseClicked(e -> {
         cartItems.add(tb_product.getSelectionModel().getSelectedItem());
        });
        tb_cartList.setItems(cartItems);
        listItemName.setCellValueFactory(new PropertyValueFactory<>("Item_Name"));
        listItemPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        listItemCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));

        tb_cartList.setOnMouseClicked(e -> {
            tb_cartList.getItems().removeAll(
                    tb_cartList.getSelectionModel().getSelectedItems()
            );
        });



    }






    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
        populateListItemTable();}
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }


    public void deleteBtn(javafx.event.ActionEvent actionEvent) {
        tb_cartList.getItems().clear();
    }

    public void createFile() {
        ObservableList<Items> i = tb_cartList.getItems();

        try{


                FileWriter writer = new FileWriter("C:\\Users\\Dionb\\OneDrive\\Desktop\\SuperMarket\\receipt\\output.txt");
                double sum = 0;
                for(Items str: i) {
                    sum += Double.valueOf(str.getPrice());
                    writer.write("Product Name : "+str.getItem_Name()+" Product Price "+str.getPrice()+ " ALL" + System.lineSeparator());

                }
                String total = "Total sum "+sum + " ALL";
                writer.write(total);
                writer.close();

            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.show();




        }catch (Exception e){
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.show();
        }

    }
    }

