package spstudy.foodmap.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spstudy.foodmap.domain.User;
import spstudy.foodmap.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user){
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void  validateDuplicateUser(User user){
        if(userRepository.findByName(user.getName()).isEmpty()){
            throw  new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUser() {return userRepository.findAll();}

    public User findOne(Long userId){return userRepository.findOne(userId);}
}
