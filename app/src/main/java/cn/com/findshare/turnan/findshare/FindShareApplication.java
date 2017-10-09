package cn.com.findshare.turnan.findshare;

import android.app.Application;

import cn.com.findshare.turnan.findshare.utils.LocationUtil;

/**
 * Created by lebro on 2017/10/3.
 */

public class FindShareApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LocationUtil.initLocationUtil(this);
    }
}
