package com.sapient.grooming.Model;

import com.sapient.grooming.Exception.BadInputException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.*;

import com.sapient.grooming.Utils.DateValidator;
import com.sapient.grooming.Utils.DateValidatorUsingDateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.datetime.DateFormatter;

import java.util.Scanner;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenerateUsername {
    String name;
    String dob;
    String adharNum;
    String[] nameArray;
    List<String> errors = new ArrayList<>();

    public void takeInputName(){
        Scanner scn = new Scanner(System.in);
        // name
        try{
            System.out.print("Enter name : ");
            name = scn.nextLine();
            nameArray = name.split(" ");
            String regex = "[a-zA-Z][a-zA-Z ]+";
            Pattern p = Pattern.compile(regex);
            if(name.isEmpty()){
                throw new BadInputException("Name cannot be empty");
            }
            else if(!name.matches(regex)){
                throw new BadInputException("Use only alphabets");
            }
            else if(nameArray[0].length() < 3 ){
                throw new BadInputException("First name cannot be less than 3 character");
            }
        }
        catch (BadInputException ex){
            errors.add(ex.getMessage());
            System.out.println(ex.getMessage());
            takeInputName();
        }
    }
    public void takeInputDob(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.print("Enter dob (dd-mm-yyyy) : ");
            dob = scn.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu", Locale.US)
                    .withResolverStyle(ResolverStyle.STRICT);
            DateValidator validator = new DateValidatorUsingDateTimeFormatter(dateFormatter);
            if(!validator.isValid(dob)){
                throw new BadInputException("Enter valid date");
            }
            if(dob.isEmpty()){
                throw new BadInputException("Dob cannot be empty");
            }
            int year = Integer.parseInt(dob.substring(6));
            if(LocalDate.now().getYear() - year < 18){
                throw new BadInputException("Person should be 18 years and above");
            }
        }
        catch (BadInputException ex){
            errors.add(ex.getMessage());
            System.out.println(ex.getMessage());
            takeInputDob();
        }
    }
    public void takeInputAdhar(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.print("Enter adhar number : ");
            adharNum = scn.nextLine();
            if(adharNum.isEmpty()){
                throw new BadInputException("Adhar number cannot be empty");
            } else if (!adharNum.matches("[0-9]+")) {
                throw new BadInputException("Adhar number should be numbers only");
            }
            else if (adharNum.length() != 12) {
                throw new BadInputException("Adhar number should be of 12 digits only");
            }
        }
        catch (BadInputException ex){
            errors.add(ex.getMessage());
            System.out.println(ex.getMessage());
            takeInputAdhar();
        }

    }
    public void takeInput() {
        takeInputName();
        takeInputDob();
        takeInputAdhar();
    }

    public String generateUsername(){
        String section1 = "";
        if(nameArray[0].length()<4){
            section1 = nameArray[0].concat(nameArray[1].substring(0,1));
        } else{
            section1 = name.substring(0,4);
        }
        String section2 = dob.substring(0,2).concat(dob.substring(6));
        String section3 = adharNum.substring(8);
        return section1.concat(section2).concat(section3);
    }
}
