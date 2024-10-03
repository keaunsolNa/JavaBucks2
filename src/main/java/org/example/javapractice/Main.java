package org.example.javapractice;

import org.example.javapractice.JFrame.MainFrame;
import org.example.javapractice.dto.Espresso.TallIcedCaffeAmericano;

import java.util.Arrays;

public class Main {

    private static Class<?> chosenMenu;
    private static Object chosenObject;

    public static void main (String[] args) {

        MainFrame mainFrame = new MainFrame();
        try
        {
            chosenMenu =  Class.forName("GrandeJavaChipFrappuccino");
            chosenObject = chosenMenu.newInstance();

        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }


    }
}