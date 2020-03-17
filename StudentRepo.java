
package com.student.rest;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepo extends CrudRepository<Student, Long>{
    
    @Query("SELECT s FROM Student s WHERE s.name LIKE :q OR s.matricNumber like :q OR s.course LIKE :q")
    List<Student> search(@Param("q") String q);
    
}
