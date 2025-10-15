package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false)
    private SysOrg org;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "password_algo", nullable = false)
    private PasswordAlgo passwordAlgo;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    // Getters and Setters
}
