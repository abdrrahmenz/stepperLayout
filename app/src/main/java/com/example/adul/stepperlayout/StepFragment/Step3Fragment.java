package com.example.adul.stepperlayout.StepFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adul.stepperlayout.R;

/**
 * Created by adul on 30/04/17.
 */

public class Step3Fragment extends Fragment {

    private View view;
    private TextView textViewNamaLengkap;
    private TextView textViewAlamat;
    private TextView textViewNamaIbu;
    private TextView textViewNamaAyah;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_step3, container, false);
        loadComponent();
        return view;
    }

    private void loadComponent() {
        textViewNamaLengkap = (TextView) view.findViewById(R.id.text_view_nama_lengkap);
        textViewAlamat = (TextView) view.findViewById(R.id.text_view_alamat);
        textViewNamaIbu = (TextView) view.findViewById(R.id.text_view_nama_ibu);
        textViewNamaAyah = (TextView) view.findViewById(R.id.text_view_nama_ayah);

        Bundle bundle = getArguments();
        textViewNamaLengkap.setText(bundle.getString("namaLengkap"));
        textViewAlamat.setText(bundle.getString("alamat"));
        textViewNamaIbu.setText(bundle.getString("namaIbu"));
        textViewNamaAyah.setText(bundle.getString("namaAyah"));
    }
}
