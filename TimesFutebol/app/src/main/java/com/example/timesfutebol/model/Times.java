package com.example.timesfutebol.model;

import java.io.Serializable;

public class Times implements Serializable {

    private  int img;
    private  String name;
    private String owner;
    private  String titulo;


    public Times(){

    }

    public Times(int img, String name, String owner, String titulo){
        this.img = img;
        this.name = name;
        this.owner = owner;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}

