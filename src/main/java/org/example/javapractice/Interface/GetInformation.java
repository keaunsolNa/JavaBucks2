package org.example.javapractice.Interface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.javapractice.CommonModule.CommonModule;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface GetInformation {

    Logger log = LogManager.getLogger(CommonModule.class);
    Map<String, Object> informationMap = new HashMap<>();
    default void getInformation(Class<?> T) {

        Arrays.stream(T.getDeclaredAnnotations()).forEach(annotation -> {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Method[] methods = annotationType.getDeclaredMethods();

            for (Method method : methods)
            {

                try
                {
                    Object value = method.invoke(annotation);
                    informationMap.put(method.getName(), value);
                }

                catch (Exception e)
                {
                    log.debug(e.getMessage());
                }
            }
        });

    }
}
