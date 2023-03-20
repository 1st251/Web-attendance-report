/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Lecturer {
    private int lid;
    private String lname;
    private ArrayList<Group> group = new ArrayList<>();
    private ArrayList<Session> session = new ArrayList<>();
    Lecturer_User user;

    public Lecturer_User getUser() {
        return user;
    }

    public void setUser(Lecturer_User user) {
        this.user = user;
    }

    public ArrayList<Session> getSession() {
        return session;
    }

    public void setSession(ArrayList<Session> session) {
        this.session = session;
    }

    
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public ArrayList<Group> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Group> group) {
        this.group = group;
    }
    
}
