package com.example.administrator.doan_application;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChucNangMoRongFragment extends Fragment {

    LinearLayout mainLayout;

    CardView cardBamGio, cardDemNguoc;

    public ChucNangMoRongFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainLayout = (LinearLayout) getView().findViewById(R.id.mainLayout);

        cardBamGio = (CardView) getView().findViewById(R.id.cardBamGio);

        cardDemNguoc = (CardView) getView().findViewById(R.id.cardDemNguoc);

        // Bam Gio
        setSingleEventBamGio(mainLayout);

        // Dem Nguoc
        setSingleEventDemNguoc(mainLayout);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuc_nang_mo_rong, container, false);
    }

    private void setSingleEventBamGio(LinearLayout mainLayout) {

        cardBamGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_bamgio = new Intent(ChucNangMoRongFragment.this.getActivity(), BamGioActivity.class);
                intent_bamgio.putExtra("info", "Man hinh 1" );
                startActivity(intent_bamgio);
            }
        });

    }

    private void setSingleEventDemNguoc(LinearLayout mainLayout){

        cardDemNguoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_demnguoc = new Intent(ChucNangMoRongFragment.this.getActivity(), DemNguocActivity.class);
                intent_demnguoc.putExtra("info", "Manhinh 2");
                startActivity(intent_demnguoc);
            }
        });
    }

}
