/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author mmsalemi
 */
public class Vaccine {
    public int id;    
    String name;
    int age;
    String description;
    String effetnegatif;
    float price;

    public Vaccine() {
    }

    public Vaccine(int id, String name, int age, String description, String effetnegatif, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.effetnegatif = effetnegatif;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public String getEffetnegatif() {
        return effetnegatif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEffetnegatif(String effetnegatif) {
        this.effetnegatif = effetnegatif;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
    
    
}
