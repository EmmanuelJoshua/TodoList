package com.example.spark.viewpagerdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Dialog addTaskDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
//        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private void click(View view) {
        Button btnMeeting = addTaskDialog.findViewById(R.id.btn_meeting);
        Button btnPersonal = addTaskDialog.findViewById(R.id.btn_personal);
        Button btnStudy = addTaskDialog.findViewById(R.id.btn_study);
        Button btnWork = addTaskDialog.findViewById(R.id.btn_work);

        Drawable drawable;

        if (view.getId() == R.id.btn_meeting) {
            drawable = getResources().getDrawable(R.drawable.meeting_bg);
            setButtonActive(btnMeeting, btnPersonal, btnStudy, btnWork, drawable);
        } else if (view.getId() == R.id.btn_personal) {
            drawable = getResources().getDrawable(R.drawable.personal_bg);
            setButtonActive(btnPersonal, btnMeeting, btnWork, btnStudy, drawable);
        } else if (view.getId() == R.id.btn_study) {
            drawable = getResources().getDrawable(R.drawable.study_bg);
            setButtonActive(btnStudy, btnPersonal, btnMeeting, btnWork, drawable);
        } else if (view.getId() == R.id.btn_work) {
            drawable = getResources().getDrawable(R.drawable.work_bg);
            setButtonActive(btnWork, btnStudy, btnPersonal, btnMeeting, drawable);
        }
    }

    private void setButtonActive(Button active, Button two, Button three, Button four, Drawable drawable) {
        active.setBackground(drawable);
        active.setTextColor(Color.WHITE);

        two.setBackground(null);
        two.setBackgroundColor(Color.TRANSPARENT);
        two.setTextColor(getResources().getColor(R.color.colorText));

        three.setBackground(null);
        three.setBackgroundColor(Color.TRANSPARENT);
        three.setTextColor(getResources().getColor(R.color.colorText));

        four.setBackground(null);
        four.setBackgroundColor(Color.TRANSPARENT);
        four.setTextColor(getResources().getColor(R.color.colorText));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_task:
                        selectedFragment = new TaskFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            };

    public void displayNotification(View view) {
//        ReminderNotification.notify(this);

    }

    public void addTask(View view) {
        addTaskDialog = new Dialog(this);
        addTaskDialog.setContentView(R.layout.dialog_addtask);
        addTaskDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        addTaskDialog.show();
        addTaskDialog.findViewById(R.id.btn_meeting).setOnClickListener(this::click);
        addTaskDialog.findViewById(R.id.btn_personal).setOnClickListener(this::click);
        addTaskDialog.findViewById(R.id.btn_study).setOnClickListener(this::click);
        addTaskDialog.findViewById(R.id.btn_work).setOnClickListener(this::click);

        Bundle bundle = new Bundle();
        bundle.putString("","");
    }
}
