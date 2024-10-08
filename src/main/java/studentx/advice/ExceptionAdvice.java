package studentx.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import studentx.pojo.Result;

/**
 * 异常处理器
 *
 * @author HEX9CF
 * @date 2023/02/27
 */
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
       e.printStackTrace();
       return new Result(0, "服务器故障，请稍后重试", null);
    }
}
