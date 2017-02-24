package utils;

import network.BangumiService;
import network.HotTagService;
import network.LiveService;
import network.RecommandService;
import network.VideDetailService;

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

    public static HotTagService getHotTagService(){
        return ApiHelper.createApi(HotTagService.class,ApiValues.SEARCH_BASE_URL);
    }

    public static VideDetailService getVideoDetailService(){
        return ApiHelper.createApi(VideDetailService.class,ApiValues.APP_BASE_URL);
    }


}
