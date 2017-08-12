package maciej.example.com.storeapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;

public class ProductItemActivity extends AppCompatActivity {

    @BindView(R.id.cart_plus_img)
    ImageView addProduct;
    @BindView(R.id.cart_minus_img)
    ImageView subtractProduct;
    @BindView(R.id.cart_product_quantity)
    TextView productQuantity;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
        ButterKnife.bind(this);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                productQuantity.setText(String.valueOf(count));
            }
        });

        subtractProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0) {
                    return;
                }
                count--;

                productQuantity.setText(String.valueOf(count));
            }
        });
    }
}
