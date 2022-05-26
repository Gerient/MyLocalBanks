package sg.edu.rp.c346.id20014027.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    String bankClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonBank1);
        btnOCBC = findViewById(R.id.buttonBank2);
        btnUOB = findViewById(R.id.buttonBank3);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v == btnDBS){
            bankClicked = "DBS";
        }
        else if(v == btnOCBC){
            bankClicked = "OCBC";
        }
        else if(v == btnUOB){
            bankClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bankClicked.equalsIgnoreCase("dbs")) {
            if(item.getItemId()==0){
                Intent intentBank = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentBank);
                return true;
            }
            else if(item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111L));
                startActivity(intentCall);
                return true;
            }
        }
        else if(bankClicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0){
                Intent intentBank = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentBank);
                return true;
            }
            else if(item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333L));
                startActivity(intentCall);
                return true;
            }
        }
        else if(bankClicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0){
                Intent intentBank = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intentBank);
                return true;
            }
            else if(item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121L));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        } else {
            btnUOB.setText("Error translation");
            btnUOB.setText("Error translation");
            btnUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


}