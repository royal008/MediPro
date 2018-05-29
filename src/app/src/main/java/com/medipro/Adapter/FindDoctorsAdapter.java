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
 * Created by Deepa on 04-12-2017.
 */

public class FindDoctorsAdapter extends BaseAdapter {

    Context context;
    int[] specialistImg;
    String[] specialistsName;
    public FindDoctorsAdapter(Context context,int[] specialistImg,String[] specialistsName){
        this.context=context;
        this.specialistImg=specialistImg;
        this.specialistsName=specialistsName;
    }
    @Override
    public int getCount() {
        return specialistImg.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    class ViewHolder{
        ImageView ivSpecialist;
        TextView tvSpecialist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            view = LayoutInflater.from(context).inflate(R.layout.cust_find_doctors_list, null);
                viewHolder.ivSpecialist = (ImageView) view.findViewById(R.id.iv_specialist);
                viewHolder.ivSpecialist.setImageResource(specialistImg[position]);
                viewHolder.tvSpecialist = (TextView) view.findViewById(R.id.tv_specialist);
                viewHolder.tvSpecialist.setText(specialistsName[position]);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }
}
