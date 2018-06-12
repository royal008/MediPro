package com.medipro.Fragment;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.medipro.Adapter.UploadedDocumentsAdapter;
import com.medipro.MainActivity;
import com.medipro.MenuActivity;
import com.medipro.MyImage;
import com.medipro.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class UploadPrescription extends Fragment implements View.OnClickListener {
    View view;
    GridView gvUploadedDocuments;
    TextView tvContinue, tvGallery, tvCamera;
    UploadedDocumentsAdapter uploadedDocumentsAdapter;
    ImageView ivBack, ivClose;
    private static int Result_code = 1;
    private int Request_Read_Permission = 2;
    private static final int CAMERA_REQUEST = 1888;
    private static final int GALLERY_REQUEST = 100;
    ArrayList<Bitmap> uploadArrary;
    Bitmap image;
 //  private Uri mCapturedImageURI;
//    private ArrayList<MyImage> images;

    //   private List<String> listOfImagesPath = null;

    //   private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // public static final String GridViewDemo_ImagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/GridViewDemo/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upload_prescription, container, false);

        MenuActivity.llTopBar.setVisibility(View.GONE);
//        MenuActivity.llTopBar.setBackgroundResource(R.drawable.ad_common);
//        MenuActivity.ivMenuLines.setImageResource(R.drawable.left_arrow);
//        MenuActivity.tvPlaceName.setText("UPLOAD YOUR "+"\n"+"PRESCRIPTION");
//        MenuActivity.tvPlaceName.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.xlarge_text));
//        MenuActivity.tvPlaceName.setTypeface(null, Typeface.NORMAL);
//        MenuActivity.tvCityName.setVisibility(View.GONE);
//        MenuActivity.ivDownArrow.setVisibility(View.GONE);
//        MenuActivity.ivSearch.setVisibility(View.GONE);
//        MenuActivity.ivCart.setVisibility(View.GONE);

       // uploadArrary = new ArrayList<Bitmap>();
        uploadArrary = new ArrayList();
     //   uploadedDocumentsAdapter = new UploadedDocumentsAdapter(getActivity(),uploadArrary);
        gvUploadedDocuments = (GridView) view.findViewById(R.id.gv_uploaded_documents);
     //   gvUploadedDocuments.setAdapter(uploadedDocumentsAdapter);

        tvContinue = (TextView) view.findViewById(R.id.tv_continue_up);
        ivBack = (ImageView) view.findViewById(R.id.iv_back);
        tvGallery = (TextView) view.findViewById(R.id.tv_gallery);
        ivClose = (ImageView) view.findViewById(R.id.iv_close);
        tvCamera = (TextView) view.findViewById(R.id.tv_camera);
        OnClick();
        // return view;
//        listOfImagesPath = null;
//        listOfImagesPath = RetriveCapturedImagePath();
//        if (listOfImagesPath != null) {
//            gvUploadedDocuments.setAdapter(new UploadedDocumentsAdapter(getActivity(), listOfImagesPath,"camera"));
//        }
        return view;
    }

    private void OnClick() {
        tvGallery.setOnClickListener(this);
        tvContinue.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        tvCamera.setOnClickListener(this);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Request_Read_Permission) {
            Log.e("gallery", " gallery permission");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, Result_code);
            }
        }
//        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
//           if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.e("camera","camera permission");
//                Toast.makeText(getActivity(), "camera permission granted", Toast.LENGTH_LONG).show();
//                Intent cameraIntent = new
//                        Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, CAMERA_REQUEST);
//           } else {
//              Toast.makeText(getActivity(), "camera permission denied", Toast.LENGTH_LONG).show();
//           }
//
//        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Result_code && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            image = BitmapFactory.decodeFile(String.valueOf(picturePath));
            uploadArrary.add(image);
            Log.e("gallery","image added");
                }

        else if (requestCode == CAMERA_REQUEST) {
            image = (Bitmap) data.getExtras().get("data");
           uploadArrary.add(image);
            Log.e("camera","image added");
        }
        uploadedDocumentsAdapter = new UploadedDocumentsAdapter(getActivity(),uploadArrary);
       // gvUploadedDocuments = (GridView) view.findViewById(R.id.gv_uploaded_documents);
        gvUploadedDocuments.setAdapter(uploadedDocumentsAdapter);
        }









//        if (requestCode == Result_code && resultCode == RESULT_OK && data != null) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(picturePath));
//            uploadArrary.add(bitmap);
//
//            Log.e("onActivityResult: ", "picturepath");
//            cursor.close();
//            Log.e("onActivityResult: ", "clicked");
//
////            for (int i = 0; i < cursor.getCount(); i++) {
////                cursor.moveToPosition(i);
////                int columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
////                uploadArrary = new ArrayList<String>();//get column index
////                uploadArrary.add(cursor.getString(columnIndex));//get Image from column index
//
//
////                uploadedDocumentsAdapter = new UploadedDocumentsAdapter(getActivity(), uploadArrary, "gallery");
////                gvUploadedDocuments.setAdapter(uploadedDocumentsAdapter);
//
//        } else if (requestCode == CAMERA_REQUEST) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            uploadArrary.add(photo);
//        }
//        uploadedDocumentsAdapter = new UploadedDocumentsAdapter(getActivity(),uploadArrary , "camera");
//        gvUploadedDocuments.setAdapter(uploadedDocumentsAdapter);
//    }



    private void showSpecifyMedicinesDialog() {
        final Dialog specifyMedicinesDialog = new Dialog(getActivity());
        specifyMedicinesDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        specifyMedicinesDialog.setContentView(R.layout.specify_medicine_dialog);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(specifyMedicinesDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        specifyMedicinesDialog.getWindow().setAttributes(lp);
        specifyMedicinesDialog.show();
        ImageView ivCancel = (ImageView) specifyMedicinesDialog.findViewById(R.id.iv_cancel);
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specifyMedicinesDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_continue_up:
                showSpecifyMedicinesDialog();
                break;
            case R.id.iv_back:
                getFragmentManager().popBackStack();
                break;
            case R.id.tv_gallery:
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Request_Read_Permission);
                } else {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, Result_code);
                }

                break;
            case R.id.tv_camera:

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
                break;
        }}




}






