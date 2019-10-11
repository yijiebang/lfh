package com.reinfo.ipoly.common.serializer;

import com.esotericsoftware.kryo.Kryo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author quanhong_deng
 * @since 1.0
 * Date 18-10-8
 */

public class Kyrox extends Kryo {

    private static Logger logger = LoggerFactory.getLogger(Kyrox.class);

    @SuppressWarnings("restriction")
    private final ReflectionFactory REFLECTION_FACTORY = ReflectionFactory.getReflectionFactory();

    private final ConcurrentHashMap<Class<?>, Constructor<?>> _constructors =
            new ConcurrentHashMap<Class<?>, Constructor<?>>();

    @Override
    public <T> T newInstance(Class<T> type) {
        try {
            return super.newInstance(type);
        } catch (Exception e) {
//            logger.warn("newInstance", e);
            try {
                return (T) newInstanceFromReflectionFactory(type);
            }catch (Exception e1) {
                logger.error("newInstance", e1);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T newInstanceFromReflectionFactory(Class<T> type) {
        Constructor<?> constructor = _constructors.get(type);
        if (constructor == null) {
            constructor = newConstructorForSerialization(type);
            Constructor<?> saved = _constructors.putIfAbsent(type, constructor);
            if (saved != null)
                constructor = saved;
        }
        return (T) newInstanceFrom(constructor);
    }

    private Object newInstanceFrom(Constructor<?> constructor) {
        try {
            return constructor.newInstance();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> Constructor<?> newConstructorForSerialization(Class<T> type) {
        try {
            Constructor<?> constructor =
                    REFLECTION_FACTORY.newConstructorForSerialization(type, Object.class.getDeclaredConstructor());
            constructor.setAccessible(true);
            return constructor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
