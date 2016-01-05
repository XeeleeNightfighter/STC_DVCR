package com.spinxco.stcdvcr;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivityFragment extends Fragment implements View.OnClickListener {

    public MainActivityFragment() {
    }

    View view;
    Button inspectButton;
    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);
        inspectButton = (Button) view.findViewById(R.id.inspectButton);
        inspectButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inspectButton:
                inspectionReport();
                break;
        }
    }

    public void inspectionReport() {


        InspectionFragment frag = new InspectionFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //transaction.hide(this);
        //transaction.show(frag);
        transaction.replace(R.id.fragment, frag);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
