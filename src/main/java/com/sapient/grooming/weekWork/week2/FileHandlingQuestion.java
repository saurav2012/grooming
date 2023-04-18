package com.sapient.grooming.weekWork.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Data
class EmplyoeeFile{
    private String empId;
    private String name;
    private LocalDate joiningDate;
    private String employementType;
    private String role;
    private String domain;
}

class FileHandlingQuestion {
    static File obj;
    public static void createFile(String fileName){
        try {
            obj = new File(fileName.concat(".txt"));
            if (obj.createNewFile()) {
                System.out.println("File created: "+ obj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String input){
        try{
            FileWriter fwrite = new FileWriter(obj.getAbsolutePath());
            fwrite.write(input);
            fwrite.close();
            System.out.println("Content added successfully to file..");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    public static void ReadFromFile(){
        try {
            File file = new File(obj.getAbsolutePath());
            Scanner dataReader = new Scanner(file);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        }catch (FileNotFoundException ex){
            System.out.println("Unexcpected error occurred!");
            ex.printStackTrace();
        }
    }

    public static void DeleteFile(){
        File file = new File(obj.getAbsolutePath());
        if (file.delete()) {
            System.out.println(file.getName()+ " file is deleted successfully.");
        } else {
            System.out.println("Unexpected error found in deletion of the file.");
        }
    }

    public static void main(String[] args) {
        createFile("file1");
        EmplyoeeFile emp = new EmplyoeeFile("1001","Saurav", LocalDate.now(),"developer","manager","Backend");
        EmplyoeeFile emp1 = new EmplyoeeFile("1002","Gaurav", LocalDate.now(),"QA","ASDE","Computer");
        EmplyoeeFile emp2 = new EmplyoeeFile("1003","Bhaurav", LocalDate.now(),"tester","Trainee","OS");
        WriteToFile(emp.getEmpId()+";"+emp.getName()+";"+emp.getJoiningDate()+";"+emp.getEmployementType()+";"+emp.getRole()+";"+emp.getDomain());
        WriteToFile(emp1.getEmpId()+";"+emp1.getName()+";"+emp1.getJoiningDate()+";"+emp1.getEmployementType()+";"+emp1.getRole()+";"+emp1.getDomain());
        WriteToFile(emp2.getEmpId()+";"+emp2.getName()+";"+emp2.getJoiningDate()+";"+emp2.getEmployementType()+";"+emp2.getRole()+";"+emp2.getDomain());
        ReadFromFile();
    }
}
