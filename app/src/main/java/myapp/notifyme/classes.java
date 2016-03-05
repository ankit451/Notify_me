package myapp.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class classes extends AppCompatActivity {
    private CheckBox checkBox, checkBox2, checkBox3,checkBox4, checkBox5, checkBox6, checkBox7;
    String text = "";
    boolean arr[]=new boolean[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);

        checkBox.setOnClickListener(checkboxClickListener);
        checkBox2.setOnClickListener(checkboxClickListener);
        checkBox3.setOnClickListener(checkboxClickListener);
        checkBox4.setOnClickListener(checkboxClickListener);
        checkBox5.setOnClickListener(checkboxClickListener);
        checkBox6.setOnClickListener(checkboxClickListener);
        checkBox7.setOnClickListener(checkboxClickListener);

    }

    View.OnClickListener checkboxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            if (checked) {

                switch (view.getId()){
                    case R.id.checkBox:
                        arr[0]=true;
                        //text = text + "1Y";
                        break;
                    case R.id.checkBox2:
                        arr[1]=true;
                        //text = text + "2Y";
                        break;
                    case R.id.checkBox3:
                        arr[2]=true;
                        //text=text + "3Y";
                        break;
                    case R.id.checkBox4:
                        arr[3]=true;
                        //text = text + "4Y";
                        break;
                    case R.id.checkBox5:
                        arr[4]=true;
                        //text = text + "5Y";
                        break;
                    case R.id.checkBox6:
                        arr[5]=true;
                        //text= text + "6Y";
                        break;
                    case R.id.checkBox7:
                        arr[6]=true;
                        //text= text + "7Y";
                        break;
                }
                // Toast.makeText(classes.this, text, Toast.LENGTH_LONG).show();
            }
            else if (!checked) {

                switch (view.getId()){
                    case R.id.checkBox:
                        arr[0]=false;
                        //text = text + "1N";
                        break;
                    case R.id.checkBox2:
                        arr[1]=false;
                        //text = text + "2N";
                        break;
                    case R.id.checkBox3:
                        arr[2]=false;
                        //text=text + "3N";
                        break;
                    case R.id.checkBox4:
                        arr[3]=false;
                        //text = text + "4N";
                        break;
                    case R.id.checkBox5:
                        arr[4]=false;
                        //text = text + "5N";
                        break;
                    case R.id.checkBox6:
                        arr[5]=false;
                        //text= text + "6N";
                        break;
                    case R.id.checkBox7:
                        arr[6]=false;
                        //text= text + "7N";
                        break;
                }
                //Toast.makeText(classes.this, text, Toast.LENGTH_LONG).show();
            }
        }
    };
    public void onClick(View view)
    {
        for (int i=0; i<7; i++)
        {
            if(arr[i]==true)
                text=text + (i+1) + "y";
        }

        //Toast.makeText(classes.this, "Success", Toast.LENGTH_LONG).show();
        Intent nex = new Intent(classes.this, contact.class).putExtra("extra",text);
        startActivity(nex);
    }
    public void cancel_class(View view)
    {
        finish();
    }
}
