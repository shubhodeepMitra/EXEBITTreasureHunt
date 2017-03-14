package in.ac.nie.www.exebit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start=(Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                /**
                 * Starting the clues activity
                 */

                Intent intent = new Intent(MainActivity.this, Clues.class);
                //intent.putExtra("time",300000);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });


    }
}
