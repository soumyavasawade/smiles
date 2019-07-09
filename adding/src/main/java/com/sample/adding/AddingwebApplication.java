package com.sample.adding;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;

import java.util.Iterator;

import org.bson.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;

@SpringBootApplication
public class AddingwebApplication {

	   
	   public static void main( String args[] ) {  
		      
		      
		      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

		     
		   //   MongoCredential credential; 
		     // credential = MongoCredential.createCredential("sampleUser", "myDb", 
		       //  "password".toCharArray()); 
		      //System.out.println("Connected to the database successfully");  
		      
		      
		      MongoDatabase database = mongo.getDatabase("soumya1234"); 
		      database.createCollection("sampleCollection123"); 
		    
		      MongoCollection<Document> collection = database.getCollection("sampleCollection123"); 
		      System.out.println("Collection sampleCollection selected successfully");

		      Document document = new Document("title", "happy") 
		      .append("id", 1)
		      .append("description", "Soumya") 
		      .append("last", "Jain"); 
		      
		      collection.insertOne(document); 
		      System.out.println("Document inserted successfully");     
		      
		      
		      FindIterable<Document> iterDoc = collection.find(); 
		      int i = 1; 

		    
		      Iterator it = iterDoc.iterator(); 
		    
		      while (it.hasNext()) {  
		         System.out.println(it.next());  
		      i++; 
		      }
		      
		   } 
		}



