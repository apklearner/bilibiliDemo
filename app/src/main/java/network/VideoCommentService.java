package network;

import network.entity.VideoReplyEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ly on 2017/2/25.
 */

public interface VideoCommentService {

    @GET("x/reply?_device=android&_hwid=9b79e5045a78136c&_ulv=10000&access_key=d8b9703d7aa9d7127ed5b408bc92cea7&appkey=c1b107428d337928&build=419000&mobi_app=android&platform=android&sort=0&type=1&sign=60ecc21edb9e9cbf7c0aacb9f909f096")
    Observable<VideoReplyEntity> getVideoReply(@Query("oid") String oid,@Query("pn") String pn,@Query("ps") String ps);

}
