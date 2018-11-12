package com.gmail.michzuerch.locateipaddress.backend.mongodb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Document(collection = "uzer")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @NotEmpty
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(min = 4, max = 255)
    private String passwordHash;

    @NotBlank
    @Size(max = 255)
    private String firstName;

    @NotBlank
    @Size(max = 255)
    private String lastName;

    @NotBlank
    @Size(max = 255)
    private String role;

    private boolean locked = false;
}
