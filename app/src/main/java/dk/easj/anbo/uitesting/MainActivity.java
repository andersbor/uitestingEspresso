package dk.easj.anbo.uitesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = findViewById(R.id.mainResultTextView);
    }

    public void countButtonClicked(View view) {
        counter++;
        resultView.setText(Integer.toString(counter));
    }

    public void nextButtonClicked(View view) {
        Intent intent = new Intent(this, AnotherActivity.class);
        startActivity(intent);

    }
}
