package com.example.gging.afinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Record extends Fragment {


    EditText editText;

    public Record() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_record, container, false);

        editText = view.findViewById(R.id.edt_record);
        return view;
    }

    public void RecordNew(String NewNum){
        editText.setText(NewNum + "\n" + editText.getText());
    };

}
