package com.medipro.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.medipro.Adapter.SpecialistsAdapter;
import com.medipro.MenuActivity;
import com.medipro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DermatologistsFragment extends Fragment {
    View view;
    ListView lvDematologists;
    SpecialistsAdapter specialistsAdapter;
    ImageView ivBack;
    public DermatologistsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_dermatologists, container, false);
        MenuActivity.llTopBar.setVisibility(View.GONE);

        specialistsAdapter=new SpecialistsAdapter(getActivity());
        lvDematologists=(ListView)view.findViewById(R.id.lv_dermatologists_list);
        lvDematologists.setAdapter(specialistsAdapter);

        ivBack=(ImageView)view.findViewById(R.id.iv_back);

        onClick();

        return view;
    }
    private void onClick() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }

}

