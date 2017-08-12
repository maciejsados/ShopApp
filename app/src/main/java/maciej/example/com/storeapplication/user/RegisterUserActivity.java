package maciej.example.com.storeapplication.user;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.activity.FruitsActivity;
import maciej.example.com.storeapplication.activity.MainActivity;
import maciej.example.com.storeapplication.activity.MyCart;
import maciej.example.com.storeapplication.db.DBHelper;
import maciej.example.com.storeapplication.db.Users;
import maciej.example.com.storeapplication.userModel.Gender;
import maciej.example.com.storeapplication.userModel.UserAccount;

public class RegisterUserActivity extends AppCompatActivity {
    public static final String EXTRA_ACCOUNT = "EXTRA_ACCOUNT";
    private Dao<Users, Long> usersDao;
    String userGender = "";

    @BindView(R.id.button_click)
    Button button;

    @BindView(R.id.layout)
    LinearLayout lineralLayout;

    @BindView(R.id.firstName)
    TextInputEditText firstName;

    @BindView(R.id.lastName)
    TextInputEditText lastName;

    @BindView(R.id.birthDate)
    TextInputEditText birthDate;

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    RadioButton radioButton;

    @BindView(R.id.address)
    TextInputEditText address;

    @BindView(R.id.country)
    TextInputEditText country;

    @BindView(R.id.phoneNumber)
    TextInputEditText phoneNumber;

    @BindView(R.id.email)
    TextInputEditText email;

    @BindView(R.id.password)
    TextInputEditText password;

    @BindView(R.id.confirm_password)
    TextInputEditText confirmPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        hideKeyboard();

        DBHelper dbHelper = OpenHelperManager.getHelper(this, DBHelper.class);
        usersDao = dbHelper.getUsersDao();





    }



    private void hideKeyboard() {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }



    @OnClick(R.id.button_click)
    public void createUserAccount(View view) {

        UserAccount account = getFormData();

        if (!account.isValid()) {
            Toast.makeText(RegisterUserActivity.this, "Complete all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isPasswordValid()) {
            Toast.makeText(RegisterUserActivity.this, "Password must be at least 4 characters long", Toast.LENGTH_SHORT).show();
            return;
        }

        onClickAddToBase();

        Intent intent = new Intent(this, UserLoginActivity.class);
        intent.putExtra(EXTRA_ACCOUNT, account);
        startActivity(intent);
    }

    private void onClickAddToBase() {
        String name = firstName.getText().toString();
        String lastN = lastName.getText().toString();
        String birth = birthDate.getText().toString();
        String street = address.getText().toString();
        String land = country.getText().toString();
        String phone = phoneNumber.getText().toString();
        String mail = email.getText().toString();
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String gender = radioButton.getText().toString();

        Users users = new Users();
        users.setUserName(name);
        users.setUserLastName(lastN);
        users.setBirthDate(birth);
        users.setGender(gender);
        users.setAddress(street);
        users.setCountry(land);
        users.setPhoneNumber(phone);
        users.setEmail(mail);


        try {
            usersDao.create(users);
            Toast.makeText(RegisterUserActivity.this, "Add", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(RegisterUserActivity.this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }


    private boolean isPasswordValid() {
        String password1 = password.getText().toString();
        String password2 = confirmPassword.getText().toString();
        return password1.equals(password2) && !TextUtils.isEmpty(password1) && password1.length() >= 4;
    }


    private UserAccount getFormData() {
        UserAccount account = new UserAccount();
        {
            account.setFirstName(firstName.getText().toString());
            account.setLastName(lastName.getText().toString());
            account.setBirthDate(birthDate.getText().toString());
            account.setGender(radioGroup.getCheckedRadioButtonId() == R.id.radioGroup ? Gender.MALE : Gender.FEMALE);
            account.setAddress(address.getText().toString());
            account.setCountry(country.getText().toString());
            account.setEmail(email.getText().toString());
            account.setPhoneNumber(phoneNumber.getText().toString());
            account.setPassword(password.getText().toString());
            account.setConfirmPassword(confirmPassword.getText().toString());
            return account;

        }
 }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.register_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.back_register) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}
