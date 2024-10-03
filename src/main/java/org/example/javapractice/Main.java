package org.example.javapractice;

import org.example.javapractice.dto.Espresso.TallIcedCaffeAmericano;

import java.util.Arrays;

public class Main {

    public static void main (String[] args) {


        TallIcedCaffeAmericano tca =  new TallIcedCaffeAmericano();


        System.out.println("INFOMAP : " + tca.getInformationMap());

        Arrays.stream(TallIcedCaffeAmericano.class.getAnnotations()).forEach(f -> {

            Arrays.stream(f.annotationType().getMethods()).forEach(method -> {

//                System.out.println("METHOD ");
//                System.out.println(method.getName());
//                System.out.println(method.getDefaultValue());
//                System.out.println(method.getModifiers());
//                System.out.println(method.getGenericReturnType());
            });

        });
    }
}