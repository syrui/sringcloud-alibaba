package com.syr.module.base.result;


import com.syr.module.base.eum.ErrorCode;

import java.io.Serializable;

/**
 * Created by frt on 2017/11/22.
 */
public class BusinessException  extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public BusinessException() {

    }
    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BusinessException(String errCode, String errMsg, Object... variables) {
        this.errCode = errCode;
        this.errMsg = (variables!=null && variables.length>0)?String.format(errMsg, variables):errMsg ;
    }

    public BusinessException(ErrorCode error, Object... variables) {
        super((variables!=null && variables.length>0)?String.format(error.getErrorMSg(), variables):error.getErrorMSg());
        this.errCode = error.getCode();
        this.errMsg = (variables!=null && variables.length>0)?String.format(error.getErrorMSg(), variables):error.getErrorMSg() ;
    }

}
