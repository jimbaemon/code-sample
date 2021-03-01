package me.jimbae.demoinflearnrestapi.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;

import java.io.IOException;

/**
 * Errors 는 Bean Spec 을 따르지 않기 때문에 response body 를 통한 JSON 변환이 안된다.
 * JsonSerializer 로 Serialize 작업을 진행
 */

@JsonComponent
public class ErrorsSerializer extends JsonSerializer<Errors> {
    @Override
    public void serialize(Errors errors, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        errors.getFieldErrors().forEach(e ->{
            try{
                jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField("field", e.getField());
                    jsonGenerator.writeStringField("objectName", e.getObjectName());
                    jsonGenerator.writeStringField("code", e.getCode());
                    jsonGenerator.writeStringField("defaultMessage", e.getDefaultMessage());
                    Object rejectValue = e.getRejectedValue();
                    if(rejectValue != null){
                        jsonGenerator.writeStringField("rejectedValue", rejectValue.toString());
                    }
                jsonGenerator.writeEndObject();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        });

        errors.getGlobalErrors().forEach(e ->{
            try{
                jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField("objectName", e.getObjectName());
                    jsonGenerator.writeStringField("code", e.getCode());
                    jsonGenerator.writeStringField("defaultMessage", e.getDefaultMessage());
                jsonGenerator.writeEndObject();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        });
        jsonGenerator.writeEndArray();
    }
}
