package maciej.example.com.storeapplication.model;

import android.view.View;
import android.widget.ImageView;



public class Product {

    private int id;
    private ImageView photo;
    private String name;
    private String price;
    private String priceInt;
    private String quantity;
    private String piece;

    private int addMore;
    private int subtractProduct;

    public Product(int id, String name, String price, String quantity, String piece) {
        this.id = id;
        this.name = name;
        this.price = price;

        this.quantity = quantity;
        this.piece = piece;

    }


    public String getPrice() {
        return price;
    }

    public ImageView getPhoto() {
        return photo;
    }


    public String getQuantity() {
        return quantity;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
