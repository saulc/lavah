package com.acme.lavah.ui.home;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.acme.lavah.databinding.FragmentHomeBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private int i = 0;
    private ArrayList<String> images = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView imageV = binding.imageView1;
        ArrayList<String> images = new ArrayList<>();
        images.add("im.jpg");
        images.add("iss.jpg");
        images.add("vlabw.jpg");
        images.add("web.jpg");
        images.add("li.jpg");
        images.add("cl.jpg");
        images.add("ff.jpg");
        images.add("ap.jpg");
        images.add("m166.jpg");
        images.add("fuck.jpg");

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

                    d.setAlpha(100);
                    imageV.getBackground().setAlpha(100);
                    int transitionTime = 1500, tt = 333;
                    Drawable[] layers = { imageV.getDrawable() , d };
                    TransitionDrawable transition = new TransitionDrawable( layers );
                    transition.setCrossFadeEnabled(true);
                    transition.setAlpha(150);
                    imageV.setImageDrawable(transition);
                    transition.startTransition(transitionTime);

                    // set image to ImageView
//                    imageV.setImageDrawable(d);
                    ims.close();
                }
                catch(IOException ex)
                {

                }
            }
        });
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}