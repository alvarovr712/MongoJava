package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {

    private Double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private int calificaation;
    private String higher_grade;
    private Boolean FCTs;


    public void mostrarDatos() {

        System.out.println("rating = " + rating);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);
        System.out.println("calificaation = " + calificaation);
        System.out.println("higher_grade = " + higher_grade);
        System.out.println("FCTs = " + FCTs);
    }
}
