package task.test.robert.testapp.core.model;

import java.io.Serializable;

/**
 * Created by Rob on 4/30/2018.
 */

public class Member implements Serializable {
    private Double id;
    private String username;
    private String avatar_url;
    private String avatar_big;
    private String avatar_medium;
    private String avatar_small;
    private String avatar_xsmall;
    private String fio;
    private String default_color;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAvatar_big() {
        return avatar_big;
    }

    public void setAvatar_big(String avatar_big) {
        this.avatar_big = avatar_big;
    }

    public String getAvatar_medium() {
        return avatar_medium;
    }

    public void setAvatar_medium(String avatar_medium) {
        this.avatar_medium = avatar_medium;
    }

    public String getAvatar_small() {
        return avatar_small;
    }

    public void setAvatar_small(String avatar_small) {
        this.avatar_small = avatar_small;
    }

    public String getAvatar_xsmall() {
        return avatar_xsmall;
    }

    public void setAvatar_xsmall(String avatar_xsmall) {
        this.avatar_xsmall = avatar_xsmall;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDefault_color() {
        return default_color;
    }

    public void setDefault_color(String default_color) {
        this.default_color = default_color;
    }
}
