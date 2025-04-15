package org.gestorvuelos;

class Utils {
    public static <T> T[] addElementToArray(T[] array, T element) {
        
        T[] temp = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length + 1);
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        temp[temp.length - 1] = element;
        array = temp;
        
        return array;
    }
}