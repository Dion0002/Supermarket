package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddItemsController {

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
    private TableColumn<?, ?> cloumn_itemPrice;

    @FXML
    private JFXComboBox<?> cmb_category;

    @FXML
    private TableColumn<?, ?> column_ItemCategory;

    @FXML
    private TableColumn<?, ?> column_ItemDescription;

    @FXML
    private TableColumn<?, ?> column_ItemID;

    @FXML
    private TableColumn<?, ?> column_ItemName;

    @FXML
    private TableColumn<?, ?> column_catID;

    @FXML
    private TableColumn<?, ?> column_descript;

    @FXML
    private TableColumn<?, ?> column_itemQunatity;

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
    private TableView<?> tbl_category;

    @FXML
    private TableView<?> tbl_itemes;

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

}
