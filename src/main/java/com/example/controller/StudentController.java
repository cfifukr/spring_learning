package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        super();
        this.service = service;
    }
    @GetMapping("/")
    public String index(){
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("studentsList", service.getAllStudents());

        return "students";
    }

    @PostMapping("/students")
    public String saveStudent(Model model, @ModelAttribute("student") Student student){
        service.saveStudent(student);
        return "redirect:/students";
    }



    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @GetMapping("students/edit/{id}")
    public String editStudentForm(Model model, @PathVariable Long id){
        model.addAttribute("student", service.getStudentById(id));

        return "edit_student";
    }

    @PostMapping("students/edit/{id}")
    public String editStudent( @PathVariable Long id, @ModelAttribute("student") Student student){

        Student existingStudent = new Student();
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/delete/{id}")
    public String deleteStudent( @PathVariable Long id){
        service.deleteStudentById(id);
        return "redirect:/students";
    }





}
