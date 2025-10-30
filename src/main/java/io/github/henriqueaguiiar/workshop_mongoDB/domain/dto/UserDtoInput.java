package io.github.henriqueaguiiar.workshop_mongoDB.domain.dto;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoInput implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    /**
     * @Author Henrique Aguiar
     * / Construtor that creates a UserDtoOutput from a User entity.
     * @param user The User entity from which to create the DTO.
     */

    public UserDtoInput(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDtoInput that = (UserDtoInput) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
