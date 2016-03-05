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
        cnt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(groups.this, classes.class));
            }
        });
    }
}
