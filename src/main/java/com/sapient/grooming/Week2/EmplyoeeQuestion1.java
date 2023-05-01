package com.sapient.grooming.Week2;

import com.sapient.grooming.Exception.DataNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Emplyoee{
    private String name;
    private LocalDate joiningDate;
    private String employementType;
    private String role;
    private Status status;
}

public class EmplyoeeQuestion1 {
    public static Map<String,Emplyoee> empData = new HashMap<>();

    public static String addEmp(Emplyoee em,String empId){
        empData.put(empId,em);
        return em.getName() + " is added";
    }
    public static String deleteEmp(String empId){
        try {
            if(!empData.containsKey(empId)){
                throw new DataNotFoundException("Employee ID not found");
            }
            empData.remove(empId);
            return "Employee deleted successfully";
        }catch (DataNotFoundException ex){
            return ex.getMessage();
        }
    }
    public static String updateEmployementType(String empId,String employementType){
        try {
            if(!empData.containsKey(empId)){
                throw new DataNotFoundException("Employee ID not found");
            }
            Emplyoee emp = empData.get(empId);
            emp.setEmployementType(employementType);
            return "Employment Type updated successfully";
        }catch (DataNotFoundException ex){
            return ex.getMessage();
        }
    }
    public static String updateRole(String empId,String role){
        try {
            if(!empData.containsKey(empId)){
                throw new DataNotFoundException("Employee ID not found");
            }
            Emplyoee emp = empData.get(empId);
            emp.setRole(role);
            return "Role updated successfully";
        }catch (DataNotFoundException ex){
            return ex.getMessage();
        }
    }

    public static Map<String, Emplyoee> sortByValue(Map<String, Emplyoee> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Emplyoee> > list = new LinkedList<Map.Entry<String, Emplyoee> >(hm.entrySet());
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Emplyoee> >() {
            public int compare(Map.Entry<String, Emplyoee> o1, Map.Entry<String, Emplyoee> o2)
            {
                return (o1.getValue().getJoiningDate()).compareTo(o2.getValue().getJoiningDate());
            }
        });
        // put data from sorted list to hashmap
        Map<String, Emplyoee> temp = new HashMap<String, Emplyoee>();
        for (Map.Entry<String, Emplyoee> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static List<Emplyoee> getSeniorMostEmplyoees(){
        sortByValue(empData);
        List<Emplyoee> emplyoeeList = new ArrayList<>();
        Map.Entry<String,Emplyoee> entry = empData.entrySet().iterator().next();
        Emplyoee firstSortedEmp = entry.getValue();
        for(Emplyoee emp : empData.values()){
            if(emp.getJoiningDate().equals(firstSortedEmp.getJoiningDate())){
                emplyoeeList.add(emp);
            }
        }
        return emplyoeeList;
    }

    public static void getAllEmplyoeesOfStatus(Status status){
        try{
            for(Emplyoee emp : empData.values()){
                if(emp.getStatus().equals(status)){
                    System.out.println(emp);
                }else {
                    throw new DataNotFoundException("Status not found");
                }
            }
        }catch (DataNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void printAll(){
        try {
            if (empData.size() == 0) {
                throw new DataNotFoundException("No data is present");
            }
            System.out.println(empData);
        }catch (DataNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void takeInput(){
        System.out.println("Welcome, please enter input ");
        System.out.println("Enter 1 for adding employee : ");
        System.out.println("Enter 2 for deleting employee : ");
        System.out.println("Enter 3 for updating employement type : ");
        System.out.println("Enter 4 for updating role : ");
        System.out.println("Enter 5 for getting most experience employees : ");
        System.out.println("Enter 6 for print all data : ");
        System.out.println("Enter 7 for start again : ");
        System.out.println("Enter 8 for exit : ");
        Scanner scn = new Scanner(System.in);
        int casenum = scn.nextInt();
        switch (casenum) {
            case 1 -> {
                System.out.print("Enter empId : ");
                String empId = scn.next();
                System.out.print("Enter name : ");
                String name = scn.next();
                System.out.print("Enter emplyoeement type : ");
                String empType = scn.next();
                System.out.print("Enter role : ");
                String role = scn.next();
                System.out.print("Enter status : ");
                String status = scn.next();
                LocalDate date = LocalDate.now();
                Emplyoee emp = new Emplyoee(name, date, empType, role, Status.ACTIVE);
                System.out.println(addEmp(emp, empId));
                takeInput();
                break;
            }
            case 2 -> {
                System.out.println("Enter the empId for delete :");
                String empId = scn.nextLine();
                System.out.println(deleteEmp(empId));
                takeInput();
                break;
            }
            case 3 -> {
                System.out.println("Enter the empId for update employment type :");
                String empId = scn.nextLine();
                System.out.println("Enter the employment type for update :");
                String empType = scn.nextLine();
                System.out.println(updateEmployementType(empId, empType));
                takeInput();
                break;
            }
            case 4 -> {
                System.out.println("Enter the empId for update employment type :");
                String empId = scn.nextLine();
                System.out.println("Enter the role for update :");
                String role = scn.nextLine();
                System.out.println(updateRole(empId, role));
                takeInput();
                break;
            }
            case 5 -> {
                System.out.println(getSeniorMostEmplyoees());
                takeInput();
                break;
            }
            case 6 -> {
                printAll();
                takeInput();
                break;
            }
            case 7 -> {
                takeInput();
                break;
            }
            case 8 -> {
                break;
            }
            default -> {
                System.out.println("Please choose valid input");
                takeInput();
                break;
            }
        }
    }
    public static void main(String[] args) {
        takeInput();
    }
}
