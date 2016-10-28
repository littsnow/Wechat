package com.zain.common.entity;

/**
 * 失败结果集
 * @author zain
 * 16/10/27
 */
public class ErrorResult extends SysResult {
    
    private int errCode;
    private String errMsg;
    
    public ErrorResult() {}
    public ErrorResult(int errCode, String errMsg) {
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
    }
    
    /**
     * 返回错误结果集
     * 不带错误信息
     * @return
     */
    public static ErrorResult err() {
        return new ErrorResult();
    }
    
    /**
     * 返回错误结果集
     * 带错误信息
     * @return
     */
    public static ErrorResult err(int errCode, String errMsg) {
        return new ErrorResult(errCode, errMsg);
    }
    
    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public boolean isOk() {
        return false;
    }
}
