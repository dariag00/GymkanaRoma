package com.kloso.gymkanamicuela.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.kloso.gymkanamicuela.R;

public class LevelDialog extends DialogFragment {


    private String description;

    public LevelDialog(String description){
        this.description = description;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Información Extra");
        builder.setIcon(R.drawable.hotel);
        builder.setMessage(description)
                .setPositiveButton("Ok", (dialog, id) -> {
                    // FIRE ZE MISSILES!
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
