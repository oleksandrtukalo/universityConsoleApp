package com.tukalo.university;

import com.tukalo.university.model.Department;
import com.tukalo.university.model.Lector;
import com.tukalo.university.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    private SearchService searchService;

    @Autowired
    public UniversityApplication(SearchService searchService) {
        this.searchService = searchService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ");
        System.out.println("HELLO IT'S A SIMPLE APPLICATION FOR UNIVERSITY ");
        System.out.println("Select an action by pressing the numeric on the keyboard");
        menuList();
        menuChoose();


    }

    public void menuChoose() throws NullPointerException {
        List<Department> departments = searchService.findAllDepartment();
        int menuValue = Keyin.inInt();
        switch (menuValue) {
            case 1:
                System.out.println("Please choose department :");
                departments.forEach(department ->
                        System.out.println(department.getDepId() + ". " + department.getDepName()));
                int depValue = Keyin.inInt();
                Lector head = searchService.findHeadOfDepartment(depValue);
                System.out.println("Head of department : " + head.getfName() + " " + head.getlName());
                break;

            case 2:
                System.out.println("Please choose department :");
                departments.forEach(department ->
                        System.out.println(department.getDepId() + ". " + department.getDepName()));
                int depStatValue = Keyin.inInt();
                HashMap<String, Object> map = new HashMap<>(searchService.findStatisticOfDepartment(depStatValue));
                System.out.println("Professors count : " + map.get("ProfessorCount"));
                System.out.println("Assistant count : " + map.get("AssistantCount"));
                System.out.println("Associate professor count : " + map.get("AssocProfesCount"));
                break;
            case 3:
                System.out.println("Please choose department :");
                departments.forEach(department ->
                        System.out.println(department.getDepId() + ". " + department.getDepName()));
                int depSalaryValue = Keyin.inInt();
                System.out.println("Average salary : " + searchService.findAverageSalaryOfDepartment(depSalaryValue));
                break;
            case 4:
                System.out.println("Please choose department :");
                departments.forEach(department ->
                        System.out.println(department.getDepId() + ". " + department.getDepName()));
                int depCountValue = Keyin.inInt();
                System.out.println("Count of employee : " + searchService.findCountEmployeeOfDepartment(depCountValue));
                break;
            case 5:
                System.out.println("Please type the characters :");
                String value = Keyin.inString();
                searchService.findByTemplate("'%" + value + "%'").forEach(lector ->
                        System.out.println(lector.getfName() + " " + lector.getlName()));
                break;
            case 6:
                System.exit(0);
        }
        menuList();
        menuChoose();
    }

    static void menuList() {
        System.out.println(" ");
        System.out.println("|        1. Who is head of  department ?     |");
        System.out.println("|        2. Show department statistic     |");
        System.out.println("|        3. Show the average salary for department       |");
        System.out.println("|        4. Show count of employee for department       |");
        System.out.println("|        5. Global search        |");
        System.out.println("|        6. Exit        |");
    }
}

