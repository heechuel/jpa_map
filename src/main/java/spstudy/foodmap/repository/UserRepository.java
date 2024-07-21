package spstudy.foodmap.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spstudy.foodmap.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOne(Long id);

    Optional<User> findByName(String name);


    //    private final EntityManager em;
//
//    public void save(User user) { em.persist(user);}
//
//    public User findOne(Long id){return em.find(User.class, id);}
//
//    public List<User> findAll(){
//        return em.createQuery("SELECT u FROM User u", User.class)
//                .getResultList();
//    }
//
//    public List<User> findByName(String name){
//        return em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
}
