package maciej.example.com.storeapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.storeapplication.R;

public class StartAppActivity extends AppCompatActivity {

    @BindView(R.id.textview_startapp)
    TextView textView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);
        ButterKnife.bind(this);


        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(500);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(StartAppActivity.this,
                            MainActivity.class);
                    startActivity(i);

                    finish();
                }
            }
        };

        welcomeThread.start();
        progressBar.setVisibility(View.VISIBLE);


    }
}
