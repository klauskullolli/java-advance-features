package com.sda.java.advance.io;

import java.io.Serializable;

public class Alternative implements Serializable {
    private int id;
    private  String description;

    public Alternative() {
    }

    public Alternative(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        return id == ((Alternative)obj).getId();
    }
}
