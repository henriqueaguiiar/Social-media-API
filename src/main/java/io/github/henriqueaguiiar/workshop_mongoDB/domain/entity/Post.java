package io.github.henriqueaguiiar.workshop_mongoDB.domain.entity;

import io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto.AuthorDTO;
import io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto.CommentDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "posts")
public class Post implements Serializable {
    private static final long serilVersionUID = 1L;

    @Id
    private String id;
    private Instant date;
    private String title;
    private String body;
    private AuthorDTO autor;
    @Setter(AccessLevel.NONE)
    private List<CommentDto> comments = new ArrayList<>();


    public Post(String id, Instant date, String title, String body, AuthorDTO autor) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
