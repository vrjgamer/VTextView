package com.vrjco.v.vtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by VRUSHABH on 19-09-2016.
 */
public class VFontCache {

    private static final String TAG = "VFontCache";
    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypefaceFromAssetName(String fontName, Context context) {
        Typeface typeface = fontCache.get(fontName);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
                e.printStackTrace();
                return null;
            }
            fontCache.put(fontName, typeface);
        }
        return typeface;
    }

    public static Typeface getTypefaceFromPath(String fontPath) {
        Typeface typeface = fontCache.get(fontPath);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromFile(fontPath);
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
                e.printStackTrace();
                return null;
            }

            fontCache.put(fontPath, typeface);
        }
        return typeface;
    }

    public static void clearCache() {
        fontCache.clear();
    }

}
