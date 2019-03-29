package com.moco.myapplications.poolthrough;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moco.myapplications.poolthrough.Constants.*;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView registration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        registration = (TextView) findViewById(R.id.registration);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);/*
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }*/

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Before Intent ", "xyx");
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
                Log.d("After Intent ", "xyx");
            }
        });
    }

    public void validate(String enteredEmailId, String enteredPassword){
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(enteredEmailId, enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login Success!!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login No Success!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
