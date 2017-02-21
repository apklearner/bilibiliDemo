package network;

import network.entity.HomeLiveEntity;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ly on 2017/2/19.
 */

public interface LiveService {

    @GET("AppIndex/home?_device=android&_hwid=9b79e5045a78136c&_ulv=10000&access_key=d8b9703d7aa9d7127ed5b408bc92cea7&appkey=c1b107428d337928&build=419000&mobi_app=android&platform=android&scale=xhdpi&sign=361f7bcfcf92c9ed66ee15e4b202dba3")
    Observable<HomeLiveEntity> getHomeLiveInfo();

}
