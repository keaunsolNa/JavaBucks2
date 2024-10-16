package org.example.javapractice.Interface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.javapractice.CommonModule.CommonModule;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 클래스를 매개변수로 받아 애노테이션으로 정의된 메뉴의 정보를 가져오기 위한 interface
 * @author keaunsolNa
 * @version 1.0
 */
public interface GetInformation {

    // member variable area
    Logger log = LogManager.getLogger(CommonModule.class);
    Map<String, Object> informationMap = new TreeMap<>();

    /**
     *
     * 클래스를 매개변수로 받아 annotationType() 메서드를 통해 클래스 객체의 인스턴스를 생성한 뒤
     * getDeclaredMethod() 를 통해 정의된 메서드들을 가져온다.
     * 이후 invoke() 메서드를 통해 annotation 객체를 DI
     * informationMap 에 클래스의 annotation 정보를 저장한다.
     * @param T : 메뉴 정보를 가져오기 위한 클래스
     */
    default void getInformation(Class<?> T) {

        // Stream 을 통해 클래스에 정의된 annotation 가져오기
        Arrays.stream(T.getDeclaredAnnotations()).forEach(annotation -> {

            // 인스턴스 생성
            Class<? extends Annotation> annotationType = annotation.annotationType();
            // 메서드 배열 객체 생성
            Method[] methods = annotationType.getDeclaredMethods();

            for (Method method : methods)
            {

                try
                {
                    Object value = method.invoke(annotation);
                    informationMap.put(method.getName(), value);
                }

                catch (IllegalAccessException | InvocationTargetException e)
                {
                    log.debug(e.getMessage());
                }
            }
        });

    }
}
