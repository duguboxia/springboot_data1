package com.example.wu.pojo;

public class Paper {
    private int id;
    private String name;
    private int number;
    private String detail;

    public Paper() {
    }

    public Paper(int id, String name, int number, String detail) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                '}';
    }
}
