package com.MyApp_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {

    private LayoutInflater lif;
    private int resource;
    private List<Message> messages;

    public MessageAdapter(Context context, int resource, List<Message> messages) {
        super(context, resource, messages);
        this.lif = LayoutInflater.from(context);
        this.resource = resource;
        this.messages = messages;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = lif.inflate(this.resource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();

        final Message p = messages.get(position);
        viewHolder.tvAdress.setText(p.getAddress());
        viewHolder.tvBody.setText( p.getBody());
        viewHolder.tvDate.setText(p.getDate());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvAdress, tvBody, tvDate;

        public ViewHolder(View view) {
            tvAdress = view.findViewById(R.id.tvAddress);
            tvBody = view.findViewById(R.id.tvBody);
            tvDate = view.findViewById(R.id.tvDate);
        }
    }
}