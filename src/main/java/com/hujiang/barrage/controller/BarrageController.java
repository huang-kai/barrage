package com.hujiang.barrage.controller;

import com.google.gson.Gson;
import com.hujiang.barrage.pojo.Barrage;
import com.hujiang.barrage.services.BarrageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kyneh on 2017/4/4.
 */
@RestController
@Slf4j
@RequestMapping(value={"/v1/barrages"})
public class BarrageController {
    @Autowired
    BarrageService barrageService;

    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public void insertBarrage(@PathVariable String topic, @RequestBody String body){
        if (StringUtils.isEmpty(body)){
            throw new RuntimeException();
        }

        try{
            Gson gson = new Gson();
            Barrage jsonBarrage = gson.fromJson(body,Barrage.class);
            barrageService.insertBarrage(topic, jsonBarrage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{topic}", method = RequestMethod.GET)
    public String getBarrage(@PathVariable String topic){
        List<Barrage> barrageList = barrageService.getBarrages(topic);
        return "1";
    }
}
