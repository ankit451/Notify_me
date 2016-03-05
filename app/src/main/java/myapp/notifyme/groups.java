package myapp.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        TextView cnt = (TextView)findViewById(R.id.textView2);
        cnt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, classes.class));
            }
        });

        TextView cnt1 = (TextView)findViewById(R.id.textView3);
        cnt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, classes.class));
            }
        });

        TextView cnt2 = (TextView)findViewById(R.id.textView4);
        cnt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt3 = (TextView)findViewById(R.id.textView5);
        cnt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt4 = (TextView)findViewById(R.id.textView6);
        cnt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt5 = (TextView)findViewById(R.id.textView7);
        cnt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt6 = (TextView)findViewById(R.id.textView8);
        cnt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt7 = (TextView)findViewById(R.id.textView9);
        cnt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt8 = (TextView)findViewById(R.id.textView10);
        cnt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });

        TextView cnt9 = (TextView)findViewById(R.id.textView11);
        cnt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, nostudent.class));
            }
        });
    }
}
