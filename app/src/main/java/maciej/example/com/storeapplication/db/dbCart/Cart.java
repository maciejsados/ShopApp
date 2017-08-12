package maciej.example.com.storeapplication.db.dbCart;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "cart")
public class Cart {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String productName;

    @DatabaseField
    private String productPrice;

    @DatabaseField
    private String productQuantity;

    @DatabaseField
    private String totalPrice;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return  productName +
                ", Quantity: " + productQuantity
        +
               ", Total Price: " + totalPrice;

    }
}
