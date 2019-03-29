package com.intellica.testtask.DB.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "TASK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", unique = true)
    @Getter
    @Setter
    private UUID id;

    @NotNull(message = "title must not be null")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Title title;

    @NotNull(message = "first name must not be null")
    @Length(max = 50, message = "fist name must be less than 50 characters")
    @Getter
    @Setter
    private String firstName;

    @NotNull(message = "last name must not be null")
    @Length(max = 50, message = "last name must be less than 50 characters")
    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private LocalDateTime date;

    //N+1 problem here, but its ok at our size of data
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Valid
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Getter @Setter
    private Address address;
}
