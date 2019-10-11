package com.reinfo.ipoly.common.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author quanhong_deng
 * @since 1.0
 * Date 18-10-8
 */

public class KyroUtil {

    public static byte[] serializer(Object obj) {
        Kyrox kryo = new Kyrox();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Output output = new Output(outputStream);
        kryo.writeClassAndObject(output,obj);
        output.close();
        return outputStream.toByteArray();
    }

    public static Object deserializer(byte[] bytes) {
        if(bytes==null){
            return null;
        }
        Kyrox kryo = new Kyrox();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        Input input = new Input(inputStream);
        return kryo.readClassAndObject(input);
    }
}
