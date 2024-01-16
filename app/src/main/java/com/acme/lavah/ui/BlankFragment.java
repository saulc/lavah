package com.acme.lavah.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.acme.lavah.R;
import com.acme.lavah.databinding.FragmentBlankBinding;
import com.acme.lavah.databinding.FragmentHomeBinding;
import com.acme.lavah.ui.home.HomeViewModel;

public class BlankFragment extends Fragment {

    private BlankViewModel mViewModel;
    private FragmentBlankBinding binding;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        BlankViewModel BlankViewModel =
            new ViewModelProvider(this).get(BlankViewModel.class);

        binding = FragmentBlankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        inflater.inflate(R.layout.fragment_blank, container, false);

        final WebView web = binding.webview;
        BlankViewModel.getUrl().observe(getViewLifecycleOwner(), web::loadUrl);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BlankViewModel.class);
        // TODO: Use the ViewModel
    }

}