package com.example.atifm.breathingexercises;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ExercisesActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    private TextView mTextMessage;

    // automatically generated
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // setup action listeners
        setUpActionListeners();

    }

    private void setUpActionListeners() {

        // action listener for changing exercise button
        Button changeExerciseButton = (Button) findViewById(R.id.changeExerciseButton);
        changeExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercisePopupMenu(view);
            }
        });
    }

    // method for debugging
    private void showTestToast(String string) {
        Toast.makeText(getApplicationContext(),string + " Hello ", Toast.LENGTH_SHORT).show();
    }


    private void createExercisePopupMenu(View v) {
        PopupMenu changeExerciseMenu = new PopupMenu(this, v);
        changeExerciseMenu.setOnMenuItemClickListener(this);
        changeExerciseMenu.inflate(R.menu.exercise_menu);
        changeExerciseMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        showTestToast((String) menuItem.getTitle());
        return false;
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

