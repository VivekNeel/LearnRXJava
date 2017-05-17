package com.example.vivek.learnrxjava;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by vivek on 17/05/17.
 */

public class RXBus {

    private static RXBus mInstance;

    private PublishSubject subject = PublishSubject.create();

    public static RXBus getRXBusInstance() {
        if (mInstance == null) {
            mInstance = new RXBus();
        }
        return mInstance;
    }

    public void sendEvent(Object object) {
        subject.onNext(object);
    }

    public Observable<Object> getEvents() {
        return subject;
    }
}
