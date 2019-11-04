package com.udemy.fernando.tabby.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.udemy.fernando.tabby.R;
import com.udemy.fernando.tabby.interfaces.FormFragmentCallback;
import com.udemy.fernando.tabby.model.Country;
import com.udemy.fernando.tabby.model.Person;
import com.udemy.fernando.tabby.utils.Utils;

public class FormFragment extends Fragment {

    Context context;
    Spinner spinner;
    EditText editTextName;
    Button btnCreate;

    FormFragmentCallback callback;

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_form, container, false);

        bindComponents(view);
        initCompoents();

        return view;
    }

    private void bindComponents(View view){
        spinner = view.findViewById(R.id.spinner);
        editTextName = view.findViewById(R.id.editTextName);
        btnCreate = view.findViewById(R.id.btnCreate);
    }

    private void initCompoents(){
        spinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Utils.getDummyCountries()));

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                Country country = (Country) spinner.getSelectedItem();
                Person person = new Person(name, country);
                callback.createPerson(person);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        if(context instanceof FormFragmentCallback)
            callback = (FormFragmentCallback) context;
        else
            throw new ClassCastException(context.toString() + " should implements FormFragmentCallback");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

}
