package com.medipro.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.medipro.Adapter.AyushMainAdapter;
import com.medipro.MenuActivity;
import com.medipro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GymFragment extends Fragment {
    View view;
    ImageView ivBack;
    ListView lvGym;
    AyushMainAdapter ayushMainAdapter;


    public GymFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_gym, container, false);

        MenuActivity.llTopBar.setVisibility(View.GONE);


        ayushMainAdapter = new AyushMainAdapter(getActivity());
        ivBack=(ImageView)view.findViewById(R.id.iv_back);
        lvGym=(ListView)view.findViewById(R.id.lv_gym_list);
        lvGym.setAdapter(ayushMainAdapter);
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
