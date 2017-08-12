package maciej.example.com.storeapplication.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.db.dbCart.Cart;
import maciej.example.com.storeapplication.db.dbCart.DBCartHelper;


public class SecondActivity extends AppCompatActivity {

    private Dao<Cart, Long> cartDao;


    @BindView(R.id.product_add_name)
    TextView textView_name;
    @BindView(R.id.product_add_price)
    TextView textView_price;
    @BindView(R.id.product_add_quantity)
    TextView textView_quantity;
    @BindView(R.id.product_total_price)
    TextView textView_total_price;


    @BindView(R.id.add_cart_btn)
    Button addBtn;

    @BindView(R.id.pre_cart_view)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ButterKnife.bind(this);



        DBCartHelper helper = OpenHelperManager.getHelper(this, DBCartHelper.class);
        cartDao = helper.getCartDao();
        addToCart();


        getingIntent();
        totalPrice();





    }

    private void getingIntent() {
        String key = getIntent().getStringExtra("key");
        String key1 = getIntent().getStringExtra("key1");
        String key2 = getIntent().getStringExtra("key2");


        textView_name.setText(key);
        textView_price.setText(key1);
        textView_quantity.setText(key2);




        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("byteArray");

        imageView.setImageBitmap(bmp);

    }

    private void totalPrice() {
        String result = "";
        try {
            String s1 =textView_price.getText().toString();
            String s = textView_quantity.getText().toString();

            int value = Integer.parseInt(s1) * Integer.parseInt(s);
            result = ""+value;
        } catch (Exception e) {

            result = " ";
        }

        textView_total_price.setText(result);
    }

    private void addToCart() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textView_name.getText().toString();
                String s1 = textView_price.getText().toString();
                String s2 = textView_quantity.getText().toString();
                String s3 = textView_total_price.getText().toString();
                Cart cart = new Cart();
                cart.setProductName(s);
                cart.setProductPrice(s1);
                cart.setProductQuantity(s2);
                cart.setTotalPrice(s3);

                try {
                    cartDao.create(cart);
                    Toast.makeText(SecondActivity.this, "Product added to the cart.", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(SecondActivity.this, "Failed, try again.", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mycartAdd) {
            Intent i = new Intent(this, MyCart.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.continue_shopping) {
            startActivity(new Intent(this, FruitsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
