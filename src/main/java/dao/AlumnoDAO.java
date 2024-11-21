package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import model.Alumno;
import model.Profesor;
import org.bson.conversions.Bson;

public class AlumnoDAO {

    MongoCollection coleccionAlumnos;
    public AlumnoDAO(){
        coleccionAlumnos = new MongoDBConnection().getAlumnosCollection();

    }

    public void agregarAlumno(Alumno alumno){

        MongoCollection collection = new MongoDBConnection().getAlumnosCollection();
        collection.insertOne(alumno);

    }
    public void getAlumnos(){
        MongoCollection collection = new MongoDBConnection().getAlumnosCollection();
        FindIterable<Alumno> iterable= collection.find(Alumno.class);
        MongoCursor<Alumno> cursor = iterable.cursor();
        while(cursor.hasNext()){

            Alumno alumno = cursor.next();
            alumno.mostrarDatos();

        }
    }

    public void buscarAlumnoPorEmail(String email){

        MongoCollection collection = new MongoDBConnection().getAlumnosCollection();
        Bson filtro = Filters.eq("email",email);
        FindIterable<Alumno> iterable= collection.find(filtro,Alumno.class);
        MongoCursor<Alumno> cursor = iterable.cursor();
        while(cursor.hasNext()){

            Alumno alumno = cursor.next();
            alumno.mostrarDatos();

        }






    }

    public void darBajaAlumno(){

        int calificaation = 4;
       //en vez de lte gte y el valor es 5
        Bson filtro = Filters.lte("calificaation",calificaation);

        MongoCollection collection = new MongoDBConnection().getAlumnosCollection();
        collection.deleteMany(filtro);

    }
}
