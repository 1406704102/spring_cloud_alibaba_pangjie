package com.result;


/**
 * 返回结果工具类
 *
 * @author lili
 */
public class ResultUtil<T> {

    /**
     * 抽象类，存放结果
     */
    private final Result<T> result;
    /**
     * 正常响应
     */
    private static final Integer SUCCESS = 200;


    /**
     * 构造话方法，给响应结果默认值
     */
    public ResultUtil() {
        result = new Result<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(SUCCESS);
    }

    /**
     * 返回数据
     *
     * @param t 范型
     * @return 消息
     */
    public Result<T> setData(T t) {
        this.result.setData(t);
        return this.result;
    }


    /**
     * 返回成功消息
     *
     * @param resultCode 返回码
     * @return 返回成功消息
     */
    public Result<T> setSuccessMsg(ResultCode resultCode) {
        this.result.setSuccess(true);
        this.result.setMessage(resultCode.getMessage());
        this.result.setCode(resultCode.getCode());
        return this.result;

    }

    /**
     * 抽象静态方法，返回结果集
     *
     * @param t   范型
     * @param <T> 范型
     * @return 消息
     */
    public static <T> Result<T> data(T t) {
        return new ResultUtil<T>().setData(t);
    }

    /**
     * 返回成功
     *
     * @param resultCode 返回状态码
     * @return 消息
     */
    public static <T> Result<T> success(ResultCode resultCode) {
        return new ResultUtil<T>().setSuccessMsg(resultCode);
    }

    /**
     * 返回成功
     *
     * @return 消息
     */
    public static <T> Result<T> success() {
        return new ResultUtil<T>().setSuccessMsg(ResultCode.OK);
    }

    /**
     * 返回失败
     *
     * @param resultCode 返回状态码
     * @return 消息
     */
    public static <T> Result<T> error(ResultCode resultCode) {
        return new ResultUtil<T>().setErrorMsg(resultCode);
    }

    public static <T> Result<T> error() {
        return new ResultUtil<T>().setErrorMsg(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
    }

    /**
     * 返回失败
     *
     * @param msg 返回消息
     * @return 消息
     */
    public static <T> Result<T> error(String msg) {
        return new ResultUtil<T>().setErrorMsg(ResultCode.FAIL.getCode(), msg);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }

    /**
     * 服务器异常 追加状态码
     *
     * @param resultCode 返回码
     * @return 消息
     */
    public Result<T> setErrorMsg(ResultCode resultCode) {
        this.result.setSuccess(false);
        this.result.setMessage(resultCode.getMessage());
        this.result.setCode(resultCode.getCode());
        return this.result;
    }

    /**
     * 服务器异常 追加状态码
     *
     * @param code 状态码
     * @param msg  返回消息
     * @return 消息
     */
    public Result<T> setErrorMsg(Integer code, String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code);
        return this.result;
    }

}
