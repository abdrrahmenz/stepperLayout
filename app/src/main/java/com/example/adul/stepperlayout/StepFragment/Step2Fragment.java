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

public class Step2Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText editTextNamaIbu;
    private EditText editTextNamaAyah;
    private Button buttonNext;
    private String namaLengkap;
    private String alamat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_step2, container, false);
        loadComponent();
        return view;
    }

    private void loadComponent() {
        editTextNamaIbu = (EditText) view.findViewById(R.id.edit_text_nama_ibu);
        editTextNamaAyah = (EditText) view.findViewById(R.id.edit_text_nama_ayah);
        buttonNext = (Button) view.findViewById(R.id.button_next_fragment_step_2);
        buttonNext.setOnClickListener(this);

        Bundle bundle = getArguments();
        namaLengkap = bundle.getString("namaLengkap");
        alamat = bundle.getString("alamat");
    }

    @Override
    public void onClick(View view) {
        if (view == buttonNext) {
            MainActivity.goToStepUlasan();
            String namaIbu = editTextNamaIbu.getText().toString().trim();
            String namaAyah = editTextNamaAyah.getText().toString().trim();
            Step3Fragment step3Fragment = new Step3Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("namaLengkap", namaLengkap);
            bundle.putString("alamat", alamat);
            bundle.putString("namaIbu", namaIbu.isEmpty() ? "-" : namaIbu);
            bundle.putString("namaAyah", namaAyah.isEmpty() ? "-" : namaAyah);
            step3Fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                    .replace(R.id.frame_layout, step3Fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
