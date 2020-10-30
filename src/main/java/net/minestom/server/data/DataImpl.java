package net.minestom.server.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link Data} implementation which uses a {@link ConcurrentHashMap}.
 */
public class DataImpl implements Data {

    protected final ConcurrentHashMap<String, Object> data = new ConcurrentHashMap<>();

    @Override
    public <T> void set(@NotNull String key, @Nullable T value, @Nullable Class<T> type) {
        if (value != null) {
            this.data.put(key, value);
        } else {
            this.data.remove(key);
        }
    }

    @Override
    public <T> T get(@NotNull String key) {
        return (T) data.get(key);
    }

    @Override
    public <T> T getOrDefault(@NotNull String key, T defaultValue) {
        return (T) data.getOrDefault(key, defaultValue);
    }

    @Override
    public boolean hasKey(@NotNull String key) {
        return data.containsKey(key);
    }

    @NotNull
    @Override
    public Set<String> getKeys() {
        return Collections.unmodifiableSet(data.keySet());
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @NotNull
    @Override
    public Data clone() {
        DataImpl data = new DataImpl();
        data.data.putAll(this.data);
        return data;
    }

}
