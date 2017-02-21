package utils;

import network.BangumiService;
import network.LiveService;
import network.RecommandService;

/**
 * Created by ly on 2017/2/19.
 */

public class ApiGengder {

    public static LiveService getLiveService(){
        return ApiHelper.createApi(LiveService.class,ApiValues.LIVE_BASE_URL);
    }

    public static BangumiService getBangumiService(){
        return ApiHelper.createApi(BangumiService.class,ApiValues.BANGUMI_BASE_URL);

    }

    public static RecommandService getRecommandService(){
        return ApiHelper.createApi(RecommandService.class,ApiValues.APP_BASE_URL);

    }


}
