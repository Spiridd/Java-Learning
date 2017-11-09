package ru.ncedu.java.tasks;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dimon on 01.10.17.
 */
public class BusinessCardImpl implements BusinessCard {
    private String firstName;
    private String lastName;
    private String department;
    private int salary;
    private static final int salaryMin = 100;
    private static final int salaryMax = 100000;
    private int age;
    private String gender;
    private String phoneNumber;

    public BusinessCardImpl() {
    }

    public BusinessCardImpl(String firstName, String lastName,
                            String department, int salary,
                            int age, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public BusinessCard getBusinessCard(Scanner scanner) {
        scanner.useDelimiter("\\s*;\\s*");

        String firstName, lastName, department, birthDateString, gender,
                phoneNumber, salaryString;
        // pleasing idiotic java compiler
        firstName = "ololo";
        lastName = "ololo";
        department = "ololo";
        salaryString = "ololo";
        gender = "ololo";
        birthDateString = "ololo";

        if (scanner.hasNext())  firstName = scanner.next();
        if (scanner.hasNext())  lastName = scanner.next();
        if (scanner.hasNext())  department = scanner.next();
        if (scanner.hasNext())  birthDateString = scanner.next();
        if (scanner.hasNext())  gender = scanner.next();
        if (scanner.hasNext())  salaryString = scanner.next();
        if (scanner.hasNext())  phoneNumber = scanner.next();
        else throw new NoSuchElementException();

        if (!(gender.equals("F") || gender.equals("M"))) throw new InputMismatchException();

        int salary;
        try {
            salary = Integer.parseInt(salaryString);
        } catch (Exception e) {
            throw new InputMismatchException();
        }
        if (salary > salaryMax || salary < salaryMin)   throw new InputMismatchException();

        long phone;
        try {
            phone = Long.parseLong(phoneNumber);
        } catch (Exception e) {
            throw new InputMismatchException();
        }

        if (phone >= 1e10 || phone < 1e9)  throw new InputMismatchException();

        // birthDate
        Calendar birthDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            birthDate.setTime(sdf.parse(birthDateString));
        } catch (Exception e) {
            throw new InputMismatchException();
        }

        Calendar now = Calendar.getInstance();
        int age = now.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)
                || now.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)
                && now.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))
            --age;

        return new BusinessCardImpl(firstName, lastName, department,
                salary, age, gender, phoneNumber);
    }

    @Override
    public String getEmployee() {
        return firstName + " " + lastName;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender.equals("M") ? "Male" : "Female";
    }

    @Override
    public String getPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("+7 ").append(phoneNumber.subSequence(0, 3)).append('-')
                .append(phoneNumber.subSequence(3, 6)).append('-')
                .append(phoneNumber.subSequence(6, 8)).append('-')
                .append(phoneNumber.subSequence(8, 10));
        return sb.toString();
    }
}
