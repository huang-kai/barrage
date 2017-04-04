package com.hujiang.barrage.pojo;

import lombok.Data;

/**
 * Created by kyneh on 2017/4/4.
 */
@Data
public class Barrage {
    private long rowId;
    private long relativeTime;
    private int type;
    private int font;
    private long color;
    private long userId;
    private String msg;
}
