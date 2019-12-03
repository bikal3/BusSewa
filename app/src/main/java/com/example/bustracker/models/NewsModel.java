package com.example.bustracker.models;

import java.io.Serializable;

public class NewsModel implements Serializable {
    private String title,ndate,publication,description1,description2;
    private String id;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNdate() {
        return ndate;
    }

    public String getPublication() {
        return publication;
    }

    public String getDescription1() {
        return description1;
    }

    public String getDescription2() {
        return description2;
    }
}
