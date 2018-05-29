package com.medipro.Fragment;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.medipro.Adapter.UploadedDocumentsAdapter;
import com.medipro.MenuActivity;
import com.medipro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UploadPrescription extends Fragment {
    View view;
    GridView gvUploadedDocuments;
    TextView tvContinue;
    UploadedDocumentsAdapter uploadedDocumentsAdapter;
    ImageView ivBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_upload_prescription, container, false);

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

        uploadedDocumentsAdapter=new UploadedDocumentsAdapter(getActivity());

        gvUploadedDocuments=(GridView)view.findViewById(R.id.gv_uploaded_documents);
        gvUploadedDocuments.setAdapter(uploadedDocumentsAdapter);

        tvContinue=(TextView)view.findViewById(R.id.tv_continue_up);
        ivBack=(ImageView)view.findViewById(R.id.iv_back);
        OnClick();
        return view;
    }

    private void OnClick() {
        tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpecifyMedicinesDialog();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }

    private void showSpecifyMedicinesDialog() {
        final Dialog specifyMedicinesDialog=new Dialog(getActivity());
        specifyMedicinesDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        specifyMedicinesDialog.setContentView(R.layout.specify_medicine_dialog);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(specifyMedicinesDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        specifyMedicinesDialog.getWindow().setAttributes(lp);
        specifyMedicinesDialog.show();
        ImageView ivCancel=(ImageView)specifyMedicinesDialog.findViewById(R.id.iv_cancel);
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specifyMedicinesDialog.dismiss();
            }
        });
    }

}
