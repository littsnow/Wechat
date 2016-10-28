package com.zain.common.entity;

/**
 * 成功结果集
 * @author zain
 * 16/10/27
 * @param <T>
 */
public class SuccessResult<T> extends SysResult {

    private T data;
    
    public SuccessResult() {}
    public SuccessResult(T data) {
        this.setData(data);
    }
    
    /**
     * 获取成功结果集
     * 带数据
     * @param data
     * @return
     */
    public static <T> SuccessResult<T> ok(T data) {
        return new SuccessResult<T>(data);
    }
    
    /**
     * 获取成功结果集
     * 不带数据
     * @param data
     * @return
     */
    public static SuccessResult<Void> ok() {
        return new SuccessResult<Void>();
    }
    
    @Override
    public boolean isOk() {
        return true;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

}
