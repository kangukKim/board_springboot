package uk.board.dto;

import uk.board.domain.entity.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String writer;

    public PostsResponseDto (Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
    }
}