package com.example.panka.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


     EditText emaileidit,passwordedit;
      String email,password;

    public void gotosignup(View view)
    {

        Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
