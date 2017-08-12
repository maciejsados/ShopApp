package maciej.example.com.storeapplication.user;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.activity.MainActivity;
import maciej.example.com.storeapplication.db.Users;
import maciej.example.com.storeapplication.userModel.UserAccount;

public class UserLoginActivity extends AppCompatActivity {


    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    private ListView listView;
    private LinearLayout layout;
    private TextInputEditText userName;
    private TextInputEditText userPassword;
    private Dao<Users, Long> usersLongDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);


        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        userName = (TextInputEditText) findViewById(R.id.username);
        userPassword = (TextInputEditText) findViewById(R.id.password);
        final Button btn = (Button) findViewById(R.id.btn);
        Button registerBtn = (Button) findViewById(R.id.loginRegisterBtn);
        layout = (LinearLayout) findViewById(R.id.layout);

        Intent intent = getIntent();
        UserAccount account = (UserAccount) intent.getSerializableExtra(RegisterUserActivity.EXTRA_ACCOUNT);
        if (account != null) {
            userName.setText(account.getEmail());
            userPassword.setText(account.getPassword());
            Toast.makeText(this, "Account created", Toast.LENGTH_LONG).show();
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameWrapper.getEditText().getText().toString();
                String password = usernameWrapper.getEditText().getText().toString();
                if (!validateEmail(username) && !validatePassword(password)) {
                    usernameWrapper.setError("Not a valid email address!");
                    passwordWrapper.setError("Not a valid password!");
                    Toast.makeText(getApplicationContext(), "Login is equal to your email, password must consist of at least 4 characters", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(UserLoginActivity.this, MainActivity.class));
                }

            }

        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserLoginActivity.this, RegisterUserActivity.class);
                startActivity(i);
            }
        });


    }



    public boolean validatePassword(String password) {
        return password.length() >= 4;
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
