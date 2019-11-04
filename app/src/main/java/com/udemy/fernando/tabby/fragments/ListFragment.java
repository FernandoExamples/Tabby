package com.udemy.fernando.tabby.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.udemy.fernando.tabby.R;
import com.udemy.fernando.tabby.adapters.ListCountryAdapter;
import com.udemy.fernando.tabby.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    ListView listViewPerson;
    List<Person> personList;
    ListCountryAdapter listAdapter;
    Context context;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        bindComponents(view);
        initCompoents();
        return view;
    }

    private void bindComponents(View view){
        listViewPerson = view.findViewById(R.id.listViewPerson);
    }

    private void initCompoents(){
        personList = new ArrayList<>();
        listAdapter = new ListCountryAdapter(context, personList, R.layout.list_item);
        listViewPerson.setAdapter(listAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public void addPerson(Person person){
        personList.add(person);
        listAdapter.notifyDataSetChanged();
    }
}
