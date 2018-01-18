package org.buildnew.polymorphicrequest.web;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DogTest {

    @Test
    public void shouldGreet(){
        Animal dog = new Dog("Dennis", "St. Bernard");

        assertThat(dog.sayHi()).isEqualTo("Bow wow... I'm Dennis. I'm a cute St. Bernard");
    }
}
