package com.example.Student_Attendance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student_Attendance.entity.Attendance;
import com.example.Student_Attendance.services.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public String getAllAttendance(Model model) {
        model.addAttribute("attendanceList", attendanceService.getAllAttendance());
        return "attendance/list";
    }

    @GetMapping("/new")
    public String createAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "attendance/form";
    }

    @PostMapping
    public String createAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendance";
    }

    @GetMapping("/edit/{id}")
    public String editAttendanceForm(@PathVariable Long id, Model model) {
        model.addAttribute("attendance",attendanceService.getAttendanceById(id).orElseThrow());
        return "attendance/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return "redirect:/attendance";
    }
    
    @PostMapping("/update/{id}")
    public String updateAttendance(@PathVariable Long id,@ModelAttribute Attendance attendance){
        attendance.setAttendanceId(id);
        attendanceService.saveAttendance(attendance);
        return "redirect/:attendance";
    }
}
