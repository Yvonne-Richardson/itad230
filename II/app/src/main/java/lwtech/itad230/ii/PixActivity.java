package lwtech.itad230.ii;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PixActivity extends AppCompatActivity {
  public final static String SAVE_PEDITTEXT = "lwtech.itad230.twoactivities.SAVE_PEDITTEXT";
  public final static String SAVE_PTEXTVIEW = "lwtech.itad230.twoactivities.SAVE_PTEXTVIEW";
  public final static String SAVE_PMESSAGE = "lwtech.itad230.twoactivities.PMESSAGE";
  public final static  int REQUEST_IMAGE_CAPTURE = 1;
  public final static  int REQUEST_TAKE_PHOTO = 1;

  EditText eText1, eText2 = null;
  String message;

  String mCurrentPhotoPath;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pix);
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
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }


  /**
   * Called when the user clicks the Start Camera button
   */
  public void btnCamera(View v)  {
    /* Send an implicit intent to the Android device app that can handle
    the ACTION_SET_ALARM action. Include extras on the intent that specify:
        the hour and minutes of the alarm, and the message
    */

    // Create the text message with a string

    eText1 = (EditText) findViewById(R.id.edtPicName);
    String targetFilename = eText1.getText().toString();

    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    // Ensure that there's a camera activity to handle the intent
    if (intent.resolveActivity(getPackageManager()) != null) {
      // Create the File where the photo should go
      File photoFile = null;
      try {
        photoFile = createImageFile(targetFilename);
      } catch (IOException ex) {
        // Error occurred while creating the File
        String errorHappened = "yes";
      }
      // Continue only if the File was successfully created
      if (photoFile != null) {
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
          Uri.fromFile(photoFile));
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
      }
    }



  }
  @Override
  // http://developer.android.com/training/camera/photobasics.html#TaskCaptureIntent
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
             /*
       When handling this intent, your activity should check for the EXTRA_OUTPUT extra in the incoming Intent, then save the captured image or video at the location specified by that extra and call setResult() with an Intent that includes a compressed thumbnail in an extra named "data".
       This implies that the app is not being tested with an emulator, which only returns null in the data intent.
           */
     if (resultCode == RESULT_OK) {

       Intent intent = new Intent(MediaStore.EXTRA_OUTPUT);
       Bundle extras = intent.getExtras();
       Bitmap imageBitmap = (Bitmap) extras.get("data");

      ImageView iv = (ImageView) findViewById(R.id.imageDisplay);
      iv.setImageBitmap(imageBitmap);


    }
  } //   onactivityResult

  private File createImageFile( String targetFilename) throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = targetFilename + "_" +  timeStamp ;
    File storageDir = Environment.getExternalStoragePublicDirectory(
      Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
      imageFileName,  /* prefix */
      ".jpg",         /* suffix */
      storageDir      /* directory */
    );

    // Save a file: path for use with ACTION_VIEW intents
    mCurrentPhotoPath = "file:" + image.getAbsolutePath();
    return image;
  }


}
