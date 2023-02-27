package stux.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author HEX9CF
 * @date 2023/02/27
 */
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doException(Exception e){
       e.printStackTrace();
       return new R("服务器故障，请稍后重试");
    }


}
