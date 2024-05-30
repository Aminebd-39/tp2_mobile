package com.enset.tp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.enset.tp.R;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.enset.tp.models.MyModel;

public class MyAdapter extends ArrayAdapter<MyModel> {
 private int resource;
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<MyModel> data) {
        super(context, resource, data);
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView =  LayoutInflater.from(getContext()).inflate(this.resource,parent,false); // here I used This.
        }
        MyModel model = getItem(position);

        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewContent = convertView.findViewById(R.id.textViewContent);

        assert model != null;
        textViewTitle.setText(model.getTitle());
        textViewContent.setText(model.getContent());


        return convertView;
    }
    
}
