package com.jdroid.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhaolinlin on 14-9-28.
 * zhaolinlin02@meituan.com
 */
public class JEventBus {

    static JEventBus s_JEventBus = new JEventBus();

    ArrayList<EventReceivers> mCalls;

    static public JEventBus getDefault(){
        return s_JEventBus;
    }

    public JEventBus(){
        mCalls = new ArrayList<EventReceivers>();
    }

    public void register(Object obj){

        if (obj == null){
            throw new NullPointerException("register obj must be not null.");
        }

        Class<?> cl = obj.getClass();
        Method[] methods = cl.getMethods();
        for (int i = 0; i < methods.length; i++){
            Method method = methods[i];
            String name = method.getName();
            if (name.startsWith("onJEvent")){
                //find
                Class paramType = method.getParameterTypes()[0];
                put(paramType, obj);
            }
        }

    }

    public void unRegister(Object find){
        for (EventReceivers receiver : mCalls){
            receiver.receiver.remove(find);
        }
    }

    public void post(Object event){

        try{
            for (EventReceivers receiver : mCalls){
                if (receiver.eventType.getName().equals(event.getClass().getName())){
                    if (receiver.receiver.size() > 0) {
                        Method method = receiver.receiver.get(0).getClass().getMethod("onJEvent", event.getClass());
                        for (Object obj : receiver.receiver) {
                            method.invoke(obj, event);
                        }
                    }
                    break;
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void put(Class eventType, Object obj){
        boolean find = false;
        for (EventReceivers receiver : mCalls){
            if (receiver.eventType.getName().equals(eventType.getName())){
                receiver.receiver.add(obj);
                find = true;
                break;
            }
        }

        if (!find){
            EventReceivers receiver = new EventReceivers();
            receiver.eventType = eventType;
            receiver.receiver.add(obj);
            mCalls.add(receiver);
        }
    }


    static final class EventReceivers{
        Class eventType;
        ArrayList<Object> receiver;

        EventReceivers(){
            receiver = new ArrayList<Object>();
        }
    }
}
