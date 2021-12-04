package test;/**
 * @version :JDK1.8
 * @date : 2021-12-03 16:59
 * @author : vip865047755@126.com
 * @File : MongoTest.java
 * @software: IntelliJ IDEA
 */

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


/**
 * @author: vesns vip865047755@126.com
 * @Title: MongoTest
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 16:59
 */

public class MongoTest {

    // 客户端
    private MongoClient mongoClient;
    // 集合
    private MongoCollection<Document> comment;

    @Before
    public void init() {
        //1. 创建操作MongoDB的客户端
        mongoClient = new MongoClient("127.0.0.1");
        // MongoClient mongoClient = new MongoClient("127.0.0.1",27017);

        //2. 选择数据库 use commentdb
        MongoDatabase commentdb = mongoClient.getDatabase("commentdb");

        //3. 获取集合 db.comment
        comment = commentdb.getCollection("comment");
    }


    //查询所有数据db.comment.find()
    @Test
    public void test1() {
        //4. 使用集合进行查询，查询所有数据db.comment.find()
        FindIterable<Document> documents = comment.find();

        //5. 解析结果集（打印）
        // "_id" : "1", "content" : "到底为啥出错", "userid" : "1012", "thumbup" : 2020 }
        for (Document document : documents) {
            System.out.println("------------------------------");
            System.out.println("_id:" + document.get("_id"));
            System.out.println("content:" + document.get("content"));
            System.out.println("userid:" + document.get("userid"));
            System.out.println("thumbup:" + document.get("thumbup"));
        }
    }


    @After
    public void after() {
        // 释放资源,关闭客户端
        mongoClient.close();
    }

    /**
     * 根据条件查询，db.comment.find({"_id":"1"})
     */
    @Test
    public void test2() {
        BasicDBObject bson = new BasicDBObject("_id","1");
        FindIterable<Document> documents = comment.find(bson);
        for (Document document : documents) {
            System.out.println("------------------------------");
            System.out.println("_id:" + document.get("_id"));
            System.out.println("content:" + document.get("content"));
            System.out.println("userid:" + document.get("userid"));
            System.out.println("thumbup:" + document.get("thumbup"));
        }
    }

    /**
     * 新增db.comment.insert({"_id":"5","content":"坚持就是胜利","userid":"1018","thumbup":"456"})
     */
    @Test
    public void test3() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("_id","6");
        map.put("content","新增测试");
        map.put("userid","1019");
        map.put("thumbup","666");
        Document document = new Document(map);
        comment.insertOne(document);
    }

    /**
     * 修改db.comment.update({"_id":"6"},${"userid":"4565"})
     */
    @Test
    public void test4() {
        BasicDBObject filter = new BasicDBObject("_id","6");
        BasicDBObject update = new BasicDBObject("$set",new Document("userid","9999"));
        comment.updateOne(filter,update);
    }

    /**
     * 删除db.remove({"_id":"6"})
     */
    @Test
    public void test5() {
        BasicDBObject bson = new BasicDBObject("_id", "6");
        comment.deleteOne(bson);

    }

}
