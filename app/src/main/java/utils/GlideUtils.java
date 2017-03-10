package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import bilibili.demoforbilibili.R;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by ly on 2017/2/23.
 */

public class GlideUtils {

    public static ThreadLocal<Boolean> whetherLoad ;

    public static void loadImg(Context context,String url,ImageView target,boolean load){
        if(load){
            loadImg(context,url,target);
        }
    }


    public static void loadImgWidthDefaultCorner(Context context,String url,ImageView target){
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CenterCrop(context),new RoundedCornersTransformation(context,context.getResources().getDimensionPixelSize(R.dimen.live_card_radius),0, RoundedCornersTransformation.CornerType.TOP))
                .dontAnimate()
                .into(target);
    }

    public  static void loadImg(Context context,String url,ImageView target){

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .dontAnimate()
                .into(target);
    }

    public  static void loadImg(Context context, String url, ImageView target, Transformation<Bitmap> transfrom){

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .bitmapTransform(transfrom)
                .dontAnimate()
                .into(target);

    }


    public static void loadImg(Context context,String url,ImageView target,int width,int height,boolean skip){
        url =TextUtils.isEmpty(url)?"":url;
        DrawableRequestBuilder requestBuilder = Glide.with(context)
                .load(url)
                .skipMemoryCache(skip)
                .placeholder(R.drawable.ic_launcher)
                .dontAnimate();
        if(width >0 && height >0){
            requestBuilder.override(width,height);
        }
        requestBuilder.into(target);

    }

}
