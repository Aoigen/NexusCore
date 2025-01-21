package com.aoigen.nexuscore.model;

public class User {

    private int id;
    private String complete_name;
    private String username;
    private String email;
    private int tel;
    private String password;
    private boolean status;

    // Criaremos um construtor para criar um objeto com dados recebidos do HTML

    public User (int id, String complete_name, String email, int tel, String password, boolean Status) {
        this.id = id;
        this.complete_name = complete_name;
        this.username = username;
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.status = status;
    }


    // Getters & Setters

    // Isso é um "get"
    // Normalmente ele retorna alguma coisa armazenada em um setter
    public int getId() {
        return id;
    }

    // Isso é um set
    // Ele precisa retornar void, pois vai servir apenas para ter algo armazenado
    // Ele não retorna nada sozinho mas o get
    public void setId(int id) {
        this.id = id;
    }

    public String getCompleteName() {
        return complete_name;
    }

    public void setCompleteName(String complete_name) {
        this.complete_name = complete_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean Status() {
        return status;
    }

    public void Status(boolean status) {
        this.status = status;
    }


    

}
