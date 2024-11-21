package dao;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import database.MongoDBConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import model.Alumno;
import model.Profesor;
import org.bson.conversions.Bson;

public class ProfesorDAO {

    MongoCollection coleccionProfesores;
    public ProfesorDAO(){
        coleccionProfesores = new MongoDBConnection().getProfesoresCollection();

    }


    public void agregarProfesor(Profesor profesor){

        MongoCollection collection = new MongoDBConnection().getProfesoresCollection();
        collection.insertOne(profesor);

    }

    public void getProfesores(){
        MongoCollection collection = new MongoDBConnection().getProfesoresCollection();
        FindIterable<Profesor> iterable= collection.find(Profesor.class);
        MongoCursor<Profesor> cursor = iterable.cursor();
        while(cursor.hasNext()){

            Profesor profesor = cursor.next();
            profesor.mostrarDatos();

        }

    }

    public void buscarProfesoresPorEdad(int edadMinima, int edadMaxima){

        MongoCollection collection = new MongoDBConnection().getProfesoresCollection();

        Bson filtro = Filters.and(
                Filters.gte("age", edadMinima),
                Filters.lte("age", edadMaxima)
        );

        FindIterable<Profesor> iterable = collection.find(filtro, Profesor.class);
        MongoCursor<Profesor> cursor = iterable.cursor();
        while(cursor.hasNext()){
            Profesor profesor = cursor.next();
            profesor.mostrarDatos();
        }

    }

    public void actualizarProfesor(String email, Double rating){

        Bson filtro = Filters.eq("email",email);
        Bson actualizacion = Updates.set("rating", rating);
        MongoCollection collection = new MongoDBConnection().getProfesoresCollection();
        collection.updateMany(filtro, actualizacion);
    }


}
