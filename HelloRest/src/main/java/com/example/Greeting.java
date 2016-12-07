package com.example;

public class Greeting {

    private final long id;
    protected String content;
    public int index;

    public Greeting(){
        this.id = 0;
        this.content = "";
    }

    public Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId(){ return id;}
    public String getContent(){return content;}

    public void setContent(String content) {
        this.content = content;
    }

}
