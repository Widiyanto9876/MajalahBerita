package com.widiyanto.user.majalahberita.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeritaArtikelData {

    @SerializedName("source")
    @Expose
    SourceClass sourceClass;
    @SerializedName("author")
    @Expose
    String author;
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("url")
    @Expose
    String url;
    @SerializedName("urlToImage")
    @Expose
    String urlImage;
    @SerializedName("publishedAt")
    @Expose
    String publishedAt;
    @SerializedName("content")
    @Expose
    String content;


    public SourceClass getSourceClass() {
        return sourceClass;
    }

    public void setSourceClass(SourceClass sourceClass) {
        this.sourceClass = sourceClass;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private class SourceClass {
        @SerializedName("id")
        @Expose
        String id;
        @SerializedName("name")
        @Expose
        String name;

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


}
