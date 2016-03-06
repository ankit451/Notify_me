package myapp.notifyme;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {
    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    TextView textAlarmPrompt;

    TimePickerDialog timePickerDialog;
    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        back();
        textAlarmPrompt = (TextView)findViewById(R.id.alarmprompt);

       /* Uri uriSms = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uriSms, new String[]{"_id", "address", "date", "body"}, null, null, null);
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String mobileRecieved = cursor.getString(1);
        String date = cursor.getString(2);
        String body = cursor.getString(3);
        //  Toast.makeText(MainActivity.this,id+"\n"+mobileRecieved+"\n"+date+"\n"+body,Toast.LENGTH_LONG).show();
        // Toast.makeText(MainActivity.this,mobileRecieved,Toast.LENGTH_LONG).show();
        //   String   str = address + ":" + body;
        boolean flag = false;
        for(int i=0;i<10;i++)
        {
            if(certifiedMobile[i].equalsIgnoreCase(mobileRecieved))
            {
                flag=true;
                break;
            }
        }
        if(flag)
        {

            Toast.makeText(Home.this, body, Toast.LENGTH_LONG).show();
            srun(body);
        }*/

        Button call = (Button) findViewById(R.id.call_me);

        call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home.this, callme.class));
            }
        });

        Button online = (Button) findViewById(R.id.whose);

        online.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home.this, online.class));
            }
        });


        Button openclasses = (Button) findViewById(R.id.open_classes);

        openclasses.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home.this, classes.class));
            }
        });

        Button opengroups = (Button) findViewById(R.id.open_groups);

        opengroups.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home.this, groups.class));
            }
        });

        TextView feed = (TextView)findViewById(R.id.feedbacak);
        feed.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(Home.this, feedback.class));
            }
        });

        TextView faq = (TextView)findViewById(R.id.faq);
        faq.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(Home.this, faq.class));
            }
        });

        TextView abt = (TextView)findViewById(R.id.about);
        abt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(Home.this, aboutus.class));
            }
        });

        TextView cnt = (TextView)findViewById(R.id.contribute);
        cnt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(Home.this, contribute.class));
            }
        });
    }

    void srun(String alarmtext){
//       Toast.makeText(MainActivity.this,alarmtext+" jii",Toast.LENGTH_LONG).show();
        char ch =alarmtext.charAt(0);

        int hourOfDay=(int)ch-(int)'0'+6;//By Default time is so set that alarm cant ring as this time is wrog
        int minute=30;

        Calendar calNow = Calendar.getInstance();
        Calendar calSet = (Calendar) calNow.clone();

        calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calSet.set(Calendar.MINUTE, minute);
        calSet.set(Calendar.SECOND, 0);
        calSet.set(Calendar.MILLISECOND, 0);

        if(calSet.compareTo(calNow) <= 0){
            //Today Set time passed, count to tomorrow
            calSet.add(Calendar.DATE, 1);
        }

        setAlarm(calSet);
    };

    private void setAlarm(Calendar targetCal){

        textAlarmPrompt.setText(
                "\n\n***\n"
                        + "Alarm is set@ " + targetCal.getTime() + "\n"
                        + "***\n");

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }














        int Prestate=0;
        int curstate=-1;

        Timer timer;
        MyTimerTask myTimerTask;

            void back(){

                    timer = new Timer();
                    myTimerTask = new MyTimerTask();
                        timer.schedule(myTimerTask, 1000, 10000);

        }

        class MyTimerTask extends TimerTask {

            private boolean netCheckin() {
                try {
                    ConnectivityManager nInfo = (ConnectivityManager) getSystemService(
                            Context.CONNECTIVITY_SERVICE);
                    nInfo.getActiveNetworkInfo().isConnectedOrConnecting();
         /*   Toast.makeText(MainActivity.this,"Net avail:"
                    + nInfo.getActiveNetworkInfo().isConnectedOrConnecting(),Toast.LENGTH_LONG).show();*/
                    ConnectivityManager cm = (ConnectivityManager) getSystemService(
                            Context.CONNECTIVITY_SERVICE);
                    NetworkInfo netInfo = cm.getActiveNetworkInfo();
                    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                        Toast.makeText(Home.this,"Network available:true",Toast.LENGTH_LONG).show();
                        return true;
                    } else {
                        Toast.makeText(Home.this,"Network available:False",Toast.LENGTH_LONG).show();
                        return false;
                    }
                } catch (Exception e) {
                        Toast.makeText(Home.this,"Network available:False",Toast.LENGTH_LONG).show();
                    return false;
                }
            }





            @Override
            public void run() {

                final String certifiedMobile[]=new String[10];
                certifiedMobile[0]="9504979576";
                certifiedMobile[1]="9472643276";
                certifiedMobile[2]="8092623139";
                certifiedMobile[3]="9608258644";
                certifiedMobile[4]="9608258644";
                certifiedMobile[5]="+919504979576";
                certifiedMobile[6]="+919472643276";
                certifiedMobile[7]="+918092623139";
                certifiedMobile[8]="+919608258644";
                certifiedMobile[9]="+919608258644";

                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {

                        Uri uriSms = Uri.parse("content://sms/inbox");
                        Cursor cursor = getContentResolver().query(uriSms, new String[]{"_id", "address", "date", "body"}, null, null, null);
                        cursor.moveToFirst();
                        String id = cursor.getString(0);
                        String mobileRecieved = cursor.getString(1);
                        String date = cursor.getString(2);
                        String body = cursor.getString(3);
                        char ch = body.charAt(0);
                        if(ch>='1'&&ch<='9')
                        {
                            curstate=1;
                        }
                        else if (ch=='#')
                        {
                            curstate=2;
                        }
                        else if (ch=='$') {
                            curstate = 3;
                        }
                            else
                            {
                                curstate = -1;
                            }

                      //  Toast.makeText(Home.this,body,Toast.LENGTH_LONG).show();
                        if(curstate!=Prestate)
                        {
                            Prestate=curstate;
                            boolean flag = false;
                            for(int i=0;i<10;i++)
                            {
                                if(certifiedMobile[i].equalsIgnoreCase(mobileRecieved))
                                {
                                    flag=true;
                                    break;
                                }
                            }
                            if(flag) {
                                if (curstate == 1) {
                                    //alarm
                                    // Toast.makeText(Home.this,"state 1",Toast.LENGTH_LONG).show();
                                   // Toast.makeText(Home.this, body, Toast.LENGTH_LONG).show();
                                    srun(body);
                                } else {
                                    if (curstate == 2) {
                                        String number = "tel:"+mobileRecieved;
                                        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
                                        startActivity(callIntent);
                                        //call
                                        // Toast.makeText(Home.this,"state 2",Toast.LENGTH_LONG).show();
                                    } else {
                                        if (curstate == 3) {
                                            //internet
                                            //Toast.makeText(Home.this,"state 3",Toast.LENGTH_LONG).show();

                                            boolean netCheck = netCheckin();
                                            SmsManager smsManager = SmsManager.getDefault();
                                            if(netCheck)
                                            smsManager.sendTextMessage(mobileRecieved, null, "T", null, null);
                                            else
                                                smsManager.sendTextMessage(mobileRecieved, null, "F", null, null);

                                        }
                                    }
                                }
                            }
                        }

                    }});
            }

        }

    public void call_click(View view)
    {
        Intent call = new Intent(Home.this, callme.class);
        startActivity(call);
    }

    public void online_open(View view)
    {
        Intent online = new Intent(Home.this, online.class);
        startActivity(online);
    }

}



















