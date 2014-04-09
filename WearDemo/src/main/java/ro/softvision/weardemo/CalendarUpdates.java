package ro.softvision.weardemo;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by Georgel Aron on 4/9/14.
 *
 * Class used for reading google calendar
 */
public class CalendarUpdates {
    private static final String[] COLUMNS = new String[]{CalendarContract.Instances.EVENT_ID,
            CalendarContract.Instances.BEGIN, CalendarContract.Instances.TITLE};

    private Cursor mCursor;
    private Context mContext;

    public CalendarUpdates(Context context) {
        mContext = context;

        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2014, 4, 9, 8, 0);
        long beginMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(2014, 4, 10, 8, 0);
        long endMillis = endTime.getTimeInMillis();

        Uri.Builder builder = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(builder, beginMillis);
        ContentUris.appendId(builder, endMillis);

        mCursor = mContext.getContentResolver().query(builder.build(), COLUMNS, null, null, null);

    }

    public void getFirstEvent() {
        mCursor.moveToFirst();

        String title = mCursor.getString(2);
        long startDate = mCursor.getLong(1);

        Log.wtf("TAG", title + "/" + startDate);
    }
}
