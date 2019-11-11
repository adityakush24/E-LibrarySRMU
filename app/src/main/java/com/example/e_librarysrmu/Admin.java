package com.example.e_librarysrmu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Admin extends AppCompatActivity {
    private EditText bookId,bookName,noOfCopies,bookId1;
    DatabaseReference databaseBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
         bookId=findViewById(R.id.bookId);
        bookName=findViewById(R.id.bookName);
        bookId1=findViewById(R.id.bookId1);
        noOfCopies=findViewById(R.id.noOfCopies);
        databaseBooks=FirebaseDatabase.getInstance().getReference("Books");
    }
    private void addBook()
    {
        String BookId=bookId.getText().toString();
        String BookName=bookName.getText().toString();
        String NoOfCopies=noOfCopies.getText().toString();
        if (TextUtils.isEmpty(BookId)){
            Toast.makeText(this, "Please Enter Book Id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(BookName)){
            Toast.makeText(this, "Please Enter Book Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(NoOfCopies)){
            Toast.makeText(this, "Please Enter No of Copies", Toast.LENGTH_SHORT).show();
            return;
        }
        String id = databaseBooks.push().getKey();
        BookInformation book = new BookInformation(id, BookId, BookName,NoOfCopies);
        databaseBooks.child(id).setValue(book);
        bookId.setText("");
        bookId1.setText("");
        noOfCopies.setText("");
        bookName.setText("");
        Toast.makeText(this, "Book added", Toast.LENGTH_LONG).show();

    }
    private void removeBook() {
        String bookId=bookId1.getText().toString();
        if (TextUtils.isEmpty(bookId)){
            Toast.makeText(this, "Please Enter Book Name", Toast.LENGTH_SHORT).show();

        }
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference();
        Query query = dR.child("Books").orderByChild("bookId").equalTo("bookId");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void addBookCall(View v)
    {
        addBook();
    }
    public void removeBookCall(View v)
    {
        removeBook();
    }
}
