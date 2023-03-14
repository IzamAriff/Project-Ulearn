package com.ulearn.main;

public abstract class Person {

    protected String name;
    protected String id; //it is imperative that student id is the index where the person is located
    protected int age;
    protected String ic;
    protected String department;
    protected String email;

    public Person(String name, String id, int age, String ic, String department, String email) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.ic = ic;
        this.department = department;
        this.email = email;
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
}
