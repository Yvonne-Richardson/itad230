package lwtech.itad230.ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String SAVE_EDITTEXT = "lwtech.itad230.twoactivities.SAVE_EDITTEXT";
    public final static String SAVE_TEXTVIEW = "lwtech.itad230.twoactivities.SAVE_TEXTVIEW";
    public final static String SAVE_MESSAGE = "lwtech.itad230.twoactivities.MESSAGE";
    String message;
    TextView textView = null;
    EditText eText1, eText2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


  /**
   * Called when the user clicks the Timer button

   */
  public void btnTimer(View view) {
    Intent intent = new Intent(this, TimeActivity.class);
    startActivityForResult(intent, 1);

  }
  /**
   * Called when the user clicks the Alarm button
   */
  public void btnAlarm(View view) {
    Intent intent = new Intent(this, AlarmActivity.class);
    startActivityForResult(intent, 2);

  }


  /**
   * Called when the user clicks the Pix button
   */
  public void btnPix(View view) {
    Intent intent = new Intent(this, PixActivity.class);

    startActivityForResult(intent, 3);

  }

  // Call Back method  to get the Message from the Timer Activity
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    super.onActivityResult(requestCode, resultCode, data);
    // check if the request code is same as what is passed
    // Initialize members with default values for a new instance
    Intent intent = getIntent();
    switch (requestCode) {
      case 1:
        message = data.getStringExtra(TimeActivity.SAVE_TMESSAGE);    // timer
        break;
      case 2:    message=data.getStringExtra(AlarmActivity.SAVE_AMESSAGE);     // alarm
        break;
      case 3:    message=data.getStringExtra(PixActivity.SAVE_PMESSAGE);     // pix
        break;
      default:
        break;
    }



  }


}
