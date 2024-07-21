package spstudy.foodmap.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spstudy.foodmap.domain.Post;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private  final EntityManager em;

    public void save(Post post){em.persist(post);}

    public Post findOne(Long id){return em.find(Post.class, id);}


}
