package com.example.securityDemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDateTime localDateTime =createdTime();
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private boolean enabled=true;
//    @Column(nullable = false)
//    private boolean accountNonExpired=true;
//    @Column(nullable = false)
//    private boolean credentialsNonExpired=true;
//    @Column(nullable = false)
//    private boolean accountNonLocked=true;


    public LocalDateTime  createdTime() {
        return LocalDateTime.now();
     }

}
