package com.vrjco.v.vtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by VRUSHABH on 19-09-2016.
 */
public class VButtonView extends Button {

    private static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";
    private static final String TAG = "VButtonView";

    public VButtonView(Context context) {
        super(context, null);
    }

    public VButtonView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public VButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.fontManager);
            if (array != null) {
                String fontName = array.getString(R.styleable.fontManager_fontName);
                if (fontName != null) {
                    setCustomFontFromAssetsName(context, fontName);
                    array.recycle();
                    return;
                }
            }
            int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", defStyleAttr);
            setAppDefaultTypeface(context, textStyle);
        } else
            setAppDefaultTypeface(context, VFontManager.STYLE_NORMAL);
    }

    private void setAppDefaultTypeface(Context context, int style) {

        Log.d(TAG, "default font: " + VFontManager.DEFAULT_NORMAL);

        switch (style) {
            case VFontManager.STYLE_NORMAL:
                if (VFontManager.DEFAULT_NORMAL == null) {
                    return;
                }
                this.setTypeface(VFontManager.getCustomFontFromAssetName(context, VFontManager.DEFAULT_NORMAL));
                break;
            case VFontManager.STYLE_BOLD:
                if (VFontManager.DEFAULT_BOLD == null) {
                    return;
                }
                this.setTypeface(VFontManager.getCustomFontFromAssetName(context, VFontManager.DEFAULT_BOLD));
                break;
            case VFontManager.STYLE_ITALIC:
                if (VFontManager.DEFAULT_ITALIC == null) {
                    return;
                }
                this.setTypeface(VFontManager.getCustomFontFromAssetName(context, VFontManager.DEFAULT_ITALIC));
                break;
            case VFontManager.STYLE_BOLD_ITALIC:
                if (VFontManager.DEFAULT_BOLD_ITALIC == null) {
                    return;
                }
                this.setTypeface(VFontManager.getCustomFontFromAssetName(context, VFontManager.DEFAULT_BOLD_ITALIC));
                break;
            default:
                if (VFontManager.DEFAULT_NORMAL == null) {
                    return;
                }
                this.setTypeface(VFontManager.getCustomFontFromAssetName(context, VFontManager.DEFAULT_NORMAL));
        }
    }

    public void setCustomFontFromAssetsName(@NonNull Context context, @NonNull String fontName) {
        Typeface typeface = VFontManager.getCustomFontFromAssetName(context, fontName);
        if (typeface != null) {
            this.setTypeface(typeface);
        }
    }


}
