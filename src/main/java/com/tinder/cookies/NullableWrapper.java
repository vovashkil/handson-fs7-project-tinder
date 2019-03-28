package com.tinder.cookies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

public final class NullableWrapper<T> {
    /**
     * variable to store original value
     */
    private final T[] origin;

    /**
     * primary constructor which consumes any typed array
     *
     * @param raw - typed array of source data
     */
    @SuppressWarnings("PMD.UseVarargs")
    public NullableWrapper(final T[] raw) {
        this.origin = raw == null ? null : raw.clone();
    }

    /**
     * @param <L> any connection which is convenient to use
     * @return Collection where initial values stored
     */
    public <L extends Collection<T>> L get() {
        return get(ArrayList::new);
    }

    @SuppressWarnings("unchecked")
    public <L extends Collection<T>> L get(final Supplier<? extends Collection<T>> supplier) {
        final Collection<T> c = supplier.get();
        if (origin != null) {
            c.addAll(Arrays.asList(origin));
        }
        return (L) c;
    }
}
