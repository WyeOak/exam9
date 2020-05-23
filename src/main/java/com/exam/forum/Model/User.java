package com.exam.forum.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private String firstName;

    @Column(length = 128)
    private String lastName;

    @Column(length = 40)
    private String username;

    @Column(length = 128)
    private String password;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @Column(length = 30)
    @Builder.Default
    private String role = "USER";
}
