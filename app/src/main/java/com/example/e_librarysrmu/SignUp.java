package com.example.e_librarysrmu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private EditText email,pass,confirmPass;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progressDialog=new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        pass=findViewById(R.id.Pass);
        confirmPass=findViewById(R.id.ConfirmPass);
    }
    public void registerUser(){

        //getting email and password from edit texts
        String Email = email.getText().toString().trim();
        String Password  = pass.getText().toString().trim();
        String ConfirmPass = confirmPass.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_LONG).show();
            return;
        }

        if(!(Password.equals(ConfirmPass))){
            Toast.makeText(this,"Confirm Password didn't match",Toast.LENGTH_LONG).show();
            return;
        }


        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering, Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(SignUp.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            FirebaseAuthException e = (FirebaseAuthException)task.getException();
                            Toast.makeText(SignUp.this,"Registration Error"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                    }
                });

    }
    public void SignIn(View v)
    {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    public void SignUp(View v)
    {
        registerUser();
    }

}
