package in.ac.nie.www.exebit;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class question extends AppCompatActivity {


    public long time_left,sec,mins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        /**
         * Receiving value from clues
         */
        Bundle b1 = getIntent().getExtras();
        long longValue = b1.getLong("time");


        final TextView time_mins= (TextView) findViewById(R.id.time_mins);
        final TextView time_sec= (TextView) findViewById(R.id.time_sec);
        new CountDownTimer(longValue, 1000) {

            public void onTick(long millisUntilFinished) {
                time_left=millisUntilFinished;
                sec=(millisUntilFinished / 1000)%60;
                mins=millisUntilFinished / (1000*60);
                if(mins<10)
                    time_mins.setText("0"+millisUntilFinished / (1000*60));
                else
                    time_mins.setText("0"+millisUntilFinished / (1000*60));
                if(sec<10)
                    time_sec.setText(":0" + (millisUntilFinished / 1000)%60);
                else
                    time_sec.setText(":" + (millisUntilFinished / 1000)%60);

            }


            public void onFinish() {
                time_mins.setText("DO");
                time_sec.setText("NE!");
            }
        }.start();

        Button scan=(Button)findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * switching to activity scan
                 */
                Intent intent = new Intent(question.this, Clues.class);
                intent.putExtra("time",time_left-500);
                startActivity(intent);
                question.this.finish();


            }
        });
    }
}
