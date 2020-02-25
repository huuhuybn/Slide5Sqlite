package vn.poly.slide5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MySqliteHelper mySqliteHelper;
    private ListView listView;
    private StudentAdapter studentAdapter;

    private StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvList);

        mySqliteHelper =
                new MySqliteHelper(MainActivity.this);

        studentDAO = new StudentDAO(mySqliteHelper);

        List<Student> studentList =
                studentDAO.getAllStudents();

        studentAdapter = new StudentAdapter(MainActivity.this,studentList);

        listView.setAdapter(studentAdapter);

    }

    public void insertStudent(View view) {

        int id = new Random().nextInt();
        String name = "Huy Nguyen";
        String number = "0913360468";

        long ketqua = studentDAO.insertStudent(id,name,number);

        if (ketqua>0){
            // theem thanh cong
            Toast.makeText(this,"THANH CONG :"
                            + ketqua,
                    Toast.LENGTH_SHORT).show();
        }else {
            // them ko thanh cong

            Toast.makeText(this,"KHONG THANH CONG"
                            + ketqua,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        Student student
                 = new Student();

        student.id = 1105454778;
        student.name = "QUYNH SSSSS";
        student.number = "0913456789";

        int ketqua = studentDAO.updateStudent(student);
        if (ketqua>0){
            // theem thanh cong
            Toast.makeText(this,"THANH CONG :"
                            + ketqua,
                    Toast.LENGTH_SHORT).show();
        }else {
            // them ko thanh cong

            Toast.makeText(this,"KHONG THANH CONG"
                            + ketqua,
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void refresh(View view) {

        List<Student> studentList =
                studentDAO.getAllStudents();

        studentAdapter = new StudentAdapter(MainActivity.this,studentList);

        listView.setAdapter(studentAdapter);

    }

    public void delete(View view) {
        int id = 1105454778;

        int ketqua = studentDAO.delStudent(id);
        if (ketqua>0){
            // theem thanh cong
            Toast.makeText(this,"THANH CONG :"
                            + ketqua,
                    Toast.LENGTH_SHORT).show();
        }else {
            // them ko thanh cong

            Toast.makeText(this,"KHONG THANH CONG"
                            + ketqua,
                    Toast.LENGTH_SHORT).show();
        }

    }
}
