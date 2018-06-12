package com.medipro.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.medipro.MyImage;
import com.medipro.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UploadedDocumentsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Bitmap> images;
    String from;


//public class UploadedDocumentsAdapter extends ArrayAdapter<MyImage>{
//    private static class ViewHolder {
//        ImageView imgIcon;
//
//    }
//    public UploadedDocumentsAdapter(Context context, ArrayList<MyImage> images) {
//        super(context, 0, images);
//    }
    public UploadedDocumentsAdapter(Context c, ArrayList images) {
        context = c;
        this.images= images;


    }
//
////    public UploadedDocumentsAdapter(Context c,Bitmap bitmap, String from) {
//        context = c;
//       this.bitmap=bitmap;
//        this.from = from;
//
//    }

    @Override
    public int getCount() {
        return images.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        ImageView images,close;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            view = LayoutInflater.from(context).inflate(R.layout.cust_grid_upload_prescription, null);
            viewHolder.images = (ImageView) view.findViewById(R.id.iv_img_container);
            viewHolder.close=(ImageView)view.findViewById(R.id.iv_close);
//            if (from.equals("gallery")) {
//                viewHolder.images.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(picturePath.get(0))));
//                Log.e("tag", "picturepath" + picturePath);
//            }
//            else {
//                viewHolder.images.setImageBitmap(bitmap);
//                Log.e("tag", "picturepath" + picturePath);
//            }
           viewHolder.images.setImageBitmap(images.get(position));


            viewHolder.close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
          //         FrameLayout frameLayout = (FrameLayout) v.findViewById(R.id.fl_container_main);
//                    frameLayout.removeAllViews();
                    Toast.makeText(context,"item clicked",Toast.LENGTH_LONG);
                }
            });

            } else

            {
                viewHolder = (ViewHolder) view.getTag();
            }
            return view;
        }}

//@Override public View getView(int position, View convertView,
//                              ViewGroup parent) {
//    // view lookup cache stored in tag
//    ViewHolder viewHolder;
//    // Check if an existing view is being reused, otherwise inflate the
//    // item view
//    if (convertView == null) {
//        viewHolder = new ViewHolder();
//        convertView = LayoutInflater.from(getContext())
//                .inflate(R.layout.cust_grid_upload_prescription, parent, false);
//
//        viewHolder.imgIcon =
//                (ImageView) convertView.findViewById(R.id.iv_img_container);
//        convertView.setTag(viewHolder);
//    } else {
//        viewHolder = (ViewHolder) convertView.getTag();
//    }
//    // Get the data item for this position
//    MyImage image = getItem(position);
//    // set description text
//   // viewHolder.description.setText(image.toString());
//    // set image icon
//    final int THUMBSIZE = 96;
//    //        viewHolder.imgIcon.setImageURI(Uri.fromFile(new File(image
//    // .getPath())));
//    viewHolder.imgIcon.setImageBitmap(ThumbnailUtils
//            .extractThumbnail(BitmapFactory.decodeFile(image.getPath()),
//                    THUMBSIZE, THUMBSIZE));
//
//    // Return the completed view to render on screen
//    return convertView;
//}
//}
//








//