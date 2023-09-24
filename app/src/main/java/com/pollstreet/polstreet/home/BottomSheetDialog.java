package com.pollstreet.polstreet.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.imageview.ShapeableImageView;
import com.pollstreet.polstreet.R;

public class BottomSheetDialog extends BottomSheetDialogFragment {


    String[] months = { "Jan", "Feb",
            "Mar", "Apr","May","Jun","Jul","Aug","Sep",
            "Oct", "Nov","Dec" };

    String[] year = { "2023", "2024",
            "2025", "2026","2027","2028","2029","2030","2031",
            "2032", "2033","2034"};

    Spinner monthSpinner;
    TextView yeartv, monthtv;
    Spinner yearSpinner;
    ArrayAdapter monthsAdapter,yearsAdapter;

    ShapeableImageView closeBottomSheet;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottomsheetlayout,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         monthSpinner= view.findViewById(R.id.monthSpinner);
         yearSpinner= view.findViewById(R.id.yearSpinner);
         monthtv = view.findViewById(R.id.month_tv);
         yeartv = view.findViewById(R.id.year_tv);
         closeBottomSheet = view.findViewById(R.id.close_bottom_sheet);

         monthsAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, months);
         monthsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         yearsAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, year);
         yearsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 yeartv.setText(""+year[position]);
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {
                 yeartv.setText("Year");

             }
         });

         monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 monthtv.setText(""+months[position]);
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

         closeBottomSheet.setOnClickListener(v -> dismiss());
         yearSpinner.setAdapter(yearsAdapter);
         monthSpinner.setAdapter(monthsAdapter);
    }
}
