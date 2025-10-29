package com.example.Student_Attendance.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @ManyToOne
    private  User user;

    private Long subjectId;

    private LocalDate attendanceDate;

    private String status;

    private String remarks;
    
}
