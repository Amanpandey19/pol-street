package com.pollstreet.polstreet.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.imageview.ShapeableImageView;
import com.pollstreet.polstreet.R;

public class SendVerficationBottomSheet extends BottomSheetDialogFragment {


    Button sendLinkBtn,closeBottomSheet;
    LinearLayout sendLinkLayout;
    LinearLayout linkSentLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.send_verification_link_bottomsheet,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sendLinkBtn      = view.findViewById(R.id.send_verification_link_btn);
        sendLinkLayout   = view.findViewById(R.id.send_verification_layout);
        linkSentLayout   = view.findViewById(R.id.link_sent_layout);
        closeBottomSheet = view.findViewById(R.id.close_layout);

        sendLinkBtn.setOnClickListener(v -> {
            sendLinkLayout.setVisibility(View.GONE);
            linkSentLayout.setVisibility(View.VISIBLE);
        });

        closeBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
