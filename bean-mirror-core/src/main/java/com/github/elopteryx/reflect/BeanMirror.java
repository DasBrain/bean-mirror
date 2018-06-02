package com.github.elopteryx.reflect;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.Objects;

/**
 * The entry point for creating mirror instances.
 * They can be created from a plain object or from a class type.
 * The class instances are immutable.
 */
public final class BeanMirror {

    private BeanMirror() {
        // No need to instantiate.
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a new mirror instance, wrapping the given object.
     * @param object The object to be wrapped
     * @param <T> The generic type
     * @return A new mirror instance
     */
    public static <T> ObjectMirror<T> of(T object) {
        return of(object, MethodHandles.lookup());
    }

    /**
     * Creates a new mirror instance, wrapping the given object.
     * @param object The object to be wrapped
     * @param lookup User-supplied lookup for access check
     * @param <T> The generic type
     * @return A new mirror instance
     */
    public static <T> ObjectMirror<T> of(T object, Lookup lookup) {
        Objects.requireNonNull(object);
        Objects.requireNonNull(lookup);
        return new ObjectMirror<>(object, null, lookup);
    }

    /**
     * Creates a new mirror instance, wrapping the given class object.
     * @param clazz The class to be wrapped
     * @param <T> The generic type
     * @return A new mirror instance
     */
    public static <T> ClassMirror<T> of(Class<T> clazz) {
        return of(clazz, MethodHandles.lookup());
    }

    /**
     * Creates a new mirror instance, wrapping the given class object.
     * @param clazz The class to be wrapped
     * @param lookup User-supplied lookup for access check
     * @param <T> The generic type
     * @return A new mirror instance
     */
    public static <T> ClassMirror<T> of(Class<T> clazz, Lookup lookup) {
        Objects.requireNonNull(clazz);
        Objects.requireNonNull(lookup);
        return new ClassMirror<>(clazz, lookup);
    }

}
