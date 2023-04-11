package com.sapient.grooming.Model;

import com.sapient.grooming.Exception.BadInputException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FindJob {
    String tech;
    Integer exp;
    Double current_sal;

    public void takeInputTech(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.println("Enter the tech stack : ");
            tech = scn.nextLine();
            tech = tech.toUpperCase();
            String regex = "[a-zA-Z][a-zA-Z ]+";
            Pattern p = Pattern.compile(regex);
            if(tech.isEmpty()){
                throw new BadInputException("Tech stack cannot be empty");
            }
            else if(!tech.matches(regex)){
                throw new BadInputException("Use only alphabets");
            }
            if(!Tech.findTech(tech)){
                throw new BadInputException("There is no opening with "+tech);
            }
        }
        catch (BadInputException ex){
            System.out.println(ex.getMessage());
            takeInputTech();
        }
    }
    public void takeInputExp(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.println("Enter the exp : ");
            exp = scn.nextInt();
            if(exp < 0){
                throw new BadInputException("Experience should be greater or equal to zero");
            }
            if(exp > 50){
                throw new BadInputException("Experience should be less than 50 years");
            }
            if(Tech.findRoleByExp(exp) == null){
                throw new BadInputException("There is no opening with experience of "+ exp + " years");
            }
        }
        catch (BadInputException ex){
            System.out.println(ex.getMessage());
            takeInputExp();
        }catch (InputMismatchException e){
            System.out.println("Enter valid experience");
            takeInputExp();
        }
    }
    public void takeInputSalary(){
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Enter the current salary (in lpa) : ");
            current_sal = scn.nextDouble();
            if(current_sal < 0){
                throw new BadInputException("Salary cannot be less than zero");
            }
        }catch (BadInputException ex){
            System.out.println(ex.getMessage());
            takeInputSalary();
        }catch (InputMismatchException e){
            System.out.println("Enter valid salary");
            takeInputSalary();
        }

    }
    public void takeInput(){
        Scanner scn = new Scanner(System.in);
        takeInputTech();
        takeInputExp();
        takeInputSalary();
    }

    public Double expectedSalary(){
        return current_sal + current_sal*(Role.getIncrementByRole(Tech.findRoleByExpAndTech(exp,tech))*0.01);
    }

}
