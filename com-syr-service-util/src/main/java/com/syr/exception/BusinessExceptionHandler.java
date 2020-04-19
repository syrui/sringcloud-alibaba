package com.syr.exception;


import com.syr.module.base.eum.ErrorCode;
import com.syr.module.base.result.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


/**
 * 业务异常处理基类
 * Created by frt on 2017/11/22.
 */
@Slf4j
@ControllerAdvice
public class BusinessExceptionHandler extends BaseExceptionHandler {

    /**
     * 数据校验异常捕捉（save 时或者进行方法校验时）
     * 在调用 save 方法进行数据保存时，由于对象还处于游离状态，数据校验发生在事务提交前，
     * 当数据校验不通过时，抛出的异常为 javax.validation.ConstraintViolationException，
     * 通过这个异常处理方法，捕捉并解析异常信息，把友好的异常信息返回给调用者
     * @param e 异常信息
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public BaseResponse handleViolationException(ConstraintViolationException e) {
        StringBuilder errMsg = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for(ConstraintViolation<?> violation : violations){
            errMsg.append(",");
            errMsg.append(violation.getMessage());
        }

        if(errMsg.length()>0){
            errMsg.deleteCharAt(0);
        }

        return handleBaseYxResponse(ErrorCode.SYS_VALIDATION_ERROR.getCode(), errMsg.toString());
    }




}
