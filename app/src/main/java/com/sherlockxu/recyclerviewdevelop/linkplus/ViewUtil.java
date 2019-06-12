package com.sherlockxu.recyclerviewdevelop.linkplus;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class ViewUtil {

    private ViewUtil() {
    }

    public static float getScreenRatio(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        if (displaymetrics.heightPixels > displaymetrics.widthPixels) {
            return (float) displaymetrics.heightPixels / displaymetrics.widthPixels;
        } else {
            return (float) displaymetrics.widthPixels / displaymetrics.heightPixels;
        }
    }

    /**
     * 将dp转换为px
     */
    public static float dpToPx(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * 将sp转换为px
     */
    public static int spToPx(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }

    public static int dpToPxInt(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
