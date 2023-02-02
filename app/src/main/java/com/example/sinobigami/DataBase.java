package com.example.sinobigami;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataBase extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private String url;
    private int type;
    private int ryuha;
    private String ryuhaText;
    private String ryugi;
    private String kyuteki;
    private int kaikyu;
    private int kouseki;
    private int age;
    private int seibetu;
    private String job;
    private String sinnen;
    private String setei;
    private int tokugi;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRyuha() {
        return ryuha;
    }

    public void setRyuha(int ryuha) {
        this.ryuha = ryuha;
    }

    public String getRyuhaText() {
        return ryuhaText;
    }

    public void setRyuhaText(String ryuhaText) {
        this.ryuhaText = ryuhaText;
    }

    public String getRyugi() {
        return ryugi;
    }

    public void setRyugi(String ryugi) {
        this.ryugi = ryugi;
    }

    public String getKyuteki() {
        return kyuteki;
    }

    public void setKyuteki(String kyuteki) {
        this.kyuteki = kyuteki;
    }

    public int getKaikyu() {
        return kaikyu;
    }

    public void setKaikyu(int kaikyu) {
        this.kaikyu = kaikyu;
    }

    public int getKouseki() {
        return kouseki;
    }

    public void setKouseki(int kouseki) {
        this.kouseki = kouseki;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeibetu() {
        return seibetu;
    }

    public void setSeibetu(int seibetu) {
        this.seibetu = seibetu;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSinnen() {
        return sinnen;
    }

    public void setSinnen(String sinnen) {
        this.sinnen = sinnen;
    }

    public String getSetei() {
        return setei;
    }

    public void setSetei(String setei) {
        this.setei = setei;
    }

    public int getTokugi() {
        return tokugi;
    }

    public void setTokugi(int tokugi) {
        this.tokugi = tokugi;
    }
}
