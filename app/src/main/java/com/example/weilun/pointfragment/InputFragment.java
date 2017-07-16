package com.example.weilun.pointfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Wei Lun on 7/16/2017.
 */

public class InputFragment extends Fragment {

    private OnButtonClickedListener buttonClickedListener;

    public interface OnButtonClickedListener {
        void onButtonClicked(Line line);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //This makes sure that the container activity has implemeted
        //the callback interface, If not, it throws an exception.
        try{
            buttonClickedListener = (OnButtonClickedListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnButtonClickedListerner");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final EditText etP1X = (EditText)getActivity().findViewById(R.id.point_1_X);
        final EditText etP1Y = (EditText)getActivity().findViewById(R.id.point_1_y);
        final EditText etP2X = (EditText)getActivity().findViewById(R.id.point_2_X);
        final EditText etP2Y = (EditText)getActivity().findViewById(R.id.point_2_X);

        Button button = (Button) getActivity().findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double point1x = Double.parseDouble(etP1X.getText().toString());
                double point1y = Double.parseDouble(etP1Y.getText().toString());
                double point2x = Double.parseDouble(etP2X.getText().toString());
                double point2y = Double.parseDouble(etP2Y.getText().toString());
                Point p1 = new Point(point1x, point1y);
                Point p2 = new Point(point2x, point2y);
                Line line = new Line(p1, p2);
                buttonClickedListener.onButtonClicked(line);
            }
        });
    }
}
