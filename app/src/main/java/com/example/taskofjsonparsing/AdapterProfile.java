package com.example.taskofjsonparsing;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class AdapterProfile extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MainActivity mainActivity;
    LayoutInflater inflater;
    List<ProfileList> contactData = Collections.emptyList();
    ProfileList current;
    int currentPos = 0;

    public AdapterProfile(MainActivity mainActivity, List<ProfileList> contactData) {
        this.mainActivity = mainActivity;
        inflater = LayoutInflater.from(mainActivity);
        this.contactData = contactData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.profile_list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyHolder myHolder = (MyHolder) holder;
        ProfileList current = contactData.get(position);
        myHolder.textId.setText(current.id);
        myHolder.textName.setText(current.name);
        myHolder.textEmail.setText(current.email);
        Glide.with(mainActivity).load(current.userimage).into(myHolder.textImage);
        myHolder.textAddress.setText(current.address);
        myHolder.textMobile.setText(current.mobile);
        myHolder.textHome.setText(current.home);

        if (current.gender.matches("female")) {
            myHolder.textFemale.setTypeface(null, Typeface.BOLD);
            myHolder.textMale.setTypeface(null, Typeface.NORMAL);
        } else {
            myHolder.textMale.setTypeface(null, Typeface.BOLD);
            myHolder.textFemale.setTypeface(null, Typeface.NORMAL);
        }

        myHolder.idRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactData.remove(position);
                notifyDataSetChanged();
                Toast.makeText(mainActivity.getApplicationContext(), "Item Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView textId;
        TextView textName;
        TextView textEmail;
        TextView textAddress;
        TextView textFemale;
        TextView textMale;
        ImageView textImage;
        TextView textMobile;
        TextView textHome;
        Button idRemove;

        public MyHolder(View itemView) {
            super(itemView);
            textId = (TextView) itemView.findViewById(R.id.textId);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textEmail = (TextView) itemView.findViewById(R.id.textEmail);
            textAddress = (TextView) itemView.findViewById(R.id.textAddress);
            textFemale = (TextView) itemView.findViewById(R.id.textFemale);
            textMale = (TextView) itemView.findViewById(R.id.textMale);
            textImage = (ImageView) itemView.findViewById(R.id.textImage);
            textMobile = (TextView) itemView.findViewById(R.id.textMobile);
            textHome = (TextView) itemView.findViewById(R.id.textHome);
            idRemove = (Button) itemView.findViewById(R.id.idRemove);
        }
    }
}
