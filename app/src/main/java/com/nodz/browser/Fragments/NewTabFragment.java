package com.nodz.browser.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nodz.browser.Activity.HomeScreen;
import com.nodz.browser.Activity.MainActivity;
import com.nodz.browser.R;
import com.nodz.browser.databinding.FragmentSearchBinding;

public class NewTabFragment extends Fragment {

    FragmentSearchBinding binding;
    Context context;

    public NewTabFragment() {
        // Required empty public constructor
    }

    public NewTabFragment(Context context) {
        this.context = context;
        // Required empty public constructor
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(getLayoutInflater());
        binding.searchBtnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                i.putExtra("queryFrag",binding.searchBoxFrag.getText().toString());
                i.putExtra("type",2);
            }
        });
        
        return inflater.inflate(R.layout.fragment_search, container,false);
    }
}



