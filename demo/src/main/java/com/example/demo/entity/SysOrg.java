package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sys_org")
public class SysOrg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_no", nullable = false)
    private String orgNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "org_type", nullable = false)
    private OrgType orgType;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private SysOrg parentOrg;

    @Column(name = "path")
    private String path;

    @Column(name = "level")
    private Integer level;

    // Getters and Setters
}
