package com.medipro.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.medipro.Adapter.FindDoctorsAdapter;
import com.medipro.Common.FragmentBeanClass;
import com.medipro.MenuActivity;
import com.medipro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookAppointmentFragment extends Fragment {
    View view;
    ListView lvFindDoctors;
    FindDoctorsAdapter findDoctorsAdapter;
    int specialistImgs[]={R.drawable.myfavoritedoctors,R.drawable.ayurvedic_specialist,R.drawable.dermatologists,R.drawable.cardiologist,
    R.drawable.chestspecialists,R.drawable.cosmeticsurgeons,R.drawable.dentists,R.drawable.diabetologists};
    String specialistNames[]={"My Favorite Doctors","Opthalmologist","Dermatologists","Cardiologist","Gastroenterologists",
            "Phychiartist", "Ear-Nose-Throat(ENT) Specialist","Gynaecologists"};
    FragmentBeanClass fbc;
    ImageView ivBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_book_appointment, container, false);

        MenuActivity.llTopBar.setVisibility(View.GONE);
//        MenuActivity.llTopBar.setBackgroundResource(R.drawable.finddoctors);
//        MenuActivity.ivMenuLines.setImageResource(R.drawable.left_arrow);
////        MenuActivity.tvPlaceName.setText(getResources().getString(R.string.find_doctors));
//        MenuActivity.tvPlaceName.setTextSize(0);
//        MenuActivity.tvPlaceName.setTypeface(null, Typeface.NORMAL);
//        MenuActivity.tvPlaceName.setText(getResources().getString(R.string.find_doctors));
////        MenuActivity.tvPlaceName.setText(Html.fromHtml(getResources().getString(R.string.find_doctors)));
//        MenuActivity.tvCityName.setVisibility(View.GONE);
//        MenuActivity.ivDownArrow.setVisibility(View.GONE);
//        MenuActivity.ivSearch.setVisibility(View.VISIBLE);
//        MenuActivity.ivCart.setVisibility(View.VISIBLE);
//        MenuActivity.ivCart.setImageResource(R.drawable.filter_white);

        fbc=new FragmentBeanClass((AppCompatActivity) getActivity(),R.id.fl_container_main);
        ivBack=(ImageView)view.findViewById(R.id.iv_back);
        findDoctorsAdapter=new FindDoctorsAdapter(getActivity(),specialistImgs,specialistNames);
        lvFindDoctors=(ListView)view.findViewById(R.id.lv_find_doctors);
        lvFindDoctors.setAdapter(findDoctorsAdapter);

        onClick();
        return view;
    }

    private void onClick() {
        lvFindDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    fbc.setFragment(new FavoriteDoctorsFragment());
                }
                if(position==1){
                    fbc.setFragment(new OpthalmologistFragment());
                }
                if(position==2){
                    fbc.setFragment(new DermatologistsFragment());
                }
                if(position==3){
                    fbc.setFragment(new CardiologistFragment());
                }
                if(position==4){
                    fbc.setFragment(new GastroenterologistsFragment());
                }
                if(position==5){
                    fbc.setFragment(new PhychiartistFragment());
                }
                if(position==6){
                    fbc.setFragment(new ENTSpecialistFragment());
                }
                if(position==7){
                    fbc.setFragment(new GynaecologistsFragment());
                }
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }

}
