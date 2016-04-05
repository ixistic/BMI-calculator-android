package th.ac.ku.ixistic.bodymasscalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView bmiView;
    EditText h_text;
    EditText w_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        h_text = (EditText) findViewById(R.id.h_text);
        w_text = (EditText) findViewById(R.id.w_text);
        bmiView = (TextView) findViewById(R.id.bmi_text);
        Button bmiBtn = (Button) findViewById(R.id.bmi_btn);

        bmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float h = Float.parseFloat(h_text.getText().toString())/100;
                float w = Float.parseFloat(w_text.getText().toString());
                float bmi = w/(h*h);
                bmiView.setText(Float.toString(bmi));

                ImageView image = (ImageView) findViewById(R.id.bmi_view);

                if(bmi > 30){
                    image.setImageResource(R.drawable.fat);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
