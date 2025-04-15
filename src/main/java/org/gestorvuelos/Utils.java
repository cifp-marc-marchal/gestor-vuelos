package org.gestorvuelos;

class Utils {

        // Añadir elemento genérico a un array
        public static <T> T[] addElementToArray(T[] array, T element) {
            T[] temp = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length + 1);
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            temp[temp.length - 1] = element;
            return temp;
        }

        // Eliminar un elemento por índice del array (genérico)
        public static <T> T[] removeElementFromArray(T[] array, int index) {
            if (index < 0 || index >= array.length) {
                return array; // índice no válido, devuelve el array sin cambios
            }

            T[] temp = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length - 1);
            for (int i = 0, j = 0; i < array.length; i++) {
                if (i != index) {
                    temp[j++] = array[i];
                }
            }
            return temp;
        }
    }
