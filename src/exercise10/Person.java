/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import java.io.Serializable;

/**
 *
 * @author e1500941
 */
public class Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name, nickname, tel;

    public Person() {
    }

    public Person(String name, String nickname, String tel) {
        this.name = name;
        this.nickname = nickname;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "name=" + name + ", nickname=" + nickname + ", tel=" + tel;
    }
    
    
}
