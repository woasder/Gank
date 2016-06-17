package com.yyw.abc.ganhuo.RxBus;

/**
 * Created by abc on 2016/6/14.
 */
public class UserEvent {
    long id;
    String name;

    public UserEvent(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }


}
