package com.hujiang.barrage.services;

import com.google.gson.Gson;
import com.hujiang.barrage.pojo.Barrage;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyneh on 2017/4/4.
 */
@Service
public class BarrageService {

    private InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
    private String dbName = "barrage";

    Gson gson = new Gson();

    public void insertBarrage(String topic, Barrage jsonBarrage) {
        Point barrage = Point.measurement(topic)
                .addField("relativeTime", jsonBarrage.getRelativeTime())
                .addField("type", jsonBarrage.getType())
                .addField("font", jsonBarrage.getFont())
                .addField("color", jsonBarrage.getColor())
                .addField("userId", jsonBarrage.getUserId())
                .addField("msg",jsonBarrage.getMsg())
                .build();
        influxDB.write(dbName,"autogen", barrage);
    }

    public List<Barrage> getBarrages(String topic) {
        List<Barrage> barrageResult = new ArrayList<>();
        String cmd = "SELECT * FROM " + topic;
        Query query = new Query(cmd, dbName);
        QueryResult results = influxDB.query(query);
        results.getResults().forEach(result->{
           QueryResult.Series series = result.getSeries().get(0);
        });
        return barrageResult;
    }
}
