package com.example.nio.netty.rpc.message;

/** *
 * Description: 传递消息规范
 * ClassName: InvokeMsg
 * Author: maze
 * Date: 2019/8/21 18:21
 **/
public class InvokeMsg {

    private String className;   //服务名称
    private String methodName;  //方法名称
    private Class<?> params;    //参数列表
    private Object[] values;    //参数值

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?> getParams() {
        return params;
    }

    public void setParams(Class<?> params) {
        this.params = params;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
