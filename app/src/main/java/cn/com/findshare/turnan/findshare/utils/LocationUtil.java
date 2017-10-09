package cn.com.findshare.turnan.findshare.utils;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import cn.com.findshare.turnan.findshare.AppCache;

/**
 * Created by lebro on 2017/10/3.
 */

public class LocationUtil {
    private static AMapLocationClient mapLocationClient;
    private static AMapLocationClientOption mapLocationClientOption;

    public static void initLocationUtil(Context context){
        if (mapLocationClient == null) {
            mapLocationClient = new AMapLocationClient(context);
            mapLocationClientOption = new AMapLocationClientOption();
            mapLocationClient.setLocationListener(new AMapLocationListener() {
                @Override
                public void onLocationChanged(AMapLocation aMapLocation) {
                    AppCache.USER_LAT = aMapLocation.getLatitude();
                    AppCache.USER_LNG = aMapLocation.getLongitude();
                }
            });
            mapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mapLocationClientOption.setInterval(2000);
            mapLocationClient.setLocationOption(mapLocationClientOption);
        }
    }

    public static void start() {
        if (mapLocationClient != null) {
            mapLocationClient.startLocation();
        }
    }

    public static void stop() {
        if (mapLocationClient != null) {
            mapLocationClient.stopLocation();
        }
    }

    public interface LocationListener {
        void locate();
    }
}
