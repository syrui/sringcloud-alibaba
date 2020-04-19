package com.syr.exception;


import com.syr.module.base.result.BaseResponse;
import com.syr.module.base.result.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常处理基类
 */
public class BaseExceptionHandler {
    private static final Logger logger = LogManager.getLogger(BaseExceptionHandler.class);

    /**
     * 构建异常消息响应对象
     * @param errCode       异常编码
     * @param errMsg        异常消息
     * @return
     */
    protected BaseResponse handleBaseYxResponse(String errCode, String errMsg){
        logger.error(errMsg);
        BaseResponse response = new BaseResponse();
        response.setHasException(true);
        response.setErrCode(errCode);
        response.setErrMsg(errMsg);
        return response;
    }

    /**
     * 自定义业务异常捕捉
     * @param e 异常信息
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public BaseResponse handleBusinessException(BusinessException e) {
        return handleBaseYxResponse(e.getErrCode(), e.getErrMsg());
    }
}
