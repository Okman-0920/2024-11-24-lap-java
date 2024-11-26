package com.ll;

public class WiseSaying {
    private final int id;
    private String author;
    private String content;

    WiseSaying (int id, String content, String author) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String setAuthor(String author) {
        return this.author;
    }

    public String setContent(String content) {
        return this.author;
    }
}
