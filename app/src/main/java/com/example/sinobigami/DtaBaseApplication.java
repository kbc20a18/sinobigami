package com.example.sinobigami;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DtaBaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowWritesOnUiThread(true).build();
        Realm.setDefaultConfiguration(config);
    }
}
