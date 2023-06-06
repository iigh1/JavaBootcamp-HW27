package com.example.springsecurityhw27.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title is required")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "body is required")
    @Size(min = 10, max = 200, message = "body must between 10 to 200")
    @Column(columnDefinition = "varchar(200) not null")
    private String body;




    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private MyUser myUser;
}
