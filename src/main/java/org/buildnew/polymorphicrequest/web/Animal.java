package org.buildnew.polymorphicrequest.web;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = Cat.class, name = "cat"),
        @Type(value = Dog.class, name = "dog")
})
public abstract class Animal {
    public String name;
    public String breed;


    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    abstract String sayHi();
}
