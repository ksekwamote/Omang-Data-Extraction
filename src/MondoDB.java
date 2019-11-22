/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vkapuisire
 */

import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;  

import java.util.Iterator; 
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import org.bson.Document; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;
import com.mongodb.BasicDBObject;


public class MondoDB {
    
    public MondoDB(){
    
    
    }
    
    
    
    public static void main( String args[] ) { 
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
      //MongoDatabase database = mongo.getDatabase("omang"); 
      DB db = mongo.getDB("omang");
    // MongoCollection<Document> collection = database.getCollection("personal"); 
     DBCollection coll = db.getCollection("personal");
     //System.out.println("Collection myCollection selected successfully"); 
      
     
      Test.main(args);
      BasicDBObject doc = new BasicDBObject();
      doc.put("id_number", Test.idNumber);
      doc.put("surname",Test.surname);
      doc.put("first_name", Test.firstnames);
      doc.put("date_of_birth",Test.dob);
      doc.put("place_of_birth",Test.pob);
      
      
      //coll.insert(doc);
     
      /**FindIterable<Document> iterDoc = collection.find(); 
      int i = 1; 

      // Getting the iterator 
      Iterator it = iterDoc.iterator(); 
    
      while (it.hasNext()) {  
         System.out.println(it.next());  
      i++; 
      }**/
      
      DBCursor cursor = coll.find();
      while(cursor.hasNext())
      {
          System.out.println(cursor.next());
      }
    }
    
    
}
