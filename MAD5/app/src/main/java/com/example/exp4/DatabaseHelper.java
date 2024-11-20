package com.example.exp4;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB";
    private static final String TABLE_NAME = "Student";
    private static final String COL_NAME = "Name";
    private static final String COL_ROLLNO = "RollNo";
    private static final String COL_MARKS = "Marks";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ROLLNO + " INTEGER PRIMARY KEY, " +
                COL_NAME + " TEXT, " +
                COL_MARKS + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert a new student record
    public boolean insertStudent(String name, int rollNo, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_ROLLNO, rollNo);
        contentValues.put(COL_MARKS, marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Update a student record
    public boolean updateStudent(int rollNo, String name, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_MARKS, marks);
        int result = db.update(TABLE_NAME, contentValues, COL_ROLLNO + " = ?", new String[]{String.valueOf(rollNo)});
        return result > 0;
    }

    // Delete a student record
    public boolean deleteStudent(int rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, COL_ROLLNO + " = ?", new String[]{String.valueOf(rollNo)});
        return result > 0;
    }

    // View all student records
    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }
}
