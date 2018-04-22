package bday.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import anusha.girl.bday.anusha.R;


public class BirthdayActivity extends AppCompatActivity {
    RelativeLayout mainLayout;
    public static int imageNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(BirthdayActivity.this, PlayAudioInBackground.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        selectInitialPicture();
        changePictureOnTap();
    }
    private void changePictureOnTap() {
        selectInitialPicture();
        setImageRotator();
    }
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(BirthdayActivity.this, PlayAudioInBackground.class));
        super.onDestroy();
    }

    private void setImageRotator() {
        mainLayout = (RelativeLayout) findViewById(R.id.mainlayout);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageNumber++;
                if(imageNumber > 81 ){
                    imageNumber=0;
                }
                setImage();
            }
        });
    }
    private void selectInitialPicture() {
        setImage();
    }
    private void setImage() {
        final ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        String imageName = "image"+String.valueOf(imageNumber);
        int res = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(res);
    }

}
