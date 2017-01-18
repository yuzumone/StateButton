package net.yuzumone.state.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import net.yuzumone.statebutton.OnStateButtonListener;
import net.yuzumone.statebutton.StateButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StateButton button = (StateButton) findViewById(R.id.button);
        button.setOnStateButtonListener(new OnStateButtonListener() {
            @Override
            public void trued(StateButton stateButton) {
                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void falsed(StateButton stateButton) {
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
