package com.iitbhu.spardha.activity.GalleryBackend;

import java.io.Serializable;

/**
 * Created by abhinav on 8/23/2017.
 */

public class imagecontainer implements Serializable {
    private String name;
    private String small, medium, large;
    private String timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public imagecontainer() {
    }

}
