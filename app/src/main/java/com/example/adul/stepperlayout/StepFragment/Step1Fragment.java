package com.example.adul.stepperlayout.StepFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.adul.stepperlayout.MainActivity;
import com.example.adul.stepperlayout.R;

/**
 * Created by adul on 30/04/17.
 */

public class Step1Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText editTextNamaLengkap;
    private EditText editTextAlamat;
    private Button buttonNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_step1, container, false);
        loadComponent();
        return view;
    }

    private void loadComponent() {
        editTextNamaLengkap = (EditText) view.findViewById(R.id.edit_text_nama_lengkap);
        editTextAlamat = (EditText) view.findViewById(R.id.edit_text_alamat);
        buttonNext = (Button) view.findViewById(R.id.button_next_fragment_step_1);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonNext) {
            String namaLengkap = editTextNamaLengkap.getText().toString().trim();
            String alamat = editTextAlamat.getText().toString().trim();
            MainActivity.goToStepOrangTua();
            Step2Fragment step2Fragment = new Step2Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("namaLengkap", namaLengkap.isEmpty() ? "-" : namaLengkap);
            bundle.putString("alamat", alamat.isEmpty() ? "-" : alamat);
            step2Fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                    .replace(R.id.frame_layout, step2Fragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
