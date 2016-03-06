package myapp.notifyme;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class online_check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_check);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Uri uriSms = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uriSms, new String[]{"_id", "address", "date", "body"}, null, null, null);
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String mobileRecieved = cursor.getString(1);
        String date = cursor.getString(2);
        String body = cursor.getString(3);
        char ch = body.charAt(0);
        String str = "Your Friend with Mobile Number : " + mobileRecieved +" is ";
        if(ch=='T'||ch=='t')
            str = str+" Online ";
        else
            str = str + " Offline";
        TextView textView = (TextView)findViewById(R.id.textView15);
        textView.setText(str);
    }
}
