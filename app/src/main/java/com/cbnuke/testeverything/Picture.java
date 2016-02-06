package com.cbnuke.testeverything;

/**
 * Created by Amnart on 5/2/2559.
 */
public class Picture {

    private String id;
    private String name;

    public Picture(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
