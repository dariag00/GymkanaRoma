package com.kloso.gymkanamicuela.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kloso.gymkanamicuela.R;
import com.ornach.nobobutton.NoboButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinalFragment extends Fragment {


    @BindView(R.id.button_reset)
    NoboButton resetButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.final_fragment, container, false);
        ButterKnife.bind(this, rootView);

        resetButton.setOnClickListener(list -> ((MainActivity) getActivity()).resetGame());

        return rootView;
    }

}
