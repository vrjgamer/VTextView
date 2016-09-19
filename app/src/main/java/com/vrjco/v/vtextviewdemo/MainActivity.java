package com.vrjco.v.vtextviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vrjco.v.vtextview.VButtonView;
import com.vrjco.v.vtextview.VTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VTextView tv = (VTextView) findViewById(R.id.tv4);
        tv.setCustomFontFromAssetsName(this, "custom_font.otf");

        VButtonView b1 = (VButtonView) findViewById(R.id.b1);
        b1.setCustomFontFromAssetsName(this, "custom_font2.ttf");

        VButtonView b2 = (VButtonView) findViewById(R.id.b2);
        b2.setCustomFontFromAssetsName(this, "custom_font3.ttf");

        try {
            VButtonView b3 = (VButtonView) findViewById(R.id.b3);
            b3.setCustomFontFromAssetsName(this, "custom_font4.ttf");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
