package com.example.innorevaresourcemanager.ui.HomeModule;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.innorevaresourcemanager.databinding.SearchBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SearchBottomSheet extends BottomSheetDialog {
    Context context;
    SearchBottomSheetBinding binding;
    InputMethodManager imm;

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
        binding.backBtnSearch.setOnClickListener(View -> {
            if(imm.isAcceptingText()){
                imm.hideSoftInputFromWindow(binding.searchEt.getWindowToken(),0);
            }
            dismiss();
        });

        binding.searchEt.requestFocus();
        imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

}
