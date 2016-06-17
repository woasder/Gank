package com.yyw.abc.ganhuo.RxBus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by abc on 2016/6/14.
 */
public class RxBus {
    private static volatile RxBus defaultInstance;
    private final Subject bus;
    public RxBus(){
        bus = new SerializedSubject(PublishSubject.create());
    }

    public static RxBus getDefaultInstance(){
        RxBus rxBus = defaultInstance;
        if (defaultInstance == null){
            synchronized (RxBus.class){
                rxBus = defaultInstance;
                if (defaultInstance == null){
                    rxBus = new RxBus();
                    defaultInstance = rxBus;
                }
            }
        }
        return rxBus;
    }

    public void post(Object object){
        bus.onNext(object);
    }

    public <T> Observable<T> toObservable(Class<T> eventType){
        return bus.ofType(eventType);
    }
}
