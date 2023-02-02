package com.example.sinobigami;

import androidx.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmObject;

public class DataBaseSave {
    public void save(final String name,final String url,final int type,final int ryuha,final String ryuhaText,
                     final String ryugi,final String kyuteki,final int kaikyu,final int kouseki,final int age,
                     final int seibetu,final String job,final String sinnen,final String setei,final int tokugi){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(@NonNull Realm bgRealm){
            DataBase dataBase = bgRealm.createObject(DataBase.class);
            Number id = bgRealm.where(DataBase.class).max("id");
                assert id != null;
                Long nextId = id.longValue() + 1L;
            dataBase.setId(nextId);
            dataBase.setName(name);
            dataBase.setUrl(url);
            dataBase.setType(type);
            dataBase.setRyuha(ryuha);
            dataBase.setRyuhaText(ryuhaText);
            dataBase.setRyugi(ryugi);
            dataBase.setKyuteki(kyuteki);
            dataBase.setKaikyu(kaikyu);
            dataBase.setKouseki(kouseki);
            dataBase.setAge(age);
            dataBase.setSeibetu(seibetu);
            dataBase.setJob(job);
            dataBase.setSinnen(sinnen);
            dataBase.setSetei(setei);
            dataBase.setTokugi(tokugi);

            }
        });

    }
}
