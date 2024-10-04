package me.yosae.service;

import lombok.RequiredArgsConstructor;
import me.yosae.domain.Article;
import me.yosae.dto.AddArticleRequest;
import me.yosae.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

}
