package myapp.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
}
