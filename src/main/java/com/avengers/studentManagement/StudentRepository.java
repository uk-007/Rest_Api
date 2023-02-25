package com.avengers.studentManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db = new HashMap<>();

    public ResponseEntity getStudent(int id){
        if(db.containsKey(id)){
            return new ResponseEntity(db.get(id), HttpStatus.FOUND);
        }
        Student s = new Student("n/a",0,0,"n/a");
        return new ResponseEntity(s,HttpStatus.NOT_FOUND);


    }

    public String addStudent(Student student){
        int id = student.getAdmnNo();
        db.put(id,student);
        return "Added succesfully";
    }

    public String deleteStudent(int id){
        if(!db.containsKey(id)){
            return "Invalid Id";
        }
        db.remove(id);
        return "Student removed successfully";
    }

    public String updateStudent(int id, int age){

        if(!db.containsKey(id)){
            return null;
        }
        db.get(id).setAge(20);
        return "Age updated succesfully";
    }
}
