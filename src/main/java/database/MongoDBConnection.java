package database;

import com.mongodb.*;
import com.mongodb.client.*;
import model.Alumno;
import model.Profesor;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


public class MongoDBConnection {

    private String connectionString = "mongodb+srv://%s:%s@cluster0.s8kqy.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    private MongoClient mongoClient;

    private CodecProvider codecProvider;
    private CodecRegistry codecRegistry;

    public MongoDBConnection() {

        //Pojo
        codecProvider = PojoCodecProvider.builder().automatic(true).build();
        codecRegistry = CodecRegistries.fromRegistries(

                MongoClients.create().getCodecRegistry(),
                CodecRegistries.fromProviders(codecProvider)
        );

        mongoClient = MongoClients.create(String.format(connectionString, DBScheme.usuario, DBScheme.password));
    }

    public MongoCollection getAlumnosCollection() {
        MongoDatabase database = mongoClient.getDatabase("centro_estudios").withCodecRegistry(codecRegistry);
        return database.getCollection("alumnos", Alumno.class);

    }

    public MongoCollection getProfesoresCollection() {
        MongoDatabase database = mongoClient.getDatabase("centro_estudios").withCodecRegistry(codecRegistry);
        return database.getCollection("profesores", Profesor.class);
    }

    //Para checkear la conexion de la base de datos Mongo.

    public void checkConnection() {
        try {
            MongoDatabase database = mongoClient.getDatabase("centro_estudios");
            MongoIterable<String> collections = database.listCollectionNames();
            System.out.println("Colecciones en la base de datos 'centro_estudios':");
            for (String collectionName : collections) {
                System.out.println("- " + collectionName);
            }
        } catch (MongoException e) {
            System.err.println("Error al listar las colecciones: " + e.getMessage());
        }


    }
}




