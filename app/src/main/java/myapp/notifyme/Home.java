package myapp.notifyme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

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

        textAlarmPrompt = (TextView)findViewById(R.id.alarmprompt);
        String certifiedMobile[]=new String[10];
        certifiedMobile[0]="9504979576";
        certifiedMobile[1]="9472643276";
        certifiedMobile[2]="8092623139";
        certifiedMobile[3]="9608258644";
        certifiedMobile[4]="9422579130";
        certifiedMobile[5]="+919504979576";
        certifiedMobile[6]="+919472643276";
        certifiedMobile[7]="+918092623139";
        certifiedMobile[8]="+919608258644";
        certifiedMobile[9]="+919422579130";
        Uri uriSms = Uri.parse("content://sms/inbox");
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
        }

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
}
