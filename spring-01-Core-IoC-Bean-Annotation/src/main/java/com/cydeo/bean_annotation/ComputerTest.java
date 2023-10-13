package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        // Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        // Creating container by using BeanFactory
        BeanFactory context = new AnnotationConfigApplicationContext();


        // Retrieving the beans
//        Monitor theMonitor = container.getBean(Monitor.class);
//        Case theCase = container.getBean(Case.class);
//        Motherboard theMotherboard = container.getBean(Motherboard.class);
//
//        PC myPc = new PC(theCase,theMonitor,theMotherboard);
//
//        myPc.powerUp();



        System.out.println("\n------------------------------Multiple Objects (in ComputerConfig)------------------------------\n");


        // Retrieving the beans
        Monitor sony = container.getBean("monitorSony", Monitor.class); // Default beanName is method name.
        // Monitor sony = container.getBean(Monitor.class); // Default monitor (by using @Primary annotation)
        Case dell = container.getBean(DellCase.class);
        Motherboard asus = container.getBean(AsusMotherboard.class);

        PC myPc2 = new PC(dell,sony,asus);

        myPc2.powerUp();


        Monitor theMonitor2 = container.getBean("acer", Monitor.class); // by using custom beanName
        // If i add a @Primary annotation to any Bean in config class, compiler create the primary one even if i write another bean name in here.
        Case theCase2 = container.getBean(Case.class);
        Motherboard theMotherboard2 = container.getBean(Motherboard.class);

        PC myPc3 = new PC(theCase2, theMonitor2, theMotherboard2);

        myPc3.powerUp();

    }
}
