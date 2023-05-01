package com.sapient.grooming.Week4;

import com.sapient.grooming.Exception.BadInputException;
import com.sapient.grooming.Exception.ProductIdException;
import com.sapient.grooming.Model.Category;
import com.sapient.grooming.Model.Product;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Question1 {
    static Set<String> idSet = new HashSet<>();
    static List<Product> productList = new ArrayList<>();
    public static String takeInputId(){
        String id = "";
        Scanner scn = new Scanner(System.in);
        try {
            System.out.print("Enter productId : ");
            id = scn.nextLine();
            if(idSet.contains(id)){
                throw new ProductIdException("This id is already present");
            }
            idSet.add(id);
        }catch (ProductIdException ex){
            System.out.println(ex.getMessage());
            takeInputId();
        }
        return id;
    }
    public static String takeInputName(){
        String name = "";
        Scanner scn = new Scanner(System.in);
        try{
            System.out.print("Enter product name : ");
            name = scn.nextLine();
            if(name.length()>100){
                throw new BadInputException("Name length should not be of more then 100 characters");
            }
        }catch (BadInputException ex){
            System.out.println(ex.getMessage());
            takeInputName();
        }
        return name;
    }
    public static Boolean takeInputWarranty(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.print("Enter YES/NO for warranty respectively : ");
            String inputWarranty = scn.next();
            if(inputWarranty.equalsIgnoreCase("YES")){
                return true;
            }else if(inputWarranty.equalsIgnoreCase("NO")){
                return false;
            }else{
                throw new BadInputException("Enter valid input");
            }
        }catch (BadInputException ex){
            System.out.println(ex.getMessage());
            takeInputWarranty();
        }
        return false;
    }
    public static Category takeInputCategory(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.println("Enter 1 for category MOBILE : ");
            System.out.println("Enter 2 for category TV : ");
            System.out.println("Enter 3 for category REFRIGERATOR : ");
            System.out.println("Enter 4 for category LAPTOP : ");
            Integer categoryNo = scn.nextInt();
            if(categoryNo.equals(1)) return Category.MOBILE;
            else if(categoryNo.equals(2)) return Category.TV;
            else if(categoryNo.equals(3)) return Category.REFRIGERATOR;
            else if(categoryNo.equals(4)) return Category.LAPTOP;
            else {
                throw new BadInputException("Enter valid Input");
            }
        }catch (BadInputException ex){
            System.out.println(ex.getMessage());
            takeInputCategory();
        }
        return null;
    }

     static void takeInput(){
        String id = takeInputId();
        String name = takeInputName();
        boolean warranty = takeInputWarranty();
        Category category = takeInputCategory();
        Product p = new Product(id,name,warranty,category);
        productList.add(p);
    }

    public static void main(String[] args) {
        Product p1 = new Product("1001","LG LED",true, Category.TV);
        idSet.add("1001");
        Product p2 = new Product("1002","DELL INSPIRON 5567",false, Category.LAPTOP);
        idSet.add("1002");
        Product p3 = new Product("1003","IPHONE 12",true, Category.MOBILE);
        idSet.add("1003");
        Product p4 = new Product("1004","SAMSUNG AUTOMATIC",false, Category.REFRIGERATOR);
        idSet.add("1004");
        productList.addAll(List.of(p1,p2,p3,p4));
        takeInput();

        //we use predicate to have condition in filter,it return true or false
        Predicate<Product> filterWarrantyProd = (product) -> product.getWarranty().equals(true);
        Predicate<Product> filterNonWarrantyProd = (product) -> product.getWarranty().equals(false);

        // consumer for traversal
        Consumer<List<Product>> printConsumer = System.out::println;

        List<Product> warrantyProducts = productList.stream().filter(filterWarrantyProd).toList();
        List<Product> nonWarrantyProducts = productList.stream().filter(filterNonWarrantyProd).toList();

        List<List<Product>> output = new ArrayList<>(List.of(warrantyProducts, nonWarrantyProducts));
        output.forEach(printConsumer);
    }
}
