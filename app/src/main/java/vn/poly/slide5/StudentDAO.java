package vn.poly.slide5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {



    private MySqliteHelper mySqliteHelper;

    public StudentDAO(MySqliteHelper mySqliteHelper) {
        this.mySqliteHelper = mySqliteHelper;
    }

    public long insertStudent(int id, String name, String number) {
        // bước 1 :
        SQLiteDatabase sqLiteDatabase = mySqliteHelper.getWritableDatabase();

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

    public int updateStudent(Student student) {
        // bước 1 :
        SQLiteDatabase sqLiteDatabase = mySqliteHelper.getWritableDatabase();

        // Bước 2 : ghép giá trị truyền vào với tên cột tương ứng
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", student.id);
        contentValues.put("name", student.name);
        contentValues.put("number", student.number);

        int result = sqLiteDatabase.update("sinhvien", contentValues,
                "id=?", new String[]{String.valueOf(student.id)});

        return result;

    }

    public int delStudent(int id){
        // bước 1 :
        SQLiteDatabase sqLiteDatabase = mySqliteHelper.getWritableDatabase();

        int result = sqLiteDatabase.delete("sinhvien","id=?",
                new String[]{String.valueOf(id)});

        return result;

    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        // bước 1 :
        SQLiteDatabase sqLiteDatabase =
                mySqliteHelper.getWritableDatabase();
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
