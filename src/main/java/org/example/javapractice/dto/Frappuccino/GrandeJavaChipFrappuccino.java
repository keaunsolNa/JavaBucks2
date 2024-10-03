package org.example.javapractice.dto.Frappuccino;

import org.example.javapractice.Annotation.*;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "JavaChipFrappuccino", price = 6800)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 460, sodium = 240, saturatedFattyAcid = 12, sugar = 55, protein = 7, caffeine = 130)
@Frappuccino
public class GrandeJavaChipFrappuccino implements GetInformation {

    public GrandeJavaChipFrappuccino() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(GrandeJavaChipFrappuccino.class);
        return informationMap;
    }
}
