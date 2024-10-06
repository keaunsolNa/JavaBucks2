package org.example.javapractice.dto.Drink.Espresso;

public class IcedCaffeAmericano extends CaffeAmericano {

    public IcedCaffeAmericano () {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(IcedCaffeAmericano.class);
    }
}
