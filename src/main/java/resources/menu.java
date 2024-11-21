package resources;

import dao.AlumnoDAO;
import dao.ProfesorDAO;
import model.Alumno;
import model.Profesor;

import java.util.List;
import java.util.Scanner;

public class menu {

    Scanner leer = new Scanner(System.in);
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    ProfesorDAO profesorDAO = new ProfesorDAO();

    int opcion;


    public void mostrarMenu() {
        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1- Insertar un profesor");
            System.out.println("2- Insertar un alumno");
            System.out.println("3- Mostrar todos los datos");
            System.out.println("4- Mostrar profesores");
            System.out.println("5- Mostrar alumnos");
            System.out.println("6- Buscar alumno");
            System.out.println("7- Buscar profesor");
            System.out.println("8- Actualizar profesor");
            System.out.println("9- Dar de baja alumnos");
            System.out.println("10- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:

                    System.out.println("Ingrese los datos del profesor:");
                    System.out.print("rating: ");
                    double rating = leer.nextDouble();
                    System.out.print("age: ");
                    int age = leer.nextInt();
                    leer.nextLine(); // Limpiar el buffer
                    System.out.print("name: ");
                    String name = leer.nextLine();
                    System.out.print("gender: ");
                    String gender = leer.nextLine();
                    System.out.println("email: ");
                    String email = leer.nextLine();
                    System.out.print("phone: ");
                    String phone = leer.nextLine();
                    System.out.print("subjects (separadas por coma): ");
                    String[] subjects = leer.nextLine().split(",");
                    System.out.println("title: ");
                    String title = leer.nextLine();

                    Profesor profesor = new Profesor(rating, age, name, gender, email, phone, List.of(subjects), title);
                    profesorDAO.agregarProfesor(profesor);
                    System.out.println("Profesor agregado correctamente.");
                    break;
                case 2:
                    System.out.println("Ingrese los datos del alumno:");
                    System.out.println("rating: ");
                    Double rating1 = leer.nextDouble();
                    System.out.println("age: ");
                    int age1 = leer.nextInt();
                    leer.nextLine();
                    System.out.println("name: ");
                    String name1 = leer.nextLine();
                    System.out.println("gender: ");
                    String gender1 = leer.nextLine();
                    System.out.println("email: ");
                    String email1 = leer.nextLine();
                    System.out.println("phone: ");
                    String phone1 = leer.nextLine();
                    System.out.println("calificaation: ");
                    int calificaation = leer.nextInt();
                    leer.nextLine();
                    System.out.println("higher_grade: ");
                    String higher_grade = leer.nextLine();
                    System.out.println("FCTs: ");
                    Boolean FCTs = leer.nextBoolean();
                    Alumno alumno = new Alumno(rating1,age1,name1,gender1,email1,phone1,calificaation,higher_grade,FCTs);
                    alumnoDAO.agregarAlumno(alumno);
                    System.out.println("Alumno agregado correctamente");
                    break;
                case 3:
                    alumnoDAO.getAlumnos();
                    profesorDAO.getProfesores();
                    break;
                case 4:
                    profesorDAO.getProfesores();
                    break;
                case 5:
                    alumnoDAO.getAlumnos();
                    break;
                case 6:
                    System.out.println("Dame un email");
                    String email2 = leer.nextLine();
                    alumnoDAO.buscarAlumnoPorEmail(email2);
                    break;
                case 7:
                    System.out.println("Dame la edad minima");
                    int edadMinima = leer.nextInt();
                    System.out.println("Dame la edad maxima");
                    int edadMaxima = leer.nextInt();
                    profesorDAO.buscarProfesoresPorEdad(edadMinima,edadMaxima);
                    break;
                case 8:
                    System.out.println("Dame el email");
                    String email3 = leer.nextLine();
                    System.out.println("Dame el nuevo rating que le quieres poner");
                    Double rating3 = leer.nextDouble();
                    profesorDAO.actualizarProfesor(email3,rating3);
                    System.out.println("Se ha actualizado el profesor con exito");
                    break;
                case 9:
                    alumnoDAO.darBajaAlumno();
                    System.out.println("Se han dado de baja correctamente");
                    break;

                case 10:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción incorrecta, por favor intentelo de nuevo");
            }
        } while (opcion != 10);  // Esta línea está ahora dentro del ciclo `do`

        leer.close();
    }
}

