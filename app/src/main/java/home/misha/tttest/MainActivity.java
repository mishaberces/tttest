package home.misha.testy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private MyTimerTask mMyTimerTask;


    Timer timer = new Timer();
    public TextView timer_text;
    long startTime=System.currentTimeMillis();
    Pytannja pytannja;
    MyAdapter myAdapter1, myAdapter2, myAdapter3, myAdapter4;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer_text=(TextView)findViewById(R.id.text_timer);
        mMyTimerTask = new MyTimerTask();
        timer.schedule(mMyTimerTask, 0, 1000);

// заповнюємо питання із ресурсного файлу
        initializise();

        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(myAdapter1);

    }

   private void initializise(){

       myAdapter1=newAdapter(R.array.p1, R.array.p1_d, R.array.p1_dodatok,1);
       myAdapter2=newAdapter(R.array.p2, R.array.p2_d, R.array.p2_dodatok,2);
       myAdapter3=newAdapter(R.array.p3, R.array.p3_d, R.array.p3_dodatok,3);
       myAdapter4=newAdapter(R.array.p4, R.array.p4_d, R.array.p4_dodatok,4);

   }


    MyAdapter newAdapter(int res1, int res2, int res3, int id){
        ArrayList<Pytannja> ar=new ArrayList<Pytannja>();
        int i=0;
        String[] name_pyt=getResources().getStringArray(res1);
        String[] name_pyt_d=getResources().getStringArray(res2);
        String[] dodatok=getResources().getStringArray(res3);
        for (String s : name_pyt) {
            pytannja=new Pytannja(s, name_pyt_d[i], dodatok[i], id);
            ar.add(pytannja);
            i++;
        }
       return new MyAdapter(this, ar);

    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.imageView1 : {

                listView.setAdapter(myAdapter1);

                break;
            }
            case R.id.imageView2 : {
                listView.setAdapter(myAdapter2);
                break;
            }

            case R.id.imageView3 : {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("pytannja",pytannja);
                intent.putExtra("time_start", startTime);
                startActivity(intent);
               // listView.setAdapter(myAdapter3);
                break;
            }

            case R.id.imageView4 : {
                listView.setAdapter(myAdapter4);
                break;
            }



        }


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




