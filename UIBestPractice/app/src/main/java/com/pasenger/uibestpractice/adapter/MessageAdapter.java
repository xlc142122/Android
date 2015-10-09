package com.pasenger.uibestpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pasenger.uibestpractice.R;
import com.pasenger.uibestpractice.constant.MessageType;
import com.pasenger.uibestpractice.entity.Message;

import java.util.List;

/**
 * Created by Pasenger on 15/10/9.
 */
public class MessageAdapter extends ArrayAdapter<Message> {

    private int resourceId;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);

        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);

        View view;
        ViewHolder viewHolder;

        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.leftMessage = (TextView) view.findViewById(R.id.left_msg);
            viewHolder.rightMessage = (TextView) view.findViewById(R.id.right_msg);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if(MessageType.RECEIVER.ordinal() == message.getType()){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);

            viewHolder.leftMessage.setText(message.getContent());
        }else{
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);

            viewHolder.rightMessage.setText(message.getContent());
        }

        return view;
    }

    class ViewHolder {
        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMessage;

        TextView rightMessage;
    }
}
