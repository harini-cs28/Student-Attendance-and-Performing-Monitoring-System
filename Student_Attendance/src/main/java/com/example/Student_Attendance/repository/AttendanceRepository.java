package com.example.Student_Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student_Attendance.entity.Attendance;

@Repository
public interface AttendanceRepository  extends JpaRepository<Attendance, Long> {
    
}
