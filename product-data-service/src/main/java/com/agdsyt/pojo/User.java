package com.agdsyt.pojo;

/**
 * 用户实体类
 */
public class User {
    private Long id;
    private String name;
    private String passWord;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User() {

    }
    public User(Long id, String name, String passWord) {
        super();
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }
}
