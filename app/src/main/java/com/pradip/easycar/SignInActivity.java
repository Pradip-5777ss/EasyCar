package com.pradip.easycar;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.inducesmile.taxirental.utils.Helper;
import com.pradip.easycar.models.UserObject;
import com.pradip.easycar.network.GsonRequest;
import com.pradip.easycar.utils.Constants;
import com.pradip.easycar.utils.CustomApplication;
import com.pradip.easycar.utils.Helper;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = SignInActivity.class.getSimpleName();

    private EditText email, password;

    private TextView forgottenPassword, signInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        forgottenPassword = (TextView)findViewById(R.id.forgotten_password);
        signInLink = (TextView)findViewById(R.id.link_to_registration);

        forgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgottenIntent = new Intent(SignInActivity.this, ForgottenActivity.class);
                startActivity(forgottenIntent);
            }
        });

        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(signInIntent);
            }
        });

        Button loginButton = (Button)findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailValidator validator = EmailValidator.getInstance();

                String mEmail = email.getText().toString();
                String mPassword = password.getText().toString();

                /*if(TextUtils.isEmpty(mEmail) || TextUtils.isEmpty(mPassword)){
                    Helper.displayErrorMessage(SignInActivity.this, "Email and password fields must be filled");
                }else if(!validator.isValid(mEmail)){
                        Helper.displayErrorMessage(LoginActivity.this, "You have entered an invalid email");
                }else{
                    if(Helper.isNetworkAvailable(SignInActivity.this)){
                        loginCallToServer(mEmail, mPassword);
                    }else{
                        Helper.displayErrorMessage(SignInActivity.this, "No network available");
                    }
                }*/

                Intent homeIntent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    private void loginCallToServer(String email, String password){
        Map params = getParams(email, password);
        GsonRequest<UserObject> serverRequest = new GsonRequest<UserObject>(
                DownloadManager.Request.Method.POST,
                Constants.PATH_TO_SERVER_LOGIN,
                UserObject.class,
                params,
                createRequestSuccessListener(),
                createRequestErrorListener());

        ((CustomApplication)getApplication()).getNetworkCall().callToRemoteServer(serverRequest);
    }

    private Map getParams(String email, String password){
        Map<String, String> params = new HashMap<String,String>();
        params.put(Constants.EMAIL, email);
        params.put(Constants.PASSWORD, password);
        return params;
    }

    private Response.Listener<UserObject> createRequestSuccessListener() {
        return new Response.Listener<UserObject>() {
            @Override
            public void onResponse(UserObject response) {
                try {
                    if(response != null){
                        //save user login data to a shared preference
                        String userData = ((CustomApplication)getApplication()).getGsonObject().toJson(response);
                        ((CustomApplication)getApplication()).getShared().setUserData(userData);

                        Intent homeIntent = new Intent(SignInActivity.this, HomeActivity.class);
                        startActivity(homeIntent);
                    } else{
                        Helper.displayErrorMessage(SignInActivity.this, "Login failed");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Response.ErrorListener createRequestErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };
    }

}
