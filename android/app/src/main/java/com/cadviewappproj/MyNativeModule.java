package com.cadviewappproj;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.app.Activity;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class MyNativeModule extends ReactContextBaseJavaModule {

    public static final String REACTCLASSNAME = "MyNativeModule";
    private Context mContext;

    public MyNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    /**
     * 必须重写该方法 该方法的返回值就是js中调用的民称
     * @return
     */
    @Override
    public String getName() {
        return REACTCLASSNAME;
    }

    /**
     * 必须添加反射注解不然会报错
     * 这个方法就是ReactNative将要调用的方法，会通过此类名字调用
     * @param msg
     */
    @ReactMethod
    public void callNativeMethod(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        //startActivityForResult(myIntent, 1);
    }
    @ReactMethod
    public void startActivityByString(String fileUrl){
        try {
            Activity currentActivity = getCurrentActivity();
            if (null != currentActivity) {
                Intent intent = new Intent(currentActivity, MxCADAppActivity.class);
                intent.putExtra("file",fileUrl);
                //currentActivity.startActivity(intent);
                //currentActivity.startActivityForResult(intent,0);
            }
        } catch (Exception e) {
            Toast.makeText(mContext, "错误了", Toast.LENGTH_SHORT).show();
        }
    }
}