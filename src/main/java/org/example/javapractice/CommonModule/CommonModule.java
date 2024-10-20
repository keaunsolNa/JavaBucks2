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

/**
 * 일반적으로 사용될 공통 함수 모듈
 * @author keaunsolNa
 * @version 1.0
 */
public class CommonModule {

    private static final Logger log = LogManager.getLogger(CommonModule.class);

    // Constructor
    public CommonModule() {

    }

    /**
     *
     * 디렉터리의 경로를 받아 디렉터리에 존재하는 패키지(폴더) 목록을 가져온다.
     * 이 때 파일은(Class, Java) 제외한다.
     * @param dirPath : 디렉터리 경로
     * @return : 디렉터리에 존재하는 package 의 이름 목록
     */
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

    /**
     *
     * 패키지 경로와 import 주소를 받아 폴더 내에 존재하는 클래스 파일들을 Map 형태로 반환한다.
     * 이 때 반환 객체는 Map<String, List<String>> 형태로 한다.
     * Map의 키 값은 Main 객체로, 옵션이 포함되지 않은 원형 객체가 된다.
     * 해당 키 값에 List<String> 형태로 옵션이 포함된 클래스들의 이름을 담는다.
     * 구조는 Sub 객체가 Main 객체를 구현하는 방식으로 한다.
     *
     * @param pkgPath : 패키지 경로 (폴더 경로)
     * @param className : 클래스 객체 생성을 위한 클래스 import 주소
     * @return : 패키지 내에 존재하는 클래스들을 Main 객체와 Sub 객체로 나눠 Map 형태로 반환
     */
    public Map<String, List<String>> getMenuMap(String pkgPath, String className)
    {

        Map<String, List<String>> map = new HashMap<>();

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

                            // 파일 이름은 확장자 명 제거
                            String fileName = file.getName().substring(0, file.getName().indexOf("."));
                            // import 경로와 파일 이름과이름으로 클래스 객체 생성
                            Class<?> dynamicClass = Class.forName(className + "." + fileName);

                            /*
                                모든 클래스는 java.lang.Object 를 상속 받는다. 따라서 getSuperClass()를 통해
                                Main 객체와 Main 객체를 상솓 받는 Sub 객체를 구분한다.
                             */
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
            log.debug(e.getMessage());
        }

        return map;
    }

    /**
     * Reflection 활용하여 객체의 정보를 가져오는 메서드
     * 모든 Menu 객체는 Main 객체는 implements, Sub 객체는 메인 객체를 Override 하는 방식으로 getInformationMap 인터페이스를 상속받는다.
     * 이를 이용해 Annotation 에 저장된 정보를 받아오는 getInformationMap() 메서드를 실행함으로서 정보를 가져온다.
     *
     * @param className : 정보를 가져올 클래스 객체 이름
     * @return : Map<String, Object> 형태로 정의된 클래스의 Annotation 정보 객체
     */
    public Map<String, Object> getInfoMapFromDynamicClass (String className)
    {

        Map<String, Object> InformationMap = new HashMap<>();

        try
        {

            // 클래스 이름으로 클래스 객체 생성
            Class<?> dynamicClass = Class.forName(className);

            // Object newInstance() 의 경우 deprecated 되었다.
            // https://errorprone.info/bugpattern/ClassNewInstance 참조
            // Constructor 생성 후 해당 생성자를 통해 인스턴스를 만든다.
            Constructor<?> dynamicConstructor = dynamicClass.getDeclaredConstructor();

            // 접근 제어자 우회
            dynamicConstructor.setAccessible(true);
            Object instance = dynamicConstructor.newInstance();

            // 클래스에 있는 getInformationMap 메서드 가져오기
            Method getInfoMap = dynamicClass.getMethod("getInformationMap");

            // 메서드 invoke()
            InformationMap = (Map<String, Object>) getInfoMap.invoke(instance);

        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
               InvocationTargetException e)
        {
            log.debug(e.getMessage());
        }

        return InformationMap;

    }

    public StringBuilder makeStringBuilderByInformationMap(Map<String, Object> map, String Language, int[] options)
    {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>").append("<br/>");
        stringBuilder.append("<body>").append("<br/>");

        for (String key : map.keySet())
        {
            switch (key)
            {
                case "Type" :
                    stringBuilder.append("<p style=\"font-size:24px; color:red;\">");
                    stringBuilder.append(map.get(key).toString());
                    stringBuilder.append("</p>").append("<br/>");
                    break;


                case "name" :
                    stringBuilder.append("<p style=\"font-size:18px; color:black;\">");
                    stringBuilder.append(map.get(key).toString());
                    stringBuilder.append("</p>").append("<br/>");
                    break;

                case "icedOnly" :

                    options[4] = (boolean) map.get(key) ? 0 : 1;
                    break;

                default:
                    stringBuilder.append("<p style=\"font-size:10px; color:black;\">");
                    stringBuilder.append("<p>").append(Language.equals("KO") ? translateKeyKo(key) : key).append(" : ");
                    stringBuilder.append(map.get(key).toString());
                    stringBuilder.append("</p>").append("<br/>");
            }
        }

        stringBuilder.append("</html>").append("<br/>");
        stringBuilder.append("</body>").append("<br/>");

        return stringBuilder;
    }

    private String translateKeyKo (String key)
    {

        return switch (key) {
            case "kcal" -> "칼로리";
            case "sodium" -> "나트륨";
            case "saturatedFattyAcid" -> "포화지방";
            case "sugar" -> "당류";
            case "protein" -> "단백질";
            case "caffeine" -> "카페인";
            default -> key;
        };
    }
}
