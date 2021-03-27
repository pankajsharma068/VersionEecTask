package com.example.panka.loginpage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

  private  EditText signname,signcollege,signphone,signemail,signpassword;
  private String email,password;
    private FirebaseAuth mAuth1;

    public void register(View view)
    {
        email=signemail.getText().toString();
        password=signpassword.getText().toString();
       if(email.isEmpty())
         {
             signname.setError("Feild cannot be empty");
             signname.requestFocus();
             return;


         }
        if(password.isEmpty())
        {
            signpassword.setError("Field cannot be empty");
            signpassword.requestFocus();
            return;

        }

        mAuth1.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            System.out.println("signInWithEmail:success");
                            FirebaseUser user = mAuth1.getCurrentUser();


                        } else {
                            // If sign in fails, display a message to the user.
                            System.out.println("signInWithEmail:failure" + task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

       // Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(intent);


    }


    public void gotologin(View view)
    {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth1=FirebaseAuth.getInstance();
        signemail=(EditText)findViewById(R.id.emailsign);
        signpassword=(EditText)findViewById(R.id.passwordsign);



    }

}
