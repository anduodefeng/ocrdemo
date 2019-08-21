package com.example.nio.netty.rpc.registry;

import com.example.nio.netty.rpc.message.InvokeMsg;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//处理整个注册中心的业务逻辑
public class MyHandler extends ChannelInboundHandlerAdapter {

    //存储注册中心的多个服务
    public Map<String, Object> serverMap = Maps.newHashMap();

    //扫描包名存放 默认扫描 com.example.nio.netty.rpc.provider;
    public List<String> classCache = Lists.newArrayList();

    public MyHandler() {
        scanClass("");
        doRregister();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        Object result = new Object();

        //客户端传过来的调用信息
        InvokeMsg request = (InvokeMsg) msg;
        if(serverMap.containsKey(request.getClassName())){
            Object clazz = serverMap.get(request.getClassName());
            Method method = clazz.getClass().getMethod(request.getMethodName(), request.getParams());
            result = method.invoke(clazz, request.getValues());
        }

        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /** *
     * Description: 扫描包下面的类
     * Author: maze
     * Date: 2019/8/21 17:48
     * Params: [packageName]
     * Return: void
     **/
    private void scanClass(String packageName){
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File file = new File(Objects.requireNonNull(url).getFile());
        for(File file1 : Objects.requireNonNull(file.listFiles())){
            if(file1.isDirectory()){
                scanClass(packageName+"."+file1.getName());
            }else{
                String className = packageName+"."+file1.getName().replace(".class","").trim();
                classCache.add(className);
            }
        }
    }

    /** *
     * Description: 实例化类，注册到map中，
     * Author: maze
     * Date: 2019/8/21 17:49
     * Params: []
     * Return: void
     **/
    private void doRregister(){
        if(classCache.size() == 0) return;

        for(String className : classCache){
            try {
                //clazz是接口的实现类
                Class<?> clazz = Class.forName(className);
                //服务名称，接口名称; 可能会继承多个接口，只取第一个接口就可以；
                Class<?> interfaces = clazz.getInterfaces()[0];

                //map的key是接口的名称，vlaue是接口的具体的实现类
                serverMap.put(interfaces.getName(), clazz.newInstance());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
