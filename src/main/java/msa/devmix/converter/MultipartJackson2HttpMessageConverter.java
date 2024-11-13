package msa.devmix.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MultipartJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
    /**
     * "Content-Type: multipart/form-data" 헤더를 지원하는 HTTP 요청 변환기
     */
    public MultipartJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.APPLICATION_OCTET_STREAM);
    }
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    protected boolean canWrite(MediaType mediaType) {
        return false;
    }

//    /**
//     * "Content-Type: multipart/form-data" 헤더를 지원하는 HTTP 요청 변환기
//     */
//    public MultipartJackson2HttpMessageConverter(ObjectMapper objectMapper) {
//        // multipart/form-data를 처리하려면 "MediaType.MULTIPART_FORM_DATA"를 사용해야 합니다.
//        super(objectMapper, MediaType.MULTIPART_FORM_DATA);
//    }
//
//    @Override
//    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
//        // multipart/form-data를 처리하도록 설정
//        return mediaType != null && MediaType.MULTIPART_FORM_DATA.equals(mediaType);
//    }
//
//    @Override
//    public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
//        // multipart/form-data를 처리하도록 설정
//        return mediaType != null && MediaType.MULTIPART_FORM_DATA.equals(mediaType);
//    }
//
//    @Override
//    protected boolean canWrite(MediaType mediaType) {
//        // multipart/form-data를 처리하도록 설정
//        return mediaType != null && MediaType.MULTIPART_FORM_DATA.equals(mediaType);
//    }
}
