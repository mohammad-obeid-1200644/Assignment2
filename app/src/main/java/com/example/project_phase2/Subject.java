package com.example.project_phase2;


public class Subject {
    private String name;
    private int imageID;

    public static final Subject[] subject ={
            new Subject("Math",R.drawable.math),
            new Subject("Other exercises",R.drawable.otherexc)

    };
    private Subject(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName(){return name;}
    public int getImageID(){return imageID;}

}

