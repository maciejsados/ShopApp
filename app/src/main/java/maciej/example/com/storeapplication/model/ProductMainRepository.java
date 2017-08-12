package maciej.example.com.storeapplication.model;


import java.util.Arrays;
import java.util.List;


public class ProductMainRepository {

    private List<ProductMain> productMains = Arrays.asList(
            new ProductMain(1),
            new ProductMain(2)
    );

    private static ProductMainRepository productRepository;
    public static ProductMainRepository getInstance(){
        if(productRepository == null){
            productRepository = new ProductMainRepository();
        }
        return productRepository;
    }

    public ProductMain getProductById(int id) {

        for (ProductMain productMain : productMains) {
            if (productMain.getId() == id) {
                return productMain;
            }
        }
        return null;
    }

    public List<ProductMain> getProducts() {
        return productMains;
    }
}





