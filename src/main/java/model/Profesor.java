package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Profesor {


    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private List<String> subjects;
    private String title;


    public void mostrarDatos(){

        System.out.println("rating = " + rating);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);
        System.out.println("subjects = ");
        for(String item: subjects){
            System.out.println(item + "");
        }
        System.out.println("title = " + title);
    }
}
