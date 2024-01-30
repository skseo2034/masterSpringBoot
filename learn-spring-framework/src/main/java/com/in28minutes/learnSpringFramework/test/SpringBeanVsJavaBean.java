package com.in28minutes.learnspringframework.test;

import java.io.Serializable;
import java.net.SocketOption;

class Pojo {
    private String text;
    private int number;
    public String toString() {
        return text + ":" + number;
    }
}

class JavaBean implements Serializable { // EJB

    // 1: public no-arg constructor
    public JavaBean() {

    }
    private String text;

    public int getNumber() {
        return number;
    }

    // 2: setter getter
    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


public class SpringBeanVsJavaBean {
    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        System.out.println(pojo);
    }

}
