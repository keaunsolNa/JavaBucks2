package org.example.javapractice.Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface NutritionInformation {

    double kcal();
    double sodium();
    double saturatedFattyAcid();
    double sugar();
    double protein();
    double caffeine();
}
