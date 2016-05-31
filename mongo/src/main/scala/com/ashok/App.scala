package com.ashok

import com.mongodb.MongoClient
import com.mongodb.client.{MongoCollection, MongoDatabase}
import org.bson.Document


/**
 * @author ${user.name}
 */
object App {
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    val collection: MongoCollection[Document] = connect("testDB","testData");
    val maxVal:Double = Math.pow(10,5);
    var i: Double = 0;
    val startTime:Long = System.currentTimeMillis()
    for(i <- 1.0 to maxVal by 1.0) {
      createDoc(collection, "TestInsert")
      if(i%1000 == 0){
        println(f"inserted $i%.0f documents")
      }
    }
    var now: Long = System.currentTimeMillis()
    var timeTaken: Double = (now - startTime);
    var timePerInsert: Double = timeTaken / maxVal
    var timeTakenInSec: Double = timeTaken/1000;
    println(f"Took $timeTakenInSec%.2f seconds");
    println(f"Thats $timePerInsert%.2f ms per insert ");
  }


  def connect(db: String, coll: String): MongoCollection[Document] = {
    val mongoClient: MongoClient = new MongoClient("192.168.1.18", 27017)
    val mongoDb: MongoDatabase = mongoClient.getDatabase(db)
    val collection: MongoCollection[Document] = mongoDb.getCollection(coll)
    if (mongoDb != null) {
      System.out.println("Connect to database successfully")
    }
    else {
      System.out.println("Unable to connect")
    }
    val i: Double = 0
    return collection
  }

  def createDoc(coll: MongoCollection[Document], name: String) {
    try {
      val doc: Document = new Document("name", name).
        append("description", "database").append("likes", 100).
        append("url", "http://www.tutorialspoint.com/mongodb/").
        append("by", "tutorials point");
      coll.insertOne(doc)
    }
    catch {
      case e: Exception => {
        e.printStackTrace
      }
    }
  }


}
