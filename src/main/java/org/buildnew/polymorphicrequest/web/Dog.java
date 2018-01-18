package org.buildnew.polymorphicrequest.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dog extends Animal {

    @JsonCreator
    public Dog(@JsonProperty("name") String name,
               @JsonProperty("breed")String breed) {
        super(name, breed);
    }

    @Override
    public String sayHi() {
        return "Bow wow... I'm " + this.name + ". I'm a cute " + this.breed;
    }
}
