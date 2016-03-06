package myapp.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CheckBox;

public class callme extends AppCompatActivity {
    private CheckBox checkBox8, checkBox9, checkBox10,checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17;
    String contact[]={"8092623139","9608258644","9504979576","9472643276","7277677609","8809445084","9608958693","9801033867","8298885376","9097691634"};
    boolean con[]=new boolean[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callme);

        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
        checkBox13 = (CheckBox) findViewById(R.id.checkBox13);
        checkBox14 = (CheckBox) findViewById(R.id.checkBox14);
        checkBox15 = (CheckBox) findViewById(R.id.checkBox15);
        checkBox16 = (CheckBox) findViewById(R.id.checkBox16);
        checkBox17 = (CheckBox) findViewById(R.id.checkBox17);

        checkBox8.setOnClickListener(checkboxClickListener);
        checkBox9.setOnClickListener(checkboxClickListener);
        checkBox10.setOnClickListener(checkboxClickListener);
        checkBox11.setOnClickListener(checkboxClickListener);
        checkBox12.setOnClickListener(checkboxClickListener);
        checkBox13.setOnClickListener(checkboxClickListener);
        checkBox14.setOnClickListener(checkboxClickListener);
        checkBox15.setOnClickListener(checkboxClickListener);
        checkBox16.setOnClickListener(checkboxClickListener);
        checkBox17.setOnClickListener(checkboxClickListener);

    }

    View.OnClickListener checkboxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            if (checked) {

                switch (view.getId()){
                    case R.id.checkBox8:
                        con[0]=true;
                        //text = text + "1Y";
                        break;
                    case R.id.checkBox9:
                        con[1]=true;
                        //text = text + "2Y";
                        break;
                    case R.id.checkBox10:
                        con[2]=true;
                        //text=text + "3Y";
                        break;
                    case R.id.checkBox11:
                        con[3]=true;
                        //text = text + "4Y";
                        break;
                    case R.id.checkBox12:
                        con[4]=true;
                        //text = text + "5Y";
                        break;
                    case R.id.checkBox13:
                        con[5]=true;
                        //text= text + "6Y";
                        break;
                    case R.id.checkBox14:
                        con[6]=true;
                        //text= text + "7Y";
                        break;
                    case R.id.checkBox15:
                        con[7]=true;
                        //text= text + "7Y";
                        break;
                    case R.id.checkBox16:
                        con[8]=true;
                        //text= text + "7Y";
                        break;
                    case R.id.checkBox17:
                        con[9]=true;
                        //text= text + "7Y";
                        break;
                }
                // Toast.makeText(classes.this, text, Toast.LENGTH_LONG).show();
            }
            else if (!checked) {

                switch (view.getId()){
                    case R.id.checkBox8:
                        con[0]=false;
                        //text = text + "1Y";
                        break;
                    case R.id.checkBox9:
                        con[1]=false;
                        //text = text + "2Y";
                        break;
                    case R.id.checkBox10:
                        con[2]=false;
                        //text=text + "3Y";
                        break;
                    case R.id.checkBox11:
                        con[3]=false;
                        //text = text + "4Y";
                        break;
                    case R.id.checkBox12:
                        con[4]=false;
                        //text = text + "5Y";
                        break;
                    case R.id.checkBox13:
                        con[5]=false;
                        //text= text + "6Y";
                        break;
                    case R.id.checkBox14:
                        con[6]=false;
                        //text= text + "7Y";
                        break;
                    case R.id.checkBox15:
                        con[7]=false;
                        //text= text + "7Y";
                        break;
                    case R.id.checkBox16:
                        con[8]=false;
                        //text= text + "7Y";
                        break;
                    case R.id.checkBox17:
                        con[9]=false;
                        //text= text + "7Y";
                        break;
                }
                //Toast.makeText(classes.this, text, Toast.LENGTH_LONG).show();
            }
        }
    };

    public void click_call(View view)  {

        for (int i=0; i<10; i++)
        {
            // Thread.sleep(2000);
            if(con[i]==true)
            {
                // Toast.makeText(contact.this,contact[i], Toast.LENGTH_LONG).show();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(contact[i], null, "#", null, null);
                break;
            }

        }

        finish();
    }
}
