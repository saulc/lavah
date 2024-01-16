package com.acme.lavah.ui.dashboard;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.acme.lavah.databinding.FragmentDashboardBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private int i = 0;
    private ArrayList<String> images = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView imageV = binding.imageView1;
        ArrayList<String> images = new ArrayList<>();
        images.add("isss.jpg");
        images.add("laa.jpg");
        images.add("laaa.jpg");
        images.add("mm.jpg");
        images.add("mmm.jpg");
        images.add("fuckpop.jpg");

        imageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {

                    if(++i >= images.size()) i = 0;
                    // get input stream
                    InputStream ims = getResources().getAssets().open(images.get(i));
                    // load image as Drawable
                    Drawable d = Drawable.createFromStream(ims, null);
                    // set image to ImageView
                    imageV.setImageDrawable(d);
                    ims.close();
                }
                catch(IOException ex)
                {

                }
            }
        });

        try
        {
            // get input stream
            InputStream ims = getResources().getAssets().open("isss.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageV.setImageDrawable(d);
            ims.close();
        }
        catch(IOException ex)
        {

        }

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}