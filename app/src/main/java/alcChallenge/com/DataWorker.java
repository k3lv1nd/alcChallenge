package alcChallenge.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataWorker {

    private SQLiteDatabase db;
    private Context context;


    public DataWorker(Context context, SQLiteDatabase db)
    {
        this.db = db;
        this.context = context;
    }

    public void createProfile()
    {
        Bitmap profile_image = BitmapFactory.decodeResource(context.getResources(),R.drawable.me);

        Profile myProfile = new Profile(imageToByte(profile_image),"Android","Kenya", "+254770328938", "Kelvin David", "Kalvind95@gmail.com" );

        insertProfile(myProfile);
    }

    private byte[] imageToByte (Bitmap image)
    {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte imageInByte[] = stream.toByteArray();

        return imageInByte;

    }

    public void insertProfile(Profile profile)
    {

        ContentValues values=new ContentValues();

        values.put(MyDbContract.ProfileEntry.COLUMN_AVATAR, profile.getAvatar());
        values.put(MyDbContract.ProfileEntry.COLUMN_TRACK, profile.getTrack());
        values.put(MyDbContract.ProfileEntry.COLUMN_COUNTRY, profile.getCountry());
        values.put(MyDbContract.ProfileEntry.COLUMN_PHONE, profile.getPhone());
        values.put(MyDbContract.ProfileEntry.COLUMN_USERNAME, profile.getUsername());
        values.put(MyDbContract.ProfileEntry.COLUMN_EMAIL, profile.getEmail());

        db.insert(MyDbContract.ProfileEntry.TABLE_NAME, null, values);
        //db.close();

    }


    public List<Profile> getProfile() {
        List<Profile> profiles = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + MyDbContract.ProfileEntry.TABLE_NAME;

        MyOpenHelper helper = new MyOpenHelper(context);

        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Profile profile  = new Profile(cursor.getBlob(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4), cursor.getString(5),cursor.getString(6));

                profiles .add(profile);
            } while (cursor.moveToNext());
        }

        return profiles;
    }






}
