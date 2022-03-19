package com.innmade.bishowroom;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import javinator9889.localemanager.application.BaseApplication;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BiShowRoomApp extends BaseApplication {

    private static boolean activityVisible;

    //Network Manager
    static ConnectivityManager.NetworkCallback networkCallback;
    static ConnectivityManager connectivityManager;
    static NetworkRequest networkRequest;

    public void setNetworkCallback(ConnectivityManager.NetworkCallback networkCallback) {
        BiShowRoomApp.networkCallback = networkCallback;
        connectivityManager.requestNetwork(networkRequest, BiShowRoomApp.networkCallback);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        networkRequest = new NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .build();
        networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                super.onAvailable(network);
            }

            @Override
            public void onLost(@NonNull Network network) {
                super.onLost(network);
            }


        };
        connectivityManager = getSystemService(ConnectivityManager.class);
        connectivityManager.requestNetwork(networkRequest, networkCallback,5000);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    @Override
    @Nullable
    protected SharedPreferences getCustomSharedPreferences(@NonNull Context base) {
        // If you are planning to store the user language in a custom shared preferences, create
        // and initialize them here.
        // If not, you can safely return "null"
        // OR
        return null;
    }
}
