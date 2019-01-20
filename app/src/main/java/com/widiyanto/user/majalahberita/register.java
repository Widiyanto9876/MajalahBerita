package com.widiyanto.user.majalahberita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.widiyanto.user.majalahberita.Entity.EntityRegister;
import com.widiyanto.user.majalahberita.Helper.DBHelper;

public class register extends AppCompatActivity {


    private EditText Nama_Lengkap;
    private EditText Email;
    private EditText User_Name;
    private EditText Alamat;
    private EditText Nomer_Hp;
    private EditText Password;
    private Button ButtonRegister;


    SharedPref sharedPref;
    DBHelper dbHelper;

    EntityRegister register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPref = new SharedPref(this);
        dbHelper = new DBHelper(this);

        Nama_Lengkap = (EditText) findViewById(R.id.ed_nama);
        Email = (EditText ) findViewById(R.id.ed_email);
        User_Name = (EditText) findViewById(R.id.ed_rg_user);
        Alamat = (EditText) findViewById(R.id.ed_alamat);
        Nomer_Hp = (EditText) findViewById(R.id.ed_hp);
        Password = (EditText) findViewById(R.id.ed_rg_psswd);
        ButtonRegister = (Button) findViewById(R.id.btn_register);


        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = new EntityRegister(User_Name.getText().toString(), Password.getText().toString(), Email.getText().toString(),
                        Nama_Lengkap.getText().toString(), Nomer_Hp.getText().toString(), Alamat.getText().toString());
                dbHelper.sendRegister(register);
                Intent intent = new Intent(register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
