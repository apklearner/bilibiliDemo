package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

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

    public  static void loadImg(Context context,String url,ImageView target){

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .centerCrop()
                .dontAnimate()
                .into(target);
    }

    public  static void loadImg(Context context, String url, ImageView target, Transformation<Bitmap> transfrom){

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .centerCrop()
                .bitmapTransform(transfrom)
                .dontAnimate()
                .into(target);
    }


}
