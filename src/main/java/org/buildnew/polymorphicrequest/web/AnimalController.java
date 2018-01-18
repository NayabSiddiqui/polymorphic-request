package org.buildnew.polymorphicrequest.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "animals")
public class AnimalController {

    @RequestMapping(method = POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> register(@RequestBody Animal animal) {
        return ResponseEntity.ok(animal.sayHi());
    }
}
