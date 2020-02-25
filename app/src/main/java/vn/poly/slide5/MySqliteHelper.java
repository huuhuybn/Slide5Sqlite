package vn.poly.slide5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MySqliteHelper extends SQLiteOpenHelper {

    // bang sinh vien voi 3 thong tin la id, name, number
    // id la khoa chinh

    // viết câu lệnh tạo bảng
    String create_table =
            "Create table sinhvien " +
                    "(id integer primary key,name text,number text)";

    public MySqliteHelper(Context context) {
        // tên file database
        // phiên bản của database
        // null
        super(context, "sv.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
