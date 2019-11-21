package com.android.assignment3.ui.student;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.assignment3.R;
import com.android.assignment3.Adapter.StudentlistAdpt;
import com.android.assignment3.model.DataSet;
import com.android.assignment3.ui.MainWindow;
import com.android.assignment3.ui.Home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    EditText sname, saddress, sage;
    Button btnAdd;
    RadioGroup genderRG;
    String sn = "", sa = "", sadd = "", gen = "";
    View view;
    List<DataSet> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_adduser, container, false);
        sname = view.findViewById(R.id.etASnmae);
        saddress = view.findViewById(R.id.etASaddress);
        sage = view.findViewById(R.id.etASage);
        sname = view.findViewById(R.id.etASnmae);
        genderRG = view.findViewById(R.id.rgGender);
        btnAdd = view.findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(sname.getText().toString())) {
                    sname.setError("please enter name");
                    return;
                } else if (TextUtils.isEmpty(saddress.getText().toString())) {
                    saddress.setError("please enter address");

                    return;
                } else if (TextUtils.isEmpty(sage.getText().toString())) {
                    sage.setError("please enter age");
                    return;
                } else {
                    sn = sname.getText().toString();
                    sadd = saddress.getText().toString();
                    sa = sage.getText().toString();
                }

                int selectid = genderRG.getCheckedRadioButtonId();
                if (selectid > 0) {
                    RadioButton radioButton = getView().findViewById(selectid);
                    gen = radioButton.getText().toString();
                    Toast.makeText(getContext(), "Student added with name " + sn, Toast.LENGTH_SHORT).show();
                    DataSet dataSet = new DataSet(sn, sadd, sa, gen);
                    studentList = dataSet.getSlist();
                    studentList.add(dataSet);
                    dataSet.setSlist(studentList);
                    sname.setText("");
                    saddress.setText("");
                    sage.setText("");
                } else {
                    Toast.makeText(getContext(), "Please select gender", Toast.LENGTH_SHORT).show();
                }


            }
        });
        return view;
    }


}
