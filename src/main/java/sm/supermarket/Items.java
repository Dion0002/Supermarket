package sm.supermarket;

import javafx.beans.property.SimpleStringProperty;

public class Items {

        private final SimpleStringProperty ID;
        private final SimpleStringProperty Item_Name;
        private final SimpleStringProperty Price;
        private final SimpleStringProperty Quantity;
        private final SimpleStringProperty Category;
        private final SimpleStringProperty Description;

        public Items(String id, String item_cat,String price,String quantity,String category, String description) {
            this.ID = new SimpleStringProperty(id);
            this.Item_Name = new SimpleStringProperty(item_cat);
            this.Price = new SimpleStringProperty(price);
            this.Quantity = new SimpleStringProperty(quantity);
            this.Category = new SimpleStringProperty(category);
            this.Description = new SimpleStringProperty(description);
        }



    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getItem_Name() {
        return Item_Name.get();
    }

    public SimpleStringProperty item_NameProperty() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.Item_Name.set(item_Name);
    }

    public String getPrice() {
        return Price.get();
    }

    public SimpleStringProperty priceProperty() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price.set(price);
    }

    public String getQuantity() {
        return Quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        this.Quantity.set(quantity);
    }

    public String getCategory() {
        return Category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category.set(category);
    }

    public String getDescription() {
        return Description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description.set(description);
    }
}
