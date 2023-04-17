package com.sapient.grooming.weekWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Emplyoee{
    private int emplyoeeId; // index of linkedList
    private String emplyoeeName;
    private LocalDate joiningDate;
    private String employementType;
    private String role;
    private String status;
}

public class EmplyoeeQuestion1 {
    static List<Emplyoee> emplyoeeList = new ArrayList<>();

    public String addEmp(Emplyoee em){
        emplyoeeList.add(em);
        return em.getEmplyoeeName() + " added";
    }
    public String deleteEmp(int empId){
        emplyoeeList.remove(empId);
        return "deleted successfully";
    }
//    public String updateEmpType(int empId){
//        Emplyoee em
//    }


    public static void main(String[] args) {
        Emplyoee emp1 = new Emplyoee(0,"test",LocalDate.now(),"Full Time","Developer","Active");
    }
}
