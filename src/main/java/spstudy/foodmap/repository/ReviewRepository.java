package spstudy.foodmap.repository;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spstudy.foodmap.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;

    public void save(Review review){
        if(review.getId() == null){
            em.persist(review);
        }else{
            em.merge(review);
        }
    }

    public Review findOne(Long id ){return em.find(Review.class, id);}

    public List<Review> findAll(){
        return em.createQuery("SELECT r FROM Review r", Review.class)
                .getResultList();
    }

}
