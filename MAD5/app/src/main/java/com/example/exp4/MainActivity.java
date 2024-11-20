package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText editName, editRollNo, editMarks;
    Button btnAdd, btnUpdate, btnDelete, btnView;
    TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        editName = findViewById(R.id.editTextName);
        editRollNo = findViewById(R.id.editTextRollNo);
        editMarks = findViewById(R.id.editTextMarks);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        btnView = findViewById(R.id.buttonView);
        textViewResults = findViewById(R.id.textViewResults);

        addStudent();
        updateStudent();
        deleteStudent();
        viewAllStudents();
    }

    public void addStudent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertStudent(
                        editName.getText().toString(),
                        Integer.parseInt(editRollNo.getText().toString()),
                        Integer.parseInt(editMarks.getText().toString())
                );
                if (isInserted)
                    Toast.makeText(MainActivity.this, "Student Added", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Error Adding Student", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateStudent() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = db.updateStudent(
                        Integer.parseInt(editRollNo.getText().toString()),
                        editName.getText().toString(),
                        Integer.parseInt(editMarks.getText().toString())
                );
                if (isUpdated)
                    Toast.makeText(MainActivity.this, "Student Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Error Updating Student", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void deleteStudent() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollNo;
                try {
                    rollNo = Integer.parseInt(editRollNo.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid Roll No", Toast.LENGTH_LONG).show();
                    return;
                }
                boolean isDeleted = db.deleteStudent(rollNo);
                if (isDeleted)
                    Toast.makeText(MainActivity.this, "Student Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Error Deleting Student", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAllStudents() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllStudents();
                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("Roll No: ").append(res.getString(0)).append("\n");
                    buffer.append("Name: ").append(res.getString(1)).append("\n");
                    buffer.append("Marks: ").append(res.getString(2)).append("\n\n");
                }

                textViewResults.setText(buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        Toast.makeText(MainActivity.this, title + "\n" + message, Toast.LENGTH_LONG).show();
    }
}
