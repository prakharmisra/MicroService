package org.microservice.userservice.teststream;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class person3 {

    public String name;
    public  int age ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person3 person3 = (person3) o;
        return age == person3.age && Objects.equals(name, person3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
