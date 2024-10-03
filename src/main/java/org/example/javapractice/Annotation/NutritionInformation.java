package org.example.javapractice.Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface NutritionInformation {

    int kcal();
    int sodium();
    int saturatedFattyAcid();
    int sugar();
    int protein();
    int caffeine();
}
