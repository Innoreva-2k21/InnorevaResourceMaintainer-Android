package com.example.innorevaresourcemanager.ui.HomeModule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.innorevaresourcemanager.databinding.SearchBottomSheetBinding;
import com.example.innorevaresourcemanager.ui.HomeModule.adapters.SearchItemAdapter;
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class SearchBottomSheet extends BottomSheetDialog {
    Context context;
    SearchBottomSheetBinding binding;
    InputMethodManager imm;
    List<EventModel> eventModelList, filteredList;
    SearchItemAdapter adapter;

    public SearchBottomSheet(@NonNull Context context, List<EventModel> eventModelList) {
        super(context);
        this.context = context;
        this.eventModelList = eventModelList;
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
            hideKeyboard();
            dismiss();
        });

        binding.searchEt.requestFocus();
        imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        setUpSearchBox();
        setUpRecyclerView();
    }

    void setUpRecyclerView() {
        adapter = new SearchItemAdapter(context, filteredList, eventModel -> {
            hideKeyboard();
            Intent intent = new Intent(context, EventDetailsActivity.class);
            intent.putExtra("id", eventModel.getId());
            intent.putExtra("title", eventModel.getTitle());
            context.startActivity(intent);
            dismiss();
        });
        binding.searchRv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        binding.searchRv.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        binding.searchRv.setAdapter(adapter);
    }

    private void setUpSearchBox() {
        filteredList = new ArrayList<>();
        binding.searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filteredList.clear();
                for (EventModel model : eventModelList){
                    if(model.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(model);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = Objects.requireNonNull(binding.searchEt.getText()).toString();
                if(searchText.isEmpty()){
                    filteredList.clear();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void hideKeyboard() {
        if (imm.isAcceptingText()) {
            imm.hideSoftInputFromWindow(binding.searchEt.getWindowToken(), 0);
        }
    }
}
