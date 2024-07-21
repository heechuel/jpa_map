package spstudy.foodmap.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    //굳이 review에 user가 포함되어야 하나? 어짜피 post에 종속적이지 않은가
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    private int rate;
    private String comment;

    public static Review createReview(Post post, int rate, String comment){
        Review review = new Review();
        review.setPost(post);
        review.setRate(rate);
        review.setComment(comment);

        return review;
    }
}
