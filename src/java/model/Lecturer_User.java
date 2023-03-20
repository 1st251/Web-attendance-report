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
public class Lecturer_User {
    private int luid;
    private String username;
    private String password;
    ArrayList<Lecturer> lecturer=new ArrayList<>();

    public int getLuid() {
        return luid;
    }

    public void setLuid(int luid) {
        this.luid = luid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Lecturer> getLecturer() {
        return lecturer;
    }

    public void setLecturer(ArrayList<Lecturer> lecturer) {
        this.lecturer = lecturer;
    }
    
    
}
