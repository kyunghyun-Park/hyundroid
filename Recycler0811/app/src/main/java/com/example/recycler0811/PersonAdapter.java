package com.example.recycler0811;

import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.xml.namespace.QName;

public class PersonAdapter extends
        RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    ArrayList<Person> items = new ArrayList<>();

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person item) {
        items.add(item);
    }

    public Person getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, tel, email, addr;
        ImageView addr_img, face;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tel = itemView.findViewById(R.id.phone);
            addr = itemView.findViewById(R.id.address);
            email = itemView.findViewById(R.id.email);
            addr_img = itemView.findViewById(R.id.addr_image);
            face = itemView.findViewById(R.id.face);
        }

        public void setItem(Person item) {
            name.setText(item.getName());
            tel.setText(item.getTel());
            email.setText(item.getEmail());
            addr.setText(item.getAddr());
            addr_img.setImageResource(item.getAddr_img());
            face.setImageResource(item.getFace());

        }
    }
}
