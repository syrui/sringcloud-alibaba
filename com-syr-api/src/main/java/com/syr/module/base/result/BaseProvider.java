package com.syr.module.base.result;



/**
 * Created by frt on 2017/11/22.
 */
public class BaseProvider {

    protected BaseResponse handleSuccess(Object data){
        BaseResponse response = new BaseResponse();
        response.setHasException(false);
        response.setErrCode("0");
        response.setData(data);
        return response;
    }

    protected BaseResponse handleError(String msg){
        BaseResponse response = new BaseResponse();
        response.setHasException(true);
        response.setErrCode("0");
        response.setErrMsg(msg);
        return response;
    }
    protected BaseResponse handleSuccess(){
       return handleSuccess(null);
    }
}
