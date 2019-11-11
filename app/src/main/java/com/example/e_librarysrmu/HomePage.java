package com.example.e_librarysrmu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private Button adminBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        adminBtn=findViewById(R.id.adminbtn);
        firebaseAuth = FirebaseAuth.getInstance();
        String CurrEmail = firebaseAuth.getCurrentUser().getEmail().toString();
        if(CurrEmail.equals("ankityadav5700@gmail.com"))
        {
            adminBtn.setVisibility(View.VISIBLE);
        }
    }
    public void SignOut(View v)
    {
        firebaseAuth.signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    public void OpenAdminPanel(View v)
    {
        startActivity(new Intent(getApplicationContext(),Admin.class));
    }
}
