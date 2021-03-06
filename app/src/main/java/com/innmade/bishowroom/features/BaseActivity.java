package com.innmade.bishowroom.features;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.innmade.bishowroom.BiShowRoomApp;
import com.innmade.bishowroom.R;

import java.util.Locale;

import javinator9889.localemanager.application.BaseApplication;
import javinator9889.localemanager.utils.languagesupport.LanguagesSupport;

public class BaseActivity extends AppCompatActivity {
    BiShowRoomApp mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BiShowRoomApp) getApplicationContext();
        mApplication.setNetworkCallback(new NetworkCallback() {
            // Her class kendi isteğine göre override edecek
            @Override
            public void onAvailable(@NonNull Network network) {
                super.onAvailable(network);
            }

            @Override
            public void onLost(@NonNull Network network) {
                super.onLost(network);
                if (BiShowRoomApp.isActivityVisible())
                    Toast.makeText(mApplication, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
            }
        });
        setAppLanguage();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BiShowRoomApp.activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        BiShowRoomApp.activityPaused();
    }

    protected void setAppLanguage() {
        if (Locale.getDefault().getLanguage().equals("tr")) {
            BaseApplication.localeManager.setNewLocale(this, LanguagesSupport.Language.TURKISH);
        } else {
            BaseApplication.localeManager.setNewLocale(this, LanguagesSupport.Language.ENGLISH);
        }
    }
}
