package com.moco.myapplications.poolthrough;

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

public class RegistrationActivity extends AppCompatActivity {

    private EditText username, email, phone, password;
    private Button register;
    private TextView login;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText) findViewById(R.id.tvusername);
        email = (EditText) findViewById(R.id.tvemail);
        phone = (EditText) findViewById(R.id.tvphone);
        password = (EditText) findViewById(R.id.tvpassword);
        register = (Button)findViewById(R.id.btnregister);
        login = (TextView) findViewById(R.id.tvlogin);
        firebaseAuth = FirebaseAuth.getInstance();
        Log.d("Registration Activity ", "xyx");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //Create Firebase Entry
                    String user_email = email.getText().toString().trim();
                    String user_password = password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this, "Registration Successful!!", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                            }
                            else{
                                Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }

    private  Boolean validate(){
        Boolean result = false;

        if(username.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_LONG).show();
        }
        else {
            result = true;
        }
        return result;
    }
}
