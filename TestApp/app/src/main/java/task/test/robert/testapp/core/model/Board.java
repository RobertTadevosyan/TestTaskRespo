package task.test.robert.testapp.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rob on 4/30/2018.
 */

public class Board implements Serializable {
    private Double id;
    private String name;
    private Double team_id;
    private Boolean is_delete;
    private String created_at;
    private List<Member> members;
    private String description;
    private Double owner;
    private Double position;
    private Boolean is_archive;
    private Boolean is_multiuser;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Double team_id) {
        this.team_id = team_id;
    }

    public Boolean getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOwner() {
        return owner;
    }

    public void setOwner(Double owner) {
        this.owner = owner;
    }

    public Double getPosition() {
        return position;
    }

    public void setPosition(Double position) {
        this.position = position;
    }

    public Boolean getIs_archive() {
        return is_archive;
    }

    public void setIs_archive(Boolean is_archive) {
        this.is_archive = is_archive;
    }

    public Boolean getIs_multiuser() {
        return is_multiuser;
    }

    public void setIs_multiuser(Boolean is_multiuser) {
        this.is_multiuser = is_multiuser;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "name = " + name + "\n" +
                "team_id = " + team_id + "\n" +
                "created_at = " + created_at + "\n" +
                "owner = " + owner + "\n" +
                "position = " + id + "\n";
    }
}
