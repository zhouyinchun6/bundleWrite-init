package com.zyc.bundle.inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author Zyc on date 2022/11/11
 * <p>
 * description: 自动获取Bundle值;
 * * 支持int、long、float、double、boolean、String、Serializable、Parcelable参数注解；
 * * :1、可设置默认值如：@WriteBundle  String str = "默认值";
 * * :2、不能被 private修饰, 否则编译会报错
 * * :3、kotlin代码还需加@JvmField（编译器不生成get、set方法并将其桌位字段公开）,否则读不到值；如 @JvmField @WriteBundle var str = "默认值"
 */
public class BundleInit {


    public static <T extends Activity> void inject(T activity) {
        injectBundle(activity, activity.getIntent().getExtras());
    }

    public static <T extends Fragment> void inject(T fragment) {
        injectBundle(fragment, fragment.getArguments());
    }

    public static void inject(Object obj, Intent intent) {
        injectBundle(obj, intent.getExtras());
    }

    public static void inject(Object obj, Bundle bundle) {
        injectBundle(obj, bundle);
    }


    private static void injectBundle(Object obj, Bundle bundle) {
        String className = obj.getClass().getName();
        try {
            //要与生成的java类和方法的名字保持一致
            Class<?> clazz = Class.forName(className + "$$BundleInit");
            Method method = clazz.getMethod("injectBundle", obj.getClass(), Bundle.class);
            method.invoke(clazz, obj, bundle);
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                SecurityException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
