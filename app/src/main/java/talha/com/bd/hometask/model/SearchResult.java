package talha.com.bd.hometask.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult implements Serializable
{
    @SerializedName("id")
    private String id;

    @SerializedName("User")
    private String user;

    @SerializedName("name")
    private String name;

    @SerializedName("who")
    private String who;

    @SerializedName("image")
    private String image;

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getWho() {
        return who;
    }

    public String getImage() {
        return image;
    }
}
