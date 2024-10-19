package org.example.javapractice.dto.Drink.Frappuccino;

import org.example.javapractice.Annotation.*;

@Menu(name = "JavaChipFrappuccino", price = 7300)
@Drink(isCold = true, size = "Venti", ml = 591, icedOnly = true)
@NutritionInformation(kcal = 600, sodium = 330, saturatedFattyAcid = 14, sugar = 77, protein = 10, caffeine = 180)
@Frappuccino
public class VentiIcedJavaChipFrappuccino extends JavaChipFrappuccino {

    public VentiIcedJavaChipFrappuccino() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(VentiIcedJavaChipFrappuccino.class);
    }
}
