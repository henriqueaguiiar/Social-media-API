package io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;






@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String text;
    private Instant date;
    private AuthorDTO author;
}
