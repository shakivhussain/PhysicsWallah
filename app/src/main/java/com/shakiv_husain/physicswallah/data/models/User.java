
package com.shakiv_husain.physicswallah.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subjects")
    @Expose
    private List<String> subjects = null;
    @SerializedName("qualification")
    @Expose
    private List<String> qualification = null;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<String> getQualification() {
        return qualification;
    }

    public String getProfileImage() {
        return profileImage;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("subjects");
        sb.append('=');
        sb.append(((this.subjects == null) ? "<null>" : this.subjects));
        sb.append(',');
        sb.append("qualification");
        sb.append('=');
        sb.append(((this.qualification == null) ? "<null>" : this.qualification));
        sb.append(',');
        sb.append("profileImage");
        sb.append('=');
        sb.append(((this.profileImage == null) ? "<null>" : this.profileImage));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
