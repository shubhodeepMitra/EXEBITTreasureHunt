package in.ac.nie.www.exebit;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class Clues extends Activity {

    public long time_left,sec,mins,timeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clues);

        /**
         * Start of the timer
         */
        /**
         * Receiving value from clues
         */
        Bundle b1 = getIntent().getExtras();
        if(b1 !=null)
           timeValue = b1.getLong("time");

        else
            timeValue=300000;

        Context context = getApplicationContext();
        CharSequence text = "All the Best!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        final TextView time_mins= (TextView) findViewById(R.id.time_mins);
        final TextView time_sec= (TextView) findViewById(R.id.time_sec);

        new CountDownTimer(timeValue, 1000) {

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

        /**
         * code for the submit button
         */
        Button qr=(Button)findViewById(R.id.qr);
        qr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on cl
                Toast toast = Toast.makeText(getApplicationContext(), "Submit", Toast.LENGTH_SHORT);
                toast.show();


            }
        });


        /**
         *
         * code for the scan button to go to the scan activity
         */

        Button scan=(Button)findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * switching to activity scan
                 */
                Intent intent = new Intent(Clues.this, question.class);
                intent.putExtra("time",time_left-500);
                startActivity(intent);
                Clues.this.finish();


            }
        });

    }
    /**
     * Overiding the back button of the phone to exit the app and popping an alert
     */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to QUIT?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                }).setNegativeButton("No", null).show();

    }

}
