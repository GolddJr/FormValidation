package com.sarno.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {


    EditText  etUsername, etPassword, etConfirmPassword, etEnterFullname;
    String username, password, confirmpassword, enterfullname;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etEnterFullname = findViewById(R.id.etEnteFullname);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnSave:

                formsuccess = 5;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmpassword = etConfirmPassword.getText().toString();
                enterfullname = etEnterFullname.getText().toString();

                if(username.equals("")){
                    etUsername.setError("This field is required");
                    formsuccess--;
                }
                if(password.equals("")){
                    etPassword.setError("This field is required");
                    formsuccess--;
                }
                if(confirmpassword.equals("")) {
                    etConfirmPassword.setError("This field is required");
                    formsuccess--;
                }
                if (!confirmpassword.equals(password)){
                    etConfirmPassword.setError("Password Mismatch");
                    formsuccess--;
                }
                // check if the Fullname is null
                if(enterfullname.equals(password)) {
                    etEnterFullname.setError("This field is required");
                    formsuccess--;
                }
                if (formsuccess == 5) {
                    Toast.makeText(this,"Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
