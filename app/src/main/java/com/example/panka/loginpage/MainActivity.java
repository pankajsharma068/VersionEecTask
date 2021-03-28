package com.example.panka.loginpage;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.io.BaseEncoding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


     EditText usernameEdit,passwordedit;
      String username,password;
       private FirebaseAuth mAuth;


    public void gotosignup(View view)
    {

        Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);


    }
    public void login(View view) throws Exception
    {
      username=usernameEdit.getText().toString();
        password=passwordedit.getText().toString();


        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("users");
        Query chekuser=ref.orderByChild("username").equalTo(username);
        chekuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               if(dataSnapshot.exists())
               {
                   for (DataSnapshot data : dataSnapshot.getChildren()) {
                       System.out.println(data);
                       String passwordEncoded = data.getValue(UserFirebase.class).getPassword();
                       System.out.println(password);
                       try {
                           String decodedPassword = new String(BaseEncoding.base64().decode(passwordEncoded), "UTF-8");
                           System.out.println(decodedPassword+ password.equals(decodedPassword));
                           if (decodedPassword.equals(password)) {
                               System.out.println("match");
                               Intent intent = new Intent(getApplicationContext(), NextPageActivity.class);
                               startActivity(intent);
                           } else {
                               System.out.println("not match");
                               passwordedit.setError("wrong password");
                               passwordedit.requestFocus();
                           }
                       } catch (Exception e){
                           e.printStackTrace();
                       }
                   }
                 /*  System.out.println(dataSnapshot.getChildren());
                   String passwordDB=dataSnapshot.child("college").child("password").getValue(String.class);
                   System.out.println(passwordDB+" "+password);*/

                  /* if(passwordDB.equals(password))
                   {



                   }
                   else
                   {
                       passwordedit.setError("wrong password");
                        passwordedit.requestFocus();
                   }*/
               }
               else
               {
                   usernameEdit.setError("No such user Exits");
                   usernameEdit.requestFocus();
               }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




      /*  mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            System.out.println("signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent=new Intent(getApplicationContext(),NextPageActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            System.out.println("signInWithEmail:failure" + task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });*/


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEdit=(EditText)findViewById(R.id.email);
        passwordedit=(EditText)findViewById(R.id.password);

        mAuth=FirebaseAuth.getInstance();
    }

}
