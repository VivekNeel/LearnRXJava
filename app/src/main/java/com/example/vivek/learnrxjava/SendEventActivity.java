package com.example.vivek.learnrxjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vivek on 17/05/17.
 */

public class SendEventActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, SendEventActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_event);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SendEventFragment.newInstance(), "fragment")
                    .addToBackStack(null).commit();
        }
    }
}
