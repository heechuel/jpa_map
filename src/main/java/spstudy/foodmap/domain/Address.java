package spstudy.foodmap.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {
    private String street;
    private String zipcode;

    protected Address(){
    }

    public Address(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }
}
