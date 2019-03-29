package com.intellica.testtask.DB.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "ADDRESS")
@SequenceGenerator(name="USER_SEQUENCE_GENERATOR", sequenceName="USER_SEQUENCE", initialValue=3, allocationSize=10)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQUENCE_GENERATOR")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "line1 must not be null")
    @Length(max = 50, message = "Address line1 must be less than 50 characters")
    @Getter
    @Setter
    private String line1;


    @Length(max = 50, message = "Address line2 must be less than 50 characters")
    @Getter
    @Setter
    private String line2;


    @Length(max = 50, message = "town must be less than 50 characters")
    @Getter
    @Setter
    private String town;

    @Length(max = 50, message = "town name must be less than 50 characters")
    @Getter
    @Setter
    private String postcode;

//    @OneToOne(mappedBy = "address")
//    @Getter @Setter
//    private Task task;

}
