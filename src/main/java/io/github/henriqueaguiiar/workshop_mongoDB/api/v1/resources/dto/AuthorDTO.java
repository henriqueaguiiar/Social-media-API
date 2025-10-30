package io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;


    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
