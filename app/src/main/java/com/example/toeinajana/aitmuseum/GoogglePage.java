package com.example.toeinajana.aitmuseum;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.SignIn;

public class GoogglePage extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {


    private LinearLayout Prof_Section;
    private Button Signout;
    private SignInButton SignIn;
    private TextView Name, Email;
    //private ImageView Prof_Pic;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googgle_page);
        Prof_Section = (LinearLayout) findViewById(R.id.prof_section);
        Signout = (Button) findViewById(R.id.logoutbtn);
        SignIn = (SignInButton) findViewById(R.id.login_btn);
        Name = (TextView) findViewById(R.id.name);
        Email = (TextView) findViewById(R.id.email);
        //Prof_Pic = (ImageView) findViewById(R.id.prof_pic);
        SignIn.setOnClickListener(this);
        Signout.setOnClickListener(this);
        Prof_Section.setVisibility(View.GONE);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();



    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.login_btn:
            signIn();
            break;


            case R.id.logoutbtn:
                signOut();
                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn()
    {

        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);


    }

    private void signOut()
    {

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>()
        {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });
    }

    private void handleResult(GoogleSignInResult result)
    {
        if(result.isSuccess())
        {
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            //String img_url = account.getPhotoUrl().toString();
            Name.setText(name);
            Email.setText(email);
            //Glide.with(this).load(img_url).into(Prof_Pic);

            updateUI(true);
        }
        else
        {

            updateUI(false);
        }

    }

    private void updateUI(boolean isLogin)
    {

        if(isLogin)
        {
            Prof_Section.setVisibility(View.VISIBLE);
            SignIn.setVisibility(View.GONE);
            //Intent intent = new Intent(GoogglePage.this, MainActivity.class);
            //startActivity(intent);

        }
        else
        {
            Prof_Section.setVisibility(View.GONE);
            SignIn.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE)
        {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
            Intent intent = new Intent(GoogglePage.this, MainActivity.class);
            startActivity(intent);
        }




    }
}
