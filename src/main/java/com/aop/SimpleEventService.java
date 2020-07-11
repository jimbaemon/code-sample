package com.aop;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{
    @Override
    @PerfLogging
    public void createEvent() {
        //long begin = System.currentTimeMillis(); INFO : 시간측정 목적 즉 POINT CUT 을 준것과 같은 효과이나 너무 무의미함

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Created an Event");

        //System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    @PerfLogging
    public void publishEvent() {
        //long begin = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Published an Event");

        //System.out.println(System.currentTimeMillis() - begin);
    }

    public void deleteEvent(){
        System.out.println("Deleted an Event");
    }
}
