package org.buildnew.polymorphicrequest.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat extends Animal {

    public Cat(@JsonProperty("name")  String name,
               @JsonProperty("breed") String breed) {
        super(name, breed);
    }

    @Override
    public String sayHi() {
        return "Meaow... I'm " + this.name + ". I'm a cute " + this.breed;
    }
}
