package maciej.example.com.storeapplication.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;

import maciej.example.com.storeapplication.model.ProductMainRepository;
import maciej.example.com.storeapplication.model.ProductMainViewAdapter;
import maciej.example.com.storeapplication.user.RegisterUserActivity;
import maciej.example.com.storeapplication.user.UserLoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigation)
    NavigationView navigationView;

    @BindView(R.id.product_main_recycler)
    RecyclerView recyclerView;

    private ActionBarDrawerToggle actionBarDrawerToggle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(this);
        ProductMainViewAdapter productListAdapter =
                new ProductMainViewAdapter(this, ProductMainRepository.getInstance().getProducts());
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();

        int id = item.getItemId();

        switch (id) {
            case R.id.home:
                return true;
            case R.id.mycart:
                Intent intent1 = new Intent(this, MyCart.class);
                startActivity(intent1);
                return true;
            case R.id.about:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);
                return true;
            case R.id.login:
                Intent intent3 = new Intent(this, UserLoginActivity.class);
                startActivity(intent3);
                return true;
            case R.id.register:
                Intent intent4 = new Intent(this, RegisterUserActivity.class);
                startActivity(intent4);
                return true;

        }
        return false;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mycart) {
            Intent i = new Intent(this, MyCart.class);
            startActivity(i);
            return true;
        }
        if (item.getItemId() == R.id.settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
