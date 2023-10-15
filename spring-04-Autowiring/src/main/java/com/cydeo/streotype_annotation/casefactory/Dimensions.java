package com.cydeo.streotype_annotation.casefactory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class Dimensions {

    private int width, height, depth;

    public Dimensions() {
        this.width = 50;
        this.height = 10;
        this.depth = 10;
    }


    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }

}
