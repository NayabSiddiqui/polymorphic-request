package org.buildnew.polymorphicrequest.web;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatTest {

    @Test
    public void shouldGreet(){
        Animal cat = new Cat("Maggie", "Ragdoll");

        assertThat(cat.sayHi()).isEqualTo("Meaow... I'm Maggie. I'm a cute Ragdoll");
    }
}
