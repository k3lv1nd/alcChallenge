package alcChallenge.com;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "challenge_db";

    public static final int DATABASE_VERSION = 1;

    private Context context;

    public MyOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyDbContract.ProfileEntry.SQL_CREATE_TABLE);

        DataWorker helper = new DataWorker(context,db);

        helper.createProfile();



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
