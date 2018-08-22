package app.contracts;

import java.lang.reflect.InvocationTargetException;

public interface SpecialityFactory {

    Specialty create(String speciality) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
