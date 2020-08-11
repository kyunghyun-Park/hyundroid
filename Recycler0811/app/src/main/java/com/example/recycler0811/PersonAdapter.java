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
        RecyclerView.Adapter<PersonAdapter.ViewHolder>
        implements OnPersonItemClickListener {

    ArrayList<Person> items = new ArrayList<>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(itemView, this);
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

    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder,View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, tel, email, addr;
        ImageView addr_img, face;

        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tel = itemView.findViewById(R.id.phone);
            addr = itemView.findViewById(R.id.address);
            email = itemView.findViewById(R.id.email);
            addr_img = itemView.findViewById(R.id.addr_image);
            face = itemView.findViewById(R.id.face);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }


        public void setItem(Person item) {
            //String str= name.getText()+item.getName();
            name.setText(name.getText() + item.getName());
            tel.setText(tel.getText() + item.getTel());
            email.setText(email.getText() + item.getEmail());
            addr.setText(item.getAddr());
            addr_img.setImageResource(item.getAddr_img());
            face.setImageResource(item.getFace());

        }
    }
}
