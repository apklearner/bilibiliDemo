package utils;

import network.LiveService;

/**
 * Created by ly on 2017/2/19.
 */

public class ApiGengder {

    public static LiveService getLiveService(){
        return ApiHelper.createApi(LiveService.class,ApiValues.LIVE_BASE_URL);
    }


}
