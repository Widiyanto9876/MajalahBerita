package com.widiyanto.user.majalahberita;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.widiyanto.user.majalahberita.Helper.DBHelper;

public class Login extends AppCompatActivity {

    DBHelper dbHelper;
    private EditText user;
    private EditText password;
    private Button masukpakeko;
    private TextView masuklagi;


    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.ed_user);
        password = (EditText) findViewById(R.id.ed_paswd);
        masukpakeko = (Button) findViewById(R.id.btn_masuk);
        masuklagi = (TextView) findViewById(R.id.daftar);

        dbHelper = new DBHelper(this);

        masuklagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, register.class);
                startActivity(intent);
            }
        });


        masukpakeko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

    }

    private void checkLogin() {
        id = dbHelper.checkLogin(user.getText().toString(),password.getText().toString());

        if(id != -1){
            Intent intent = new Intent(Login.this, MainActivity.class );
            startActivity(intent);
        }
        else {
            Toast.makeText(Login.this,"User Atau Password Anda Salah",Toast.LENGTH_LONG).show();
        }
    }
}
