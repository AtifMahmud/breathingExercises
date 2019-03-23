package com.example.atifm.breathingexercises;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ExercisesActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    private TextView mTextMessage;
    FrameLayout exerciseFrame;


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

        // assign variables
        exerciseFrame = (FrameLayout) findViewById(R.id.exerciseFrame);

        // setup action listeners
        setUp();

    }

    private void setUp() {

        // action listener for changing exercise button
        Button changeExerciseButton = (Button) findViewById(R.id.changeExerciseButton);
        changeExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercisePopupMenu(view);
            }
        });
    }

    private void createExercisePopupMenu(View v) {
        PopupMenu changeExerciseMenu = new PopupMenu(this, v);
        changeExerciseMenu.setOnMenuItemClickListener(this);
        changeExerciseMenu.inflate(R.menu.exercise_menu);
        changeExerciseMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        exerciseFrame.removeAllViews();

        switch ((String) menuItem.getTitle()){
            case "The 555 Method":
                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
                View.inflate(this, R.layout.five_five_five_method, exerciseFrame);
                return true;
            case "The 5-4-3-2-1 Method":
                View.inflate(this, R.layout.five_four_three_two_one, exerciseFrame);
                return true;
            case "Interactive Breathing Exercise":
                View.inflate(this, R.layout.interactive_breathing_exercise, exerciseFrame);
                pulsateBall();
                return true;
            default:
                return false;
        }
    }


    private void pulsateBall() {
        ImageView ball = (ImageView) findViewById(R.id.pulsatingBall);

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                ball,
                PropertyValuesHolder.ofFloat("scaleX", 2.0f),
                PropertyValuesHolder.ofFloat("scaleY", 2.0f));
        scaleDown.setDuration(3000);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        // override: deal with later
    }
}

