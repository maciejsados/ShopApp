package maciej.example.com.storeapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.model.ProductRecyclerViewAdapter;
import maciej.example.com.storeapplication.model.ProductRepository;


public class FruitsActivity extends AppCompatActivity {


    @BindView(R.id.products_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.checkout_amount)
    TextView checkAmountView;

    @BindView(R.id.cart_image)
    ImageView cartImage;

    @BindView(R.id.goToCartButton)
    Button goCartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friuts);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        createRecyclewViewAdapter();
        onCartImageClick();
        goToCartButton();


    }

    private void onCartImageClick() {
        cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FruitsActivity.this, MyCart.class);
                startActivity(i);
            }
        });
    }

    private void goToCartButton(){
        goCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FruitsActivity.this, MyCart.class));
            }
        });

    }

    private void createRecyclewViewAdapter() {
        ProductRecyclerViewAdapter productListAdapter =
                new ProductRecyclerViewAdapter(this, ProductRepository.getInstance().getProducts());
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fruits_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.back) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }


}
