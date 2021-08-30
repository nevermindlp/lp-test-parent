package lp.ser.jackson.test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import lp.ser.jackson.entity.CommonEntity;

public class JacksonSerDeserTest {

    private static ObjectMapper mapper = new ObjectMapper();

    private static ObjectMapper deMapper = new ObjectMapper();

    public static void main(String[] args) {
        CommonEntity commonEntity = new CommonEntity();
        commonEntity.setName("test");
        String json = "";
        try {
            json = mapper.writeValueAsString(commonEntity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            CommonEntity deSerValue = mapper().readValue(json, CommonEntity.class);
            System.out.println(deSerValue);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private static ObjectMapper mapper() {
//        // copy object mapper
//        ObjectMapper mapper1 = new ObjectMapper();
//        mapper1.setDefaultSetterInfo(JsonSetter.Value.forContentNulls(Nulls.AS_EMPTY));
//        SimpleModule module = new SimpleModule();
//        mapper1.registerModule(module);
//        mapper1.setSerializationInclusion(JsonInclude.Include.ALWAYS);
//        mapper1.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper1.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        mapper1.enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
//        mapper1.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        mapper1.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        mapper1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return mapper1;
//    }

    private static ObjectMapper derMapper() {
        // copy object mapper
        ObjectMapper deMapper = new ObjectMapper();

        deMapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        deMapper.disable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
//        deMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        DeserializationConfig deserializationConfig = deMapper.getDeserializationConfig();
        return deMapper;
    }


    private static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString("");
            }
        });
        return mapper;
    }
}
