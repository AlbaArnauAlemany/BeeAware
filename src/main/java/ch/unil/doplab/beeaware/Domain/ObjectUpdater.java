package ch.unil.doplab.beeaware.Domain;

import java.lang.reflect.Field;

public class ObjectUpdater {

    public static <T> void updateNonNullFields(T source, T target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source and target objects must not be null");
        }

        Class<?> clazz = source.getClass();

        try {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                Object sourceValue = field.get(source);
                if (sourceValue != null) {
                    field.set(target, sourceValue);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error updating fields", e);
        }
    }
}