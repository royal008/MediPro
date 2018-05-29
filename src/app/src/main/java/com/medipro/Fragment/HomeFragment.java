package com.medipro.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medipro.Adapter.MainGridViewAdapter;
import com.medipro.Adapter.PopularProductAdapter;
import com.medipro.Common.ExpandableGridView;
import com.medipro.Common.FragmentBeanClass;
import com.medipro.MenuActivity;
import com.medipro.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    View view;
    FragmentBeanClass fbc;
    LinearLayout llUploadPrescription,llBookAppointment,llMenu,llOrderMedicines,llBookTest,llShopping,llAyush,llInsurance,llHealthCenter,llHealthBank;
    ExpandableGridView gvPopularProducts;



    PopularProductAdapter popularProductAdapter;
    ArrayList alPopProductImage,alPopProductName,alPopProductOldPrice,alPopProductDiscount,alPopProductNewPrice;
    TextView tvViewAllProduct;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);

        MenuActivity.llTopBar.setVisibility(View.VISIBLE);
        MenuActivity.llTopBar.setBackgroundResource(R.color.red);
        MenuActivity.ivMenuLines.setImageResource(R.drawable.menu_lines);
        MenuActivity.tvPlaceName.setText("Guindy");
        MenuActivity.tvPlaceName.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.large_text));
        MenuActivity.tvCityName.setVisibility(View.VISIBLE);
        MenuActivity.ivDownArrow.setVisibility(View.VISIBLE);
        MenuActivity.ivSearch.setVisibility(View.VISIBLE);
        MenuActivity.ivCart.setVisibility(View.VISIBLE);

        llUploadPrescription=(LinearLayout)view.findViewById(R.id.ll_upload_prescription);
        llBookAppointment=(LinearLayout)view.findViewById(R.id.ll_book_appointment);
        llMenu=(LinearLayout) view.findViewById(R.id.ll_menu);
        gvPopularProducts=(ExpandableGridView)view.findViewById(R.id.gv_popular_products);
        tvViewAllProduct=(TextView)view.findViewById(R.id.tv_view_all_product);
        llOrderMedicines=(LinearLayout) view.findViewById(R.id.ll_order_medicines);
        llBookTest=(LinearLayout) view.findViewById(R.id.ll_book_test);
        llShopping=(LinearLayout) view.findViewById(R.id.ll_shopping);
        llAyush=(LinearLayout) view.findViewById(R.id.ll_ayush);
        llInsurance=(LinearLayout) view.findViewById(R.id.ll_insurance);
        llHealthCenter=(LinearLayout)view.findViewById(R.id.ll_health_center);
        llHealthBank=(LinearLayout)view.findViewById(R.id.ll_health_bank);




        alPopProductImage=new ArrayList();
        alPopProductName=new ArrayList();
        alPopProductOldPrice=new ArrayList();
        alPopProductDiscount=new ArrayList();
        alPopProductNewPrice=new ArrayList();
        fbc=new FragmentBeanClass((AppCompatActivity) getActivity(),R.id.fl_container_main);

        for(int i=0;i<4;i++){
            alPopProductImage.add(R.drawable.documents);
            alPopProductName.add("Products Name");
            alPopProductOldPrice.add("₹349.0");
            alPopProductDiscount.add("%15.0 OFF");
            alPopProductNewPrice.add("₹297.0");
        }

        popularProductAdapter=new PopularProductAdapter(getActivity(),alPopProductImage,alPopProductName,alPopProductOldPrice,alPopProductDiscount,alPopProductNewPrice);
        gvPopularProducts.setAdapter(popularProductAdapter);
        gvPopularProducts.setExpanded(true);

        onClick();

        return view;
    }



    private void onClick() {

        llOrderMedicines.setOnClickListener(this);
        llBookTest.setOnClickListener(this);
        llShopping.setOnClickListener(this);
        llAyush.setOnClickListener(this);
        llInsurance.setOnClickListener(this);
        llHealthCenter.setOnClickListener(this);
        llHealthBank.setOnClickListener(this);
        llUploadPrescription.setOnClickListener(this);
//        llUploadPrescription.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

//        llOrderMedicines.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new OrderMedicinesFragment());
//            }
//        });
//        llBookTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new BookTestFragment());
//            }
//        });
//        llShopping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new ShoppingFragment());
//            }
//        });

//        llAyush.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new AyushFragment());
//            }
//        });
//        llInsurance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new InsuranceFragment());
//            }
//        });
//        llHealthCenter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new HealthCentersFragment());
//            }
//        });
//        llHealthBank.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fbc.setFragment(new HealthBankFragment());
//            }
//        });

//        gvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0){
//                    fbc.setFragment(new OrderMedicinesFragment());
//                }
//                if(position==1){
//                    fbc.setFragment(new BookTestFragment());
//                }
//                if(position==2){
//                    fbc.setFragment(new ShoppingFragment());
//                }
//                if(position==3) {
//                    if (moreMenu) {
//                        fbc.setFragment(new AyushFragment());
//                    }else{
//                        mainGridViewAdapter=new MainGridViewAdapter(getActivity(),menuImagesMore,menuNameMore,"menu");
//                        gvMenu.setAdapter(mainGridViewAdapter);
//                        gvMenu.setExpanded(true);
//                        moreMenu=true;
//                    }
//                }
//                if(position==4){
//                    fbc.setFragment(new InsuranceFragment());
//                }
//                if(position==5){
//                    fbc.setFragment(new HealthCentersFragment());
//                }
//                if(position==6){
//                    fbc.setFragment(new HealthBankFragment());
//                }
//                if(position==7){
//                    mainGridViewAdapter=new MainGridViewAdapter(getActivity(),menuImagesLess,menuNameLess,"menu");
//                    gvMenu.setAdapter(mainGridViewAdapter);
//                    gvMenu.setExpanded(true);
//                    moreMenu=false;
//                }
//            }
//        });

        llBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbc.setFragment(new BookAppointmentFragment());
            }
        });
        tvViewAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbc.setFragment(new OrderMedicinesFragment());
            }
        });

        gvPopularProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    fbc.setFragment(new MedicalRecordsFragment());
                }
                if(position==1){
                    fbc.setFragment(new AddReminderFragment());
                }

            }
        });
    }

    @Override
    public void onClick(View v)
    {
    switch (v.getId())
    {
        case R.id.ll_upload_prescription:
            fbc.setFragment(new UploadPrescription());
            break;
        case R.id.ll_order_medicines:
            fbc.setFragment(new OrderMedicinesFragment());
            break;

        case R.id.ll_book_test:
            fbc.setFragment(new BookTestFragment());
            break;

        case R.id.ll_shopping:
            fbc.setFragment(new ShoppingFragment());
            break;

        case R.id.ll_ayush:
            fbc.setFragment(new AyushFragment());
            break;
        case R.id.ll_insurance:
            fbc.setFragment(new InsuranceFragment());
            break;
        case R.id.ll_health_center:
            fbc.setFragment(new HealthCentersFragment());
            break;

        case R.id.ll_health_bank:
            fbc.setFragment(new HealthBankFragment());
            break;
    }

    }
}
