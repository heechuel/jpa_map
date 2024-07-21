package spstudy.foodmap.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spstudy.foodmap.dto.PostCreateRequest;
import spstudy.foodmap.service.PostService;


@RequiredArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping("v1/api/posts")
    public ResponseEntity savePost(@RequestBody PostCreateRequest postCreateRequest){
        postService.save(postCreateRequest);
        return ResponseEntity.ok("Success");
    }
}


//@RequestBody == json 형식으로 보내주는 것 이때 dto 에 정의된 순서로 json 파일이 작성 되야함
