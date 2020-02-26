package com.example.spark.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<TasksModel> list;
    List<TasksModel> list2;
    View v;
    TextView taskNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        taskNum = v.findViewById(R.id.task_Num);
        RecyclerView recyclerView = v.findViewById(R.id.today_recycler);
        RecyclerView recyclerView2 = v.findViewById(R.id.tomorrow_recycler);
        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(getContext(),list);
        RecyclerViewAdapter viewAdapter2 = new RecyclerViewAdapter(getContext(),list2);
        recyclerView.setAdapter(viewAdapter);
        recyclerView2.setAdapter(viewAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));

        String num = "Today you have " +viewAdapter.getItemCount()+ " Tasks.";
        taskNum.setText(num);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                viewHolder.getAdapterPosition()
                list.remove(viewHolder.getAdapterPosition());
                Toast.makeText(v.getContext(), "Today Task Deleted", Toast.LENGTH_SHORT).show();
                recyclerView.swapAdapter(viewAdapter, true);
            }
        }).attachToRecyclerView(recyclerView);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                list2.remove(viewHolder.getAdapterPosition());
                Toast.makeText(v.getContext(), "Tomorrow Task Deleted", Toast.LENGTH_SHORT).show();
                recyclerView2.swapAdapter(viewAdapter2, true);
            }
        }).attachToRecyclerView(recyclerView2);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new TasksModel("06:00 AM","Wake Up",R.drawable.checked,R.drawable.leftbg_personal));
        list.add(new TasksModel("09:00 AM","Send Project File",R.drawable.checked,R.drawable.leftbg_study));
        list.add(new TasksModel("12:00 PM","Meeting with Client",R.drawable.circle,R.drawable.leftbg_meeting));

        list2 = new ArrayList<>();
        list2.add(new TasksModel("10:00 AM","Breakfast with Mum",R.drawable.circle,R.drawable.leftbg_meeting));
        list2.add(new TasksModel("12:00 AM","Date with Angela",R.drawable.circle,R.drawable.leftbg_personal));
        list2.add(new TasksModel("12:00 AM","Buy Groceries",R.drawable.circle,R.drawable.leftbg_personal));

    }
}
