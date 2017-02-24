package network;

import network.entity.HotTagEntity;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ly on 2017/2/23.
 */

public interface HotTagService {

    @GET("main/hotword?access_key=ec0f54fc369d8c104ee1068672975d6a&actionKey=appkey&appkey=27eb53fc9058f8c3")
    Observable<HotTagEntity> getHotTags();
}


