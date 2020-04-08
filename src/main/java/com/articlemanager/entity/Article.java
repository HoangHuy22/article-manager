package com.articlemanager.entity;

public class Article {
    private int id;
    private String title;
    private String description;
    private String content;
    private String dayWrite;
    private int status;

    public Article() {
    }

    public Article(String title, String description, String content, String dayWrite, int status) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.dayWrite = dayWrite;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDayWrite() {
        return dayWrite;
    }

    public void setDayWrite(String dayWrite) {
        this.dayWrite = dayWrite;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInString() {
        if (this.status == 1) {
            return "Available";
        } else if (this.status == 0) {
            return "Not Available";
        } else if (this.status == 2) {
            return "Sold";
        } else if (this.status == -1) {
            return "Dead";
        } else {
            return "Invalid status";
        }
    }
}
