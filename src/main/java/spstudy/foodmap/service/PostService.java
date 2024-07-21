package spstudy.foodmap.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spstudy.foodmap.domain.Location;
import spstudy.foodmap.domain.Post;
import spstudy.foodmap.domain.Review;
import spstudy.foodmap.domain.User;
import spstudy.foodmap.dto.PostCreateRequest;
import spstudy.foodmap.repository.PostRepository;
import spstudy.foodmap.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void save(PostCreateRequest postCreateRequest) {
        User user = userRepository.findById(postCreateRequest.getUserId()).get();

        Review review = Review.builder()
                .rate(postCreateRequest.getRate())
                .comment(postCreateRequest.getComment())
                .build();

        Location locationo = Location.builder()
                .place(postCreateRequest.getPlace())
                .street(postCreateRequest.getStreet())
                .zipcode(postCreateRequest.getZipCode())
                .build();

        Post post = Post.builder()
                .review(review)
                .user(user)
                .location(locationo)

                .build();
        postRepository.save(post);
    }
}
