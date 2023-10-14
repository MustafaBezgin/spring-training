package com.cydeo.streotype_annotation.monitorfactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class AcerMonitor extends Monitor {

    public AcerMonitor() {
        super("23 inch beast","Sony",23);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Acer");
    }


}
