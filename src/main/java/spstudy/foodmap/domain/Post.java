package spstudy.foodmap.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDateTime reviewDate;

    //생성 메서드
//    public static Post createPost(User user, Location location, Review review){
//        Post post = new Post();
//        post.setUser(user);
//        post.setLocation(location);
//        post.setReview(review);
//        post.setReviewDate(LocalDateTime.now());
//        return post;
//    }
}
