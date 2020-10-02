package cloud.itsu.springbootdemo.configuration;

import cloud.itsu.springbootdemo.controller.TvSeriesController;
import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<TvSeriesEntity> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("In supports() method of " + getClass().getSimpleName());
        return returnType.getContainingClass() == TvSeriesController.class && returnType.getParameterType() == TvSeriesEntity.class;
    }

    @Override
    public TvSeriesEntity beforeBodyWrite(TvSeriesEntity entity, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        System.out.println("In beforeBodyWrite() method of " + getClass().getSimpleName());

        entity.setName((entity.getName() + " by Spring"));
        return entity;
    }
}
