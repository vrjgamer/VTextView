package com.vrjco.v.vtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by VRUSHABH on 19-09-2016.
 */
public class VFontManager {

    public static final int STYLE_NORMAL = Typeface.NORMAL;
    public static final int STYLE_BOLD = Typeface.BOLD;
    public static final int STYLE_ITALIC = Typeface.ITALIC;
    public static final int STYLE_BOLD_ITALIC = Typeface.BOLD_ITALIC;
    private static final String TAG = "VFontManager";

    public static String DEFAULT_NORMAL = null;
    public static String DEFAULT_BOLD = null;
    public static String DEFAULT_ITALIC = null;
    public static String DEFAULT_BOLD_ITALIC = null;

    public static void logDefaultFontNames() {
        Log.d(TAG, "normal: " + DEFAULT_NORMAL);
        Log.d(TAG, "bold: " + DEFAULT_BOLD);
        Log.d(TAG, "italic: " + DEFAULT_ITALIC);
        Log.d(TAG, "bold_italic: " + DEFAULT_BOLD_ITALIC);
    }

    public static void setDefaultAppFont(String fontName) {
        if (DEFAULT_NORMAL == null) {
            DEFAULT_NORMAL = fontName;
        }
    }

    public static void setDefaultAppFont(String fontName, int style) {
        switch (style) {
            case STYLE_NORMAL:
                if (DEFAULT_NORMAL == null) {
                    DEFAULT_NORMAL = fontName;
                }
                break;
            case STYLE_BOLD:
                if (DEFAULT_BOLD == null) {
                    DEFAULT_BOLD = fontName;
                }
                break;
            case STYLE_ITALIC:
                if (DEFAULT_ITALIC == null) {
                    DEFAULT_ITALIC = fontName;
                }
                break;
            case STYLE_BOLD_ITALIC:
                if (DEFAULT_BOLD_ITALIC == null) {
                    DEFAULT_BOLD_ITALIC = fontName;
                }
                break;
        }
    }

    public static Typeface getCustomFontFromAssetName(@NonNull Context context, @NonNull String fontName) throws NullPointerException {
        Typeface typeface;
        if (!fontName.isEmpty()) {
            typeface = VFontCache.getTypefaceFromAssetName(fontName, context);
        } else {
            return getCustomFontFromAssetName(context, DEFAULT_NORMAL);
        }
        if (typeface == null)
            throw new NullPointerException("Font Not Found!");
        else
            return typeface;
    }

    public void clearCache() {
        VFontCache.clearCache();
    }

}
