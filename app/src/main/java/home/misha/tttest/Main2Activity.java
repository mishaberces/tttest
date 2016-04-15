package home.misha.testy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
  TextView textView1, textView2,  timer_text;
    MyTimerTask mMyTimerTask;
    Timer timer=new Timer();
    long startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);

        Pytannja pytannja=(Pytannja)getIntent().getParcelableExtra("pytannja");
        startTime=(long)getIntent().getLongExtra("time_start",0);
        textView1.setText(pytannja.getName());
        textView2.setText(pytannja.getDetali());

        timer_text=(TextView)findViewById(R.id.text_timer);
        mMyTimerTask = new MyTimerTask();
        timer.schedule(mMyTimerTask, 0, 1000);


    }




    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            final   int minutes = seconds / 60;
            final int seconds1     = seconds % 60;



            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    timer_text.setText(String.format("%d:%02d", minutes, seconds1));
                }
            });
        }
    }

}
