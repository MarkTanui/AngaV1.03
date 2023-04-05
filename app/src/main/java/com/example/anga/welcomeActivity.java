package com.example.anga;

import androidx.appcompat.app.AppCompatActivity;

// Firebase Dependencies
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class welcomeActivity extends AppCompatActivity {

    ImageView start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        start = findViewById(R.id.start_btn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = mAuth.getCurrentUser();

                if (user != null){
                    startActivity(new Intent(welcomeActivity.this, MpesaStkActivity.class));
                }else {
                    startActivity(new Intent(welcomeActivity.this, SignInActivity.class));
                }
            }
        });
    }
}