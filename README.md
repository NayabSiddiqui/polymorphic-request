## Polymorphic Request based on Json Properties

This app illustrates deserialization of a json request to appropriate `sub-typed`
POJO, based on properties.

Given, different type of animal request `POSTed` to the api hosted at `http://localhost:8081/animals`,
it returns the greetings based on type of animals

*Note*: Currently handles only `dog` and `cat` types.

---

### How to test

Well, all the relevant tests are already present in there :)

The decision on selection of which sub-type class to be dematerialized to, is made on the
property `type`. So `"type": dog` would serialize to `Dog` class, whereas `"type": cat`
would serialize to the respect `Cat` class.

- Say we give a dog type json request as follows
    ```json
    {
      "type": "dog",
      "name": "Dennis",
      "breed": "St. Bernard"
    }
    ```
    
    When sent a post request with above json, it greets the way a loving dog would :)

- Change the value of `"type"` key to `cat` and see how she reacts...