package maciej.example.com.storeapplication.model;

import java.util.Arrays;
import java.util.List;



public class ProductRepository {

    private List<Product> products = Arrays.asList(
            new Product(1, "Bananas", "4", "0", "1 kg"),
            new Product(2, "Oranges", "5", "0", "1 kg"),
            new Product(3, "Apples", "3", "0", "1 kg"),
            new Product(4, "Strawberries", "8","0", "1 kg"),
            new Product(5, "Plums", "6", "0", "1 kg"),
            new Product(6, "Pears", "4", "0", "1 kg"),
            new Product(7, "Avocado", "9", "0", "1 piece"),
            new Product(8, "Raspberries", "8", "0", "1 kg"),
            new Product(9, "Watermelon", "7", "0", "1 kg"),
            new Product(10, "Pineapple", "9", "0", "1 kg")


    );

    private static ProductRepository productRepository;
    public static ProductRepository getInstance(){
        if(productRepository == null){
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public Product getProductById(int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
