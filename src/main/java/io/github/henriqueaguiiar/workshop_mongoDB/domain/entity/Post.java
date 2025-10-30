package io.github.henriqueaguiiar.workshop_mongoDB.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
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
    private User user;


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
