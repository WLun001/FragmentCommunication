package com.example.weilun.pointfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Wei Lun on 7/16/2017.
 */

public class OutputFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.output_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        Point midpoint = (Point)bundle.getSerializable(MainActivity.MIDPOINT);

        EditText etMidpoint = (EditText) getActivity().findViewById(R.id.midpoint);
        etMidpoint.setText(Double.toString(midpoint.getX()) + ", " + Double.toString(midpoint.getY()));
    }
}
