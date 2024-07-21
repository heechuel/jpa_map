package spstudy.foodmap.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private Long id;

    @OneToOne(mappedBy = "location", fetch = LAZY)
    private Post post;

    private String place;

    private String street;

    private String zipcode;

    public void update(Location location){
        this.place = location.place;
        this.street = location.street;
        this.zipcode = location.zipcode;
    }

    public Location() {

    }
//    @Enumerated(EnumType.STRING)
//    private Place place;

}
