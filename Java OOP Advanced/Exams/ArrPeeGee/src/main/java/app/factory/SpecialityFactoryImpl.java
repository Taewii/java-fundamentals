package app.factory;


import app.contracts.SpecialityFactory;
import app.contracts.Specialty;

import java.lang.reflect.InvocationTargetException;

public class SpecialityFactoryImpl implements SpecialityFactory {

    private static final String PATH = "app.models.specialties.";

    @Override
    public Specialty create(String speciality) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        return (Specialty) Class.forName(PATH + speciality).getDeclaredConstructor().newInstance();
    }
}
