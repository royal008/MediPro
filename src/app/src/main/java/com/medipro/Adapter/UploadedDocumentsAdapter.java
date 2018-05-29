package com.medipro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medipro.R;

/**
 * Created by Deepa on 03-12-2017.
 */

public class UploadedDocumentsAdapter extends BaseAdapter {
    Context context;
    public UploadedDocumentsAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class ViewHolder{

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        ViewHolder viewHolder;
        if(view==null){
            viewHolder=new ViewHolder();

                view = LayoutInflater.from(context).inflate(R.layout.cust_grid_upload_prescription, null);
//                viewHolder.images = (ImageView) view.findViewById(R.id.iv_grid_menu);
//                viewHolder.images.setImageResource(images[position]);
//                viewHolder.tvMenuName = (TextView) view.findViewById(R.id.tv_menu_name);
//                viewHolder.tvMenuName.setText(menuName[position]);

                view.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        return view;
    }
}
