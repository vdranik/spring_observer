package com.vdranik.spring.observer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        //local code review (vtegza): start with lover case fro context file names @ 01.03.15
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //local code review (vtegza): registe shutdown hook on context @ 01.03.15
        Publisher publisher = context.getBean(Publisher.class);

        Subject subject = new Subject("Hello Spring!");
        publisher.notifyAllListeners(subject);
    }
}