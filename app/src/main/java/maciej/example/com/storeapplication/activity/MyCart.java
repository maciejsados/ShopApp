package maciej.example.com.storeapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.db.dbCart.Cart;
import maciej.example.com.storeapplication.db.dbCart.DBCartHelper;


public class MyCart extends AppCompatActivity {

    private Dao<Cart, Long> cartLongDao;

    @BindView(R.id.my_cart_go_store_button)
    Button button;
    @BindView(R.id.back_to_main)
    Button buton_back;
    @BindView(R.id.list_cart)
    ListView listView;
    @BindView(R.id.text_cart)
    TextView textView;
    ArrayAdapter adapter;
    List<Cart> cartList;


    static List<String> values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ButterKnife.bind(this);


        goToSore();


        DBCartHelper helper = OpenHelperManager.getHelper(this, DBCartHelper.class);
        cartLongDao = helper.getCartDao();
        loadFromBase();
        removeRawFromListView();
        backToMainActivity();


    }


    private void goToSore() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyCart.this, FruitsActivity.class));
            }
        });
    }

    private void backToMainActivity() {
        buton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyCart.this, MainActivity.class));
            }
        });
    }


    public void deleteOneByOne(String productName) {
        DBCartHelper helper1 = OpenHelperManager.getHelper(MyCart.this, DBCartHelper.class);

        Dao<Cart, Long> cartDao = helper1.getCartDao();
        DeleteBuilder<Cart, Long> cartLongDeleteBuilder = cartDao.deleteBuilder();

        try {

            cartLongDeleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private void loadFromBase() {


        try {
            cartList = cartLongDao.queryForAll();
            values = getFromCartDB(cartList);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
            listView.setAdapter(adapter);


        } catch (SQLException e) {
            e.printStackTrace();


        }


    }


    private void removeRawFromListView() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String item = values.get(i);
                values.remove(item);
                adapter.notifyDataSetChanged();


            }
        });

    }


    private List<String> getFromCartDB(List<Cart> cartList) {
        List<String> values = new ArrayList<>();

        for (Cart tmpCart : cartList) {
            values.add(tmpCart.toString());
        }
        return values;
    }

    public void removeFromCartwithDialogWindow() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyCart.this);
        alertDialog.setTitle("Remove products from cart");
        alertDialog
                .setCancelable(true)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteOneByOne("productName");
                        Toast.makeText(MyCart.this, "Products have been removed", Toast.LENGTH_SHORT).show();
                        startActivity(getIntent());

                    }

                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertDialog.create();
        alertDialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.delete) {
            removeFromCartwithDialogWindow();

        }
        if (item.getItemId() == R.id.continue_shopping) {
                    }

        return super.onOptionsItemSelected(item);
    }

}


