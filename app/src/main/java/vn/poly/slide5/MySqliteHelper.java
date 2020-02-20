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

    public long insertStudent(int id, String name, String number) {
        // bước 1 :
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // Bước 2 : ghép giá trị truyền vào với tên cột tương ứng
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("number", number);


        //Bước 3 : ghi giá trị vào csdl
        long ketqua = sqLiteDatabase.
                insert("sinhvien", null, contentValues);

        return ketqua;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        // bước 1 :
        SQLiteDatabase sqLiteDatabase =
                this.getWritableDatabase();
        String all = "SELECT * FROM sinhvien";
        Cursor cursor =
                sqLiteDatabase.rawQuery(all, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String number = cursor.getString(2);

                Student student = new Student();
                student.id = id;
                student.name = name;
                student.number = number;

                studentList.add(student);
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return studentList;

    }


}
