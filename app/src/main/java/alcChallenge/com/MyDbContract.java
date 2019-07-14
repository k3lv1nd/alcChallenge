package alcChallenge.com;

import android.provider.BaseColumns;

public class MyDbContract {

    private MyDbContract (){ }

    public static final class ProfileEntry implements BaseColumns {

        public static final String TABLE_NAME = "profile";
        public static final String COLUMN_AVATAR = "avatar";
        public static final String COLUMN_TRACK = "track";
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";


        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("+
                        _ID + " INTEGER PRIMARY KEY,"+
                        COLUMN_AVATAR +" BLOB, "+
                        COLUMN_TRACK+" TEXT, "+
                        COLUMN_COUNTRY+" TEXT, "+
                        COLUMN_PHONE+" TEXT,"+
                        COLUMN_USERNAME+" TEXT,"+
                        COLUMN_EMAIL+" TEXT )";

    }

}
