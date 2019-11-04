package com.udemy.fernando.tabby.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udemy.fernando.tabby.R;
import com.udemy.fernando.tabby.model.Person;

import java.util.List;

public class ListCountryAdapter extends BaseAdapter {

    private Context context;
    private List<Person> listPerson;
    private int layout;

    public ListCountryAdapter(Context context, List<Person> listPerson, int layout) {
        this.context = context;
        this.listPerson = listPerson;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listPerson.size();
    }

    @Override
    public Person getItem(int position) {
        return listPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(layout,null);
            holder.imageViewCountry = convertView.findViewById(R.id.imageViewCountry);
            holder.textViewCountry = convertView.findViewById(R.id.textViewCountry);
            holder.textViewName = convertView.findViewById(R.id.textViewName);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        Person person = listPerson.get(position);
        holder.textViewName.setText(person.getName());
        holder.textViewCountry.setText(person.getCountry().getName());

        String flagURL = person.getCountry().getFlagURL(person.getCountry().getCountryCode());
        Picasso.get().load(flagURL).fit().into(holder.imageViewCountry);

        return convertView;
    }

    private class ViewHolder{
        ImageView imageViewCountry;
        TextView textViewName;
        TextView textViewCountry;
    }
}
