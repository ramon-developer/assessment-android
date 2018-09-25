package br.com.marbetramon.assessmentandroid.model;

import com.google.gson.annotations.SerializedName;

public class Tag {

    private String body;
    @SerializedName( "is_aswered" )
    private boolean isAnswered;
    @SerializedName( "title" )
    private String title;
    @SerializedName( "link" )
    private String link;
    @SerializedName( "tagged" )
    private String tagged;

    public Tag(String body, boolean isAnswered, String title, String link, String tag) {
        this.body = body;
        this.isAnswered = isAnswered;
        this.title = title;
        this.link = link;
        this.tagged = tagged;
    }

    @Override
    public String toString() {
        return body + "\n"  + "\n" + title + "\n" + link + "\n" + tagged + "\n";
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tagged;
    }

    public void setTag(String tag) {
        this.tagged = tag;
    }

}
