package com.vrjco.v.vtextviewdemo;

import android.app.Application;

import com.vrjco.v.vtextview.VFontManager;

/**
 * Created by VRUSHABH on 19-09-2016.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VFontManager.setDefaultAppFont("avenir_normal.ttf", VFontManager.STYLE_NORMAL);
        VFontManager.setDefaultAppFont("avenir_bold.ttf", VFontManager.STYLE_BOLD);
        VFontManager.setDefaultAppFont("avenir_italic.ttf", VFontManager.STYLE_ITALIC);

    }
}
