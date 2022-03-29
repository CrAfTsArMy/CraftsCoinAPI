package de.craftsarmy.coinapi.api.classes;

import java.lang.reflect.InvocationTargetException;

public class Touch<E> {

    public E touch(Class<? extends E> clazz, Object... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor().newInstance(args);
    }

}
