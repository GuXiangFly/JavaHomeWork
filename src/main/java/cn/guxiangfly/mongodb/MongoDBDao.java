package cn.guxiangfly.mongodb;

import com.mongodb.*;

/**
 * MongoDBDao
 *
 * @author guxiang
 * @date 2018/3/22
 */

public class MongoDBDao {

   
    public void testAdd() throws Exception{
        Mongo mongo = new Mongo("127.0.0.1", 5555);
        DB db = mongo.getDB("test");
        DBCollection person2 = db.getCollection("person2");

        DBObject dbObject = new BasicDBObject();

        dbObject.put("name","guxiang");
        dbObject.put("desc","单身dog");
        person2.insert(dbObject);
    }

    public void testFind() throws Exception{
        Mongo mongo = new Mongo("127.0.0.1", 5555);
        DB db = mongo.getDB("test");
        DBCollection person2 = db.getCollection("person2");
        DBCursor cursor = person2.find();
        while (cursor.hasNext()){
            DBObject dbObject = cursor.next();
            System.out.println(dbObject.toString());
            System.out.println(dbObject.get("name"));
        }
    }
    public static void main(String[] args) {
        try {
            new MongoDBDao().testFind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
