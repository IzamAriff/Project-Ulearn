package com.ulearn.Main;

public class User {

    protected String name;
    protected String id; //it is imperative that student id is the index where the person is located
    protected int age;
    protected String ic;
    protected String department;
    protected String email;
    protected String password;
    private int[] uniqueId;
    private int nextId;

    public User(String name, String id, int age, String ic, String department, String email, String password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.ic = ic;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) { //constructor for log in
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String id, int age, String ic, String department) { // construct for register
        this.id = id;
        this.age = age;
        this.ic = ic;
        this.department = department;
    }

    public User() {
        uniqueId = new int[100]; // or any other initial capacity
        nextId = 0;
    }

    public User(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUniqueId() {
        if (nextId >= uniqueId.length) {
            // array is full, expand it
            int[] newUniqueId = new int[uniqueId.length * 2];
            System.arraycopy(uniqueId, 0, newUniqueId, 0, uniqueId.length);
            uniqueId = newUniqueId;
        }
        return uniqueId[nextId++];
    }
}
