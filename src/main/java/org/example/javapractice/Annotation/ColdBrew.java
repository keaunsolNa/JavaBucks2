package org.example.javapractice.Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface ColdBrew {

    String Type() default "ColdBrew";
}
