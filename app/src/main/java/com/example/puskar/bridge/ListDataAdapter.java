package com.example.puskar.bridge;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.R.id.list;

/**
 * Created by puskar on 5/20/2017.
 */

public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView NAME,CONTACT,ADDRESS,MESSAGE;
    }
    @Override
    public  void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row =convertView;
        LayoutHandler layoutHandler;
        if (row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler= new LayoutHandler();
            layoutHandler.NAME= (TextView) row.findViewById(R.id.user_name);
            layoutHandler.CONTACT= (TextView) row.findViewById(R.id.user_contact);
            layoutHandler.ADDRESS= (TextView) row.findViewById(R.id.user_address);
            layoutHandler.MESSAGE= (TextView) row.findViewById(R.id.user_message);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler= (LayoutHandler) row.getTag();

        }
        Dataprovider dataprovider= (Dataprovider) this.getItem(position);
        layoutHandler.NAME.setText(dataprovider.getName());
        layoutHandler.CONTACT.setText(dataprovider.getContact());
        layoutHandler.ADDRESS.setText(dataprovider.getAddress());
        layoutHandler.MESSAGE.setText(dataprovider.getMessage());
        return  row;




      /*  return super.getView(position, convertView, parent);*/
    }
}
