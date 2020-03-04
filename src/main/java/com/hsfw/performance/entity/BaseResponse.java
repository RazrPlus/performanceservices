package com.hsfw.performance.entity;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回实体
 */
@Component
public class BaseResponse {
    /**
     * 成功时返回的数据
     */
    private  Object obj;
    /**
     * 返回状态
     */
    private  int code;
    /**
     * 返回msg
     */
    private  String message;
    /**
     * 其余参数
     */
    private  Map<String, Object> params;

    private BaseResponse() {
    }

    private BaseResponse(Object obj, int code, String message,
                         Map<String, Object> params) {
        this.obj = obj;
        this.code = code;
        this.message = message;
        this.params = params;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public static Builder buildResponse() {
        return new Builder();
    }
    /**
     *
     */
    public static final class Builder {
        private static final Map<Object, Object> NULL_OBJ = new HashMap<>();
        /**
         * 返回值
         */
        private  int retCode;
        /**
         * msg
         */
        private  String message;
        /**
         * 其他参数
         */
        private  Map<String, Object> params = new HashMap<>();
        /**
         * 数据对象
         */
        private Object obj;

        private Builder() { }

        /**
         * 添加参数信息
         *
         * @param key
         * @param value
         * @return
         */
        public Builder addParam(final String key, final Object value) {
            this.params.put(key, value);
            return this;
        }

        public Builder setCode(int code) {
            this.retCode=code;
            return this;
        }
        public Builder setCode(ResponseCode code) {
            this.retCode=code.getCode();
            this.message=code.getMsg();
            return this;
        }
        public Builder setCode(ResponseCode code,String msg) {
            this.retCode=code.getCode();
            this.message=msg;
            return this;
        }
        public Builder setMessage(String message) {
            this.message=message;
            return this;
        }

        /**
         * 设置result obj
         *
         * @param obj
         * @return
         */
        public Builder setObj(final Object obj) {
            if (obj!=null&& !ObjectUtils.isEmpty(obj)) {
                this.obj = obj;
                this.retCode = 200;
                this.message = "请求成功";
                return this;
            }else {
                this.obj = obj;
                this.message="无数据";
                this.retCode=404;
                return this;
            }
        }
        /**
         * build BaseResponse
         *
         * @return
         */
        public BaseResponse build() {
            return new BaseResponse(this.obj == null ? NULL_OBJ : this.obj,this.retCode, this.message, this.params);
        }
    }
}
