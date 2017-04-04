package com.hujiang.barrage;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.concurrent.TimeUnit;

/**
 * Created by kyneh on 2017/4/4.
 */
public class Test {
    public static void main(String[] args) {
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        String dbName = "barrage";
//        influxDB.createDatabase(dbName);

//        BatchPoints batchPoints = BatchPoints
//                .database(dbName)
//                .tag("async", "true")
//                .retentionPolicy("autogen")
//                .consistency(InfluxDB.ConsistencyLevel.ALL)
//                .build();
//        Point point1 = Point.measurement("cpu")
////                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//                .addField("idle", 40L)
//                .addField("user", 9L)
//                .addField("system", 1L)
//                .build();
//        Point point3 = Point.measurement("cpu")
////                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//                .addField("idle", 30L)
//                .addField("user", 9L)
//                .addField("system", 1L)
//                .build();
//        Point point2 = Point.measurement("disk")
////                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//                .addField("used", 60L)
//                .addField("free", 1L)
//                .build();
//        Point point4 = Point.measurement("disk")
////                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//                .addField("used", 20L)
//                .addField("free", 1L)
//                .build();
//        batchPoints.point(point1);
//        batchPoints.point(point2);
//        batchPoints.point(point3);
//        batchPoints.point(point4);
//        influxDB.write(batchPoints);
        Query query = new Query("SELECT * FROM \"1002\"", dbName);
        QueryResult result = influxDB.query(query);
        System.out.println(result);
        result.getResults().forEach(x-> System.out.println(x));
//        influxDB.deleteDatabase(dbName);
    }
}
