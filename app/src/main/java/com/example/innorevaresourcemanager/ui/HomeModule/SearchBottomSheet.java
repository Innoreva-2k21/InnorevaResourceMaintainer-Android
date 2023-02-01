package com.example.innorevaresourcemanager.ui.HomeModule;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.innorevaresourcemanager.databinding.SearchBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SearchBottomSheet extends BottomSheetDialog {
    Context context;
    SearchBottomSheetBinding binding;

    public SearchBottomSheet(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SearchBottomSheetBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getBehavior().setSkipCollapsed(true);
        getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);
        getBehavior().setDraggable(false);

        binding.searchBsLayout.setMinHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        binding.backBtnSearch.setOnClickListener(View -> dismiss());
    }
}
