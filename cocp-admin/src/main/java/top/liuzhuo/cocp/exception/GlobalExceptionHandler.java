package top.liuzhuo.cocp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.liuzhuo.cocp.enums.CommonEnum;
import top.liuzhuo.cocp.vo.CommonVo;

import java.util.Objects;

/**
 * 全局参数、异常拦截
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    /**
//     * 拦截表单参数校验
//     */
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler({BindException.class})
//    public CommonVo bindException(BindException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        return CommonVo.failed(ExceptionCodeEnum.VALIDATE_FAILED, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
//    }

    /**
     * 拦截JSON参数校验
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonVo bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return CommonVo.error(CommonEnum.VALIDATE_FAILED.getCode(),
                Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    /**
     * 拦截参数类型不正确
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public CommonVo bindException(HttpMediaTypeNotSupportedException e) {
        return CommonVo.error(CommonEnum.PRAM_NOT_MATCH.getCode(), Objects.requireNonNull(e.getMessage()));
    }


    //声明要捕获的异常
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public <T> CommonVo<?> defaultExceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof COCPException) {
            return CommonVo.error(CommonEnum.ERROR.getCode(), Objects.requireNonNull(e.getMessage()));
        }
        if (e instanceof MissingServletRequestParameterException) {
            return CommonVo.error(CommonEnum.PRAM_NOT_MATCH.getCode(), Objects.requireNonNull(e.getMessage()));
        }
        //未知错误
        return CommonVo.error(CommonEnum.ERROR.getCode(), e.getMessage());
    }
}
