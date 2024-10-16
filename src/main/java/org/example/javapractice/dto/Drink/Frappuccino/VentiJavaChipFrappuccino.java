package org.example.javapractice.dto.Drink.Frappuccino;

import org.example.javapractice.Annotation.*;

@Menu(name = "JavaChipFrappuccino", price = 7300)
@Drink(isCold = true, size = "Venti", ml = 591)
@NutritionInformation(kcal = 600, sodium = 330, saturatedFattyAcid = 14, sugar = 77, protein = 10, caffeine = 180)
@Frappuccino
public class VentiJavaChipFrappuccino extends JavaChipFrappuccino {

    public VentiJavaChipFrappuccino() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(VentiJavaChipFrappuccino.class);
    }
}
