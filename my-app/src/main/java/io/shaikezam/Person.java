package io.shaikezam;


import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class Person {
    private int id;
    private String name;

    public String lol() {
        return "lol";
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Person) && (id == ((Person) obj).getId()) && (name.equals(((Person) obj).getName()));
    }
}
