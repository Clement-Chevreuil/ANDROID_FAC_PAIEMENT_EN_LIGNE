package com.example.paiementenligne;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    public AlertDialogFragment() {
        // Empty constructor required for DialogFragment
    }


    public static com.example.paiementenligne.AlertDialogFragment newInstance(String title) {

        com.example.paiementenligne.AlertDialogFragment frag = new com.example.paiementenligne.AlertDialogFragment();

        Bundle args = new Bundle();

        args.putString("title", title);

        frag.setArguments(args);

        return frag;

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String title = getArguments().getString("title");

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle(title);

        alertDialogBuilder.setMessage("Are you sure?");

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Ok clicked", Toast.LENGTH_SHORT).show();
            }

        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });


        return alertDialogBuilder.create();

    }

}