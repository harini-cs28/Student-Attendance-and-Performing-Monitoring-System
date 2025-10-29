package com.example.Student_Attendance.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    
    private String name;

    private String email;

    private String role;

    private String department;

    @CreationTimestamp
    @Column(name = "join_date", updatable = false)
    private LocalDateTime joinDate;
}
