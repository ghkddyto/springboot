package me.yosae.dto;

import lombok.Getter;
import me.yosae.domain.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {
    private final long id;
    private final String title;
    private final String content;
    private LocalDateTime createdAt;
    public ArticleViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreateAt();
    }
}
