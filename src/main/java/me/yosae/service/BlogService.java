package me.yosae.service;

import lombok.RequiredArgsConstructor;
import me.yosae.domain.Article;
import me.yosae.dto.AddArticleRequest;
import me.yosae.dto.UpdateArticleRequest;
import me.yosae.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 모두 불러오기
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    //블로그 글 불러오기
    public Article findById(Long id){ return blogRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not foubd: " + id));}

    //블로그 글 삭제하기
    public void deleteById(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }


}
