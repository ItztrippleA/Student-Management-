
package com.student.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("save")
    public Student save(@RequestBody Student student) {
        student = studentRepo.save(student);
        return student;
    }

    @PutMapping("update")
    public Student update(@RequestBody Student student) {
        if (studentRepo.existsById(student.getId())) {
            student = studentRepo.save(student);
            return student;
        }
        return null;
    }
    
    @DeleteMapping("delete")
    public String update(@RequestParam Long id) {
        if (id != null && studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "Deleted";
        }
        return null;
    }
    
    @GetMapping("{id}")
    public Student get(@PathVariable("id") Long id) {
        if (id != null && studentRepo.existsById(id)) {
            return studentRepo.findById(id).get();
        }
        return null;
    }
    
    @GetMapping("search")
    public List<Student> search(@RequestParam String q) {
        q = "%" + q + "%";
        return studentRepo.search(q);
    }

    @GetMapping("all")
    public List<Student> getAll() {
        return (List<Student>) studentRepo.findAll();
    }
}
