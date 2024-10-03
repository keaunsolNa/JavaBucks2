package org.example.javapractice.dto.Frappuccino;

import org.example.javapractice.Annotation.*;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "JavaChipFrappuccino", price = 6300)
@Drink(isCold = true, size = "Tall", ml = 355)
@NutritionInformation(kcal = 340, sodium = 180, saturatedFattyAcid = 9, sugar = 42, protein = 6, caffeine = 100)
@Frappuccino
public class TallJavaChipFrappuccino implements GetInformation {

    public TallJavaChipFrappuccino() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(TallJavaChipFrappuccino.class);
        return informationMap;
    }
}
