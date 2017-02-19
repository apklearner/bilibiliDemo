package network;

import network.entity.HomeLiveEntity;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ly on 2017/2/19.
 */

public interface LiveService {

    @GET("AppIndex/home?_device=android&_hwid=51e96f5f2f54d5f9&_ulv=10000&access_key=563d6046f06289cbdcb472601ce5a761&appkey=c1b107428d337928&build=410000&platform=android&scale=xxhdpi&sign=fbdcfe141853f7e2c84c4d401f6a8758")
    Observable<HomeLiveEntity> getHomeLiveInfo();

}
