package com.example.vivek.learnrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView firstText = (TextView) findViewById(R.id.firstText);
        final TextView secondText = (TextView) findViewById(R.id.secondText);

        RXBus.getRXBusInstance().getEvents().subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                if (o instanceof ClickEvent) {
                    secondText.setText("Received event!");
                } else if (o instanceof ButtonClickEvent) {
                    secondText.setText("Received event from second activity fragment");
                }
            }
        });

        firstText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RXBus.getRXBusInstance().sendEvent(new ClickEvent());
                SendEventActivity.start(MainActivity.this);
            }
        });
    }
}
