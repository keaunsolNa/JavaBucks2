package org.example.javapractice.CommonModule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonModule {

    private static final Logger log = LogManager.getLogger(CommonModule.class);

    public CommonModule() {

    }

    public List<String> getPackageNameFromPackage(String dirPath)
    {

        List<String> list = new ArrayList<>();
        File directory = new File(dirPath);


        if (directory.exists())
        {
            File[] files = directory.listFiles();
            if (files != null)
            {
                for (File file : files)
                {
                    if (file.isDirectory())
                    {
                        list.add(file.getName());
                    }
                }
            }
        }

        return list;
    }

    public Map<String, List<String>> getMenuMap(String pkgPath, String className)
    {

        Map<String, List<String>> map = new HashMap<>();
        System.out.println("IN CM : " + pkgPath);
        System.out.println("IN CM : " + className);

        try
        {

            File directory = new File(pkgPath);
            if (directory.exists())
            {
                File[] files = directory.listFiles();
                if (files != null)
                {
                    for (File file : files)
                    {
                        if (!file.isDirectory())
                        {
                            String fileName = file.getName().substring(0, file.getName().indexOf("."));
                            Class<?> dynamicClass = Class.forName(className + "." + fileName);

                            if (dynamicClass.getSuperclass().getSuperclass() == Object.class)
                            {
                                String upperClassName = dynamicClass.getSuperclass().getSimpleName();
                                if (map.containsKey(upperClassName))
                                {
                                    map.get(upperClassName).add(fileName);
                                }
                                else
                                {
                                    List<String> innerList = new ArrayList<>();
                                    innerList.add(fileName);
                                    map.put(upperClassName, innerList);
                                }
                            }
                        }
                    }
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
            log.debug(e.getMessage());
        }

        System.out.println(map);
        return map;
    }

    // Reflection 활용하여 객체의 정보를 가져오는 메서드 실행
    public Map<String, Object> getInfoMapFromDynamicClass (String className)
    {

        Map<String, Object> InformationMap = new HashMap<>();
        try
        {
            Class<?> dynamicClass = Class.forName(className);

            Constructor<?> dynamicConstructor = dynamicClass.getDeclaredConstructor();
            dynamicConstructor.setAccessible(true);
            Object instance = dynamicConstructor.newInstance();
            Method getInfoMap = dynamicClass.getMethod("getInformationMap");

            InformationMap = (Map<String, Object>) getInfoMap.invoke(instance);

        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
               InvocationTargetException e)
        {
            log.debug(e.getMessage());
        }

        return InformationMap;

    }

}
