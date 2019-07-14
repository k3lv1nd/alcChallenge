package alcChallenge.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    private ImageView avatar;
    private TextView username;
    private TextView track;
    private TextView country;
    private TextView email;
    private TextView phone;
    private TextView slack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("My Profile");

        displayProfile();
    }

    private void displayProfile() {

        MyOpenHelper helper = new MyOpenHelper(this);

        DataWorker worker = new DataWorker(this, helper.getReadableDatabase());

        List<Profile> profile = worker.getProfile();

        avatar = (ImageView) findViewById(R.id.imageView_avatar);
        username = (TextView) findViewById(R.id.textView_username);
        track = (TextView) findViewById(R.id.textView_track);
        country = (TextView) findViewById(R.id.textView_country);
        email = (TextView) findViewById(R.id.textView_email);
        phone = (TextView) findViewById(R.id.textView_phone);
        slack = (TextView) findViewById(R.id.textView_slack);
        int position = 0;

        Profile myProfile = profile.get(position);

        //bytes back to image

        byte[] outImage = myProfile.getAvatar();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);

        Glide.with(this).load(bitmapToByte(theImage)).override(300, 300).fitCenter().into(avatar);

        username.setText(myProfile.getUsername().toString());
        track.setText(myProfile.getTrack().toString());
        country.setText(myProfile.getCountry().toString());
        email.setText(myProfile.getEmail().toString());
        phone.setText(myProfile.getPhone().toString());
        slack.setText(myProfile.getUsername().toString());


    }

    private byte[] bitmapToByte(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
