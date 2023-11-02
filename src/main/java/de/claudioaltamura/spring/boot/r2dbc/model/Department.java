package de.claudioaltamura.spring.boot.r2dbc.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("department")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Persistable<UUID> {

    @Id
    @JsonProperty("uuid")
    @JsonAlias("id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private UUID id;

    @NotNull
    @Size(max = 64, message = "The property 'name' must be less than or equal to 64 characters.")
    private String name;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return true;
    }

}
