package network;


import network.entity.HomeBangumiMainEntity;
import network.entity.HomeBangumiRecEntity;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ly on 2017/2/21.
 */

public interface BangumiService {

    @GET("api/app_index_page_v2?access_key=d8b9703d7aa9d7127ed5b408bc92cea7&appkey=c1b107428d337928&build=419000&mobi_app=android&platform=android&ts=1487669183000&sign=64bd0f21b500c9861ba2e648409b2244")
    Observable<HomeBangumiMainEntity> getHomeBangumiMain();

    @GET("api/bangumi_recommend?appkey=c1b107428d337928&build=419000&cursor=-1&mobi_app=android&pagesize=10&platform=android&ts=1487670593000&sign=07a012103b6d0393428c7859c08255fe")
    Observable<HomeBangumiRecEntity> getHomeBangumiRec();
}
