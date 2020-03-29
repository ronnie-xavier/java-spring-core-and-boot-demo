package cloud.itsu.springbootdemo.exception.handler;

import cloud.itsu.springbootdemo.exception.TvSeriesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionAdviceHandler {

    @ResponseBody
    @ExceptionHandler(TvSeriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String tvSeriesNotFoundExceptionAdviceHandler(TvSeriesNotFoundException ex) {
        return ex.getMessage();
    }
}
