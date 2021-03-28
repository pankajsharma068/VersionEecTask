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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

  private  EditText signname,signusername,signphone,signemail,signpassword;
  private String email,password ,name,username,mobile;

    private FirebaseAuth mAuth1;
    FirebaseDatabase database;
    DatabaseReference mref;


    public void register(View view)
    {
        email=signemail.getText().toString();
        password=signpassword.getText().toString();
        mobile=signphone.getText().toString();
        name=signname.getText().toString();
        username=signusername.getText().toString();
       if(email.isEmpty())
         {
             signemail.setError("Feild cannot be empty");
             signemail.requestFocus();
             return;


         }
        if(name.isEmpty())
        {
            signname.setError("Name cannot be empty");
            signname.requestFocus();
            return;
        }
        if(username.isEmpty())
        {
            signusername.setError("college name cannot be empty");
            signusername.requestFocus();
            return;


        }
        if(password.isEmpty())
        {
            signpassword.setError("password cannot be empty");
            signpassword.requestFocus();
            return;

        }
        else if (password.length()<6)
        {
            signpassword.setError("min length of password should be 6");
            signpassword.requestFocus();
            return;
        }
                database=FirebaseDatabase.getInstance();
                  mref=database.getReference("users");
        user  users=new user(name,username,mobile,email,password);
        mref.child(mobile).setValue(users);
     /*   mAuth1.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            user  users=new user(name,college,mobile,email,password);
                            FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                          mref.child(mobile).setValue(users);
                                        System.out.println("signInWithEmail:success");


                                        //Toast.makeText(Register)
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        System.out.println("signInWithEmail:failure" + task.getException());
                                        Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            }
                           // FirebaseUser user = mAuth1.getCurrentUser();
                        }
                }); */

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
        signname=(EditText)findViewById(R.id.name);
        signphone=(EditText)findViewById(R.id.mobilenumber);
        signusername=(EditText)findViewById(R.id.collegename);
        signemail=(EditText)findViewById(R.id.emailsign);
        signpassword=(EditText)findViewById(R.id.passwordsign);



    }

}
