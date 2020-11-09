package com.MyApp_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    private LayoutInflater lif;
    private int resource;
    private List<Contacts> contacts;

    public ContactsAdapter(Context context, int resource, List<Contacts> contacts) {
        super(context, resource, contacts);
        this.lif = LayoutInflater.from(context);
        this.resource = resource;
        this.contacts = contacts;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = lif.inflate(this.resource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();

        final Contacts p = contacts.get(position);
        viewHolder.tvNameContact.setText(p.getNameContact());
        viewHolder.tvNumberPhone.setText(p.getNumberPhone());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvNameContact, tvNumberPhone;
        public ViewHolder(View view) {
            tvNameContact = view.findViewById(R.id.tvNameContact);
            tvNumberPhone = view.findViewById(R.id.tvNumberPhone);
        }
    }
}