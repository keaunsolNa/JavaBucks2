package org.example.javapractice.Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface Drink {

    boolean isCold();
    String size();
    int ml();
}
