package com.example.user.roomandroid;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.roomandroid.model.Person;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.vk.sdk.api.model.VKList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.08.2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public List<Person> persons;
    //public List<String> vkData;

    /*public RVAdapter(List<Person> persons) {
        this.persons = persons;
    }*/

    public RVAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RVAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.PersonViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).getName());
        holder.secondName.setText(persons.get(position).getSecondName());
        //holder.imageView
    }

    @Override
    public int getItemCount() {
        return  persons.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView personName;
        TextView secondName;
        ImageView imageView;

        public PersonViewHolder(View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.person_name);
            secondName = itemView.findViewById(R.id.person_secondName);
            imageView = itemView.findViewById(R.id.person_photo);
        }
    }
}
