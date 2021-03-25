package com.example.paiementenligne;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment {


    private EditText mEditPseudo;
    private EditText mEditMotDePasse;
    private SimpleDialogListener listener;
    private Button btn;


    public SimpleDialogFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static com.example.paiementenligne.SimpleDialogFragment newInstance(String title) {

        com.example.paiementenligne.SimpleDialogFragment frag = new com.example.paiementenligne.SimpleDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_simple_dialog_paypal, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        listener = (SimpleDialogListener) getActivity();

        mEditPseudo = (EditText) view.findViewById(R.id.txt_pseudo);
        mEditMotDePasse = (EditText) view.findViewById(R.id.txt_password);

        btn = (Button) view.findViewById(R.id.ok);

        // quand le button est cliqué, l'activité est appellé,
        // la valeur mEditText est passeé à l'activité en paramètre

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOkClickDialog(mEditPseudo.getText().toString());
            }
        });

        String title = getArguments().getString("title", "Votre nom");

        getDialog().setTitle(title);

        mEditPseudo.requestFocus();

        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }


}
