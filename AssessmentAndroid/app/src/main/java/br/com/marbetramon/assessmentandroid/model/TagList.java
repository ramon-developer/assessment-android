package br.com.marbetramon.assessmentandroid.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class TagList {

    @SerializedName("items")
    private ArrayList<Tag> tagsList;

    public TagList(ArrayList<Tag> tagsList) {
        this.tagsList = tagsList;
    }

    public ArrayList<Tag> getTagArrayList() {
        return tagsList;
    }

    public void setTagArrayList(ArrayList<Tag> tagsList) {
        this.tagsList = tagsList;
    }

}
