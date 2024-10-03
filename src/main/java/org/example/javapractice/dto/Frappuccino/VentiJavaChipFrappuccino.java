package org.example.javapractice.dto.Frappuccino;

import org.example.javapractice.Annotation.*;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "JavaChipFrappuccino", price = 7300)
@Drink(isCold = true, size = "Venti", ml = 591)
@NutritionInformation(kcal = 600, sodium = 330, saturatedFattyAcid = 14, sugar = 77, protein = 10, caffeine = 180)
@Frappuccino
public class VentiJavaChipFrappuccino implements GetInformation {

    public VentiJavaChipFrappuccino() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(VentiJavaChipFrappuccino.class);
        return informationMap;
    }
}
