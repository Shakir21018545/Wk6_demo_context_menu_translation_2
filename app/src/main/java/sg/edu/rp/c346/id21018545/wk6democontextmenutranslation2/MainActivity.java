package sg.edu.rp.c346.id21018545.wk6democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText1;
    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTranslatedText1 = findViewById(R.id.textViewTranslatedText1);
        registerForContextMenu(tvTranslatedText1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == tvTranslatedText1){
            wordClicked = "hello";
        }

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // …
        if(wordClicked.equalsIgnoreCase("hello")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslatedText1.setText("Hello");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslatedText1.setText("Cioa");
                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText1.setText("Hello ");
            return true;
        } else if (id == R.id.italianSelection) {
            tvTranslatedText1.setText("Ciao");
            return true;
        } else {
            tvTranslatedText1.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


}