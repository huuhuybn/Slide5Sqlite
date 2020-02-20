package vn.poly.slide5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MySqliteHelper mySqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySqliteHelper =
                new MySqliteHelper(MainActivity.this);

        List<Student> studentList =
                mySqliteHelper.getAllStudents();

        Toast.makeText(this,"SV : " + studentList.size(),
                Toast.LENGTH_SHORT).show();


    }

    public void insertStudent(View view) {

        int id = new Random().nextInt();
        String name = "Huy Nguyen";
        String number = "0913360468";

        long ketqua = mySqliteHelper.insertStudent(id,name,number);

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
