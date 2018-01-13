package smart.com.demo.child;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import smart.com.demo.R;


public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    Button MButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        MButton = findViewById(R.id.button_backward);
        MButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
