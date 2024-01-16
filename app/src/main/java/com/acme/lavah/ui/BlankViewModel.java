package com.acme.lavah.ui;

import android.webkit.WebView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlankViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> url;

    public BlankViewModel() {
        url = new MutableLiveData<>();
        url.setValue("https://www.google.com/");
    }
    public LiveData<String> getUrl() {
        return url;
    }
}