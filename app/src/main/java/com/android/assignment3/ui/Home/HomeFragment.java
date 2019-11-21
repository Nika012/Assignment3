package com.android.assignment3.ui.Home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.assignment3.Adapter.StudentlistAdpt;
import com.android.assignment3.R;

import com.android.assignment3.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public RecyclerView recyclerView;
    View view;
    List<DataSet> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.RcView);
        DataSet sd = new DataSet("Niru", "Biratnagar", "42", "female");

        studentList = sd.getSlist();
        if (studentList.isEmpty()) {
            studentList.add(sd);
            studentList.add(new DataSet("Ram", "Kathmandu", "12", "male"));
            sd.setSlist(studentList);
        }

        StudentlistAdpt StudentlistAdpt = new StudentlistAdpt(getActivity(), studentList);
        recyclerView.setAdapter(StudentlistAdpt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }



}
