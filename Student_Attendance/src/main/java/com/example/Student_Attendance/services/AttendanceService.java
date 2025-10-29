package com.example.Student_Attendance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student_Attendance.entity.Attendance;
import com.example.Student_Attendance.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    } 
    
    public Attendance saveAttendance(Long id, Attendance updatedAttendance){
        if(attendanceRepository.existsById(id)) {
            updatedAttendance.setAttendanceId(id);
            return attendanceRepository.save(UpdatedAttendance);
        }
        return null;
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}