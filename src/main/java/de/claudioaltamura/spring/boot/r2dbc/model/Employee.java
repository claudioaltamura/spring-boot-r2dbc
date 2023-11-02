package de.claudioaltamura.spring.boot.r2dbc.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("employee")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Persistable<UUID> {

    @Id
    @JsonProperty("uuid")
    @JsonAlias("id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private UUID id;

    @NotNull
    @Size(max = 64, message = "The property 'firstName' must be less than or equal to 64 characters.")
    private String firstName;

    @NotNull
    @Size(max = 64, message = "The property 'lastName' must be less than or equal to 64 characters.")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotNull
    private UUID department;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return true;
    }

}
