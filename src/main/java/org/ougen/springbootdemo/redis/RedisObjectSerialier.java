package org.ougen.springbootdemo.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

/**
 * Author: OuGen
 * Discription:
 * Date: 23:50 2019/7/17
 */
@Component
public class RedisObjectSerialier implements RedisSerializer<Object> {
    private Converter<Object,byte[]>  serializer= new SerializingConverter();
    private Converter<byte[],Object> deserializer = new DeserializingConverter();
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return deserializer.convert(bytes);
    }
}
