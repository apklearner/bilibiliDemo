package network;

import network.entity.HomeRecBannerEntity;
import network.entity.HomeRecContentEntity;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ly on 2017/2/22.
 */

public interface RecommandService {

    @GET("x/banner?plat=4&build=419000&channel=master")
    Observable<HomeRecBannerEntity> getBanners();

    @GET("x/show/old?access_key=d8b9703d7aa9d7127ed5b408bc92cea7&appkey=c1b107428d337928&build=419000&channel=master&mobi_app=android&platform=android&screen=xhdpi&ts=1487689918000&sign=fc031bc0b0774eadb5ae739af8d8bfbb")
    Observable<HomeRecContentEntity> getContents();
}
