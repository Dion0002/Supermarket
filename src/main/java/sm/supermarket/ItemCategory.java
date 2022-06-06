package sm.supermarket;

import javafx.beans.property.SimpleStringProperty;

public class ItemCategory {
    private final SimpleStringProperty ID;
    private final SimpleStringProperty Item_Category;
    private final SimpleStringProperty Description;

    public ItemCategory(String id, String item_cat, String description) {
        this.ID = new SimpleStringProperty(id);
        this.Item_Category = new SimpleStringProperty(item_cat);
        this.Description = new SimpleStringProperty(description);
    }

    public String getID() {
        return ID.get();
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public String getItem_Category() {
        return Item_Category.get();
    }

    public void setItem_Category(String item_Category) {
        this.Item_Category.set(item_Category);
    }

    public SimpleStringProperty item_CategoryProperty() {
        return Item_Category;
    }

    public String getDescription() {
        return Description.get();
    }

    public void setDescription(String description) {
        this.Description.set(description);
    }

    public SimpleStringProperty descriptionProperty() {
        return Description;
    }
}
