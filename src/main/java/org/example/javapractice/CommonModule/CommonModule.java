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

    public List<String> getPackageNameFromPackage(String dirPath, String pkgPath, boolean isClass)
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

                    String className = file.getName().substring(0, file.getName().length() - 5);
                    if (!isClass && file.isDirectory())
                    {
                        list.add(file.getName());
                    }

                    else if (isClass && file.isFile())
                    {

                        try
                        {
                            Class<?> dynamicClass = Class.forName(pkgPath + "." + className);
                            if (dynamicClass.getSuperclass().getSuperclass() != Object.class)
                            {
                                list.add(className);
                            }

                        }
                        catch (Exception e)
                        {
                            log.debug(e.getMessage());
                        }
                    }
                }
            }
        }

        System.out.println(list);
        return list;
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
