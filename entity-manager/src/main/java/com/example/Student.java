package com.example;


import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private int id;

    @Column(name = "STUDENT_NAME", length = 10)
    private String name;

    @Column(name = "STUDENT_AGE")
    private String age;

    @Override
    public String toString() {
        return String.format("Student\nid:%d\nname:%s\nAge:%s", id, name, age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
