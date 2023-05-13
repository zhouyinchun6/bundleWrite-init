package com.zyc.bundle.inject;


import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * author Zyc on date 2022/11/3
 * <p>
 * description: bundle构建参数类
 */
public class BundleBuild {

    private final Bundle bundle;

    private BundleBuild() {
        bundle = new Bundle();
    }

    public static BundleBuild newBuild() {
        return new BundleBuild();
    }

    public BundleBuild put(String name, boolean value) {
        bundle.putBoolean(name, value);
        return this;
    }

    public BundleBuild put(String name, int value) {
        bundle.putInt(name, value);
        return this;
    }

    public BundleBuild put(String name, long value) {
        bundle.putLong(name, value);
        return this;
    }

    public BundleBuild put(String name, float value) {
        bundle.putFloat(name, value);
        return this;
    }

    public BundleBuild put(String name, double value) {
        bundle.putDouble(name, value);
        return this;
    }

    public BundleBuild put(String name, String value) {
        bundle.putString(name, value);
        return this;
    }

    public BundleBuild put(String name, Serializable value) {
        bundle.putSerializable(name, value);
        return this;
    }

    public BundleBuild put(String name, Parcelable value) {
        bundle.putParcelable(name, value);
        return this;
    }

    /**
     * 返回bundle
     */
    public Bundle build() {
        return bundle;
    }

}
