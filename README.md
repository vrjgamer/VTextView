#[![](https://jitpack.io/v/vrjgamer/VTextView.svg)](https://jitpack.io/#vrjgamer/VTextView)
# VTextView

[!["Screenshot1"](https://github.com/vrjgamer/VTextView/blob/master/snapshots/Screenshot_2016-09-19-16-37-34.png)](https://github.com/vrjgamer/VTextView/blob/master/snapshots/Screenshot_2016-09-19-16-37-34.png)

####Custom Android TextView to set Custom fonts for the whole App

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisities
minimum sdk version should be API 10

### To Add this library

To add this library to your project, you need to follow the following steps: 

###  People using gradle
    
* Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
      allprojects {
    		repositories {
    			...
    			maven { url "https://jitpack.io" }
    		}
    	}
```
    
* Step 2. Add the dependency
```
      dependencies {
    	        compile 'com.github.vrjgamer:VTextView:1.0'
    	}
```

###  People using maven

* Step 1. Add the JitPack repository to your build file
```
      <repositories>
    		<repository>
    		    <id>jitpack.io</id>
    		    <url>https://jitpack.io</url>
    		</repository>
    	</repositories>
    
```
  * Step 2. Add the dependency
```
      <dependency>
    	    <groupId>com.github.vrjgamer</groupId>
    	    <artifactId>VTextView</artifactId>
    	    <version>1.0</version>
    	</dependency>
```

### To Use this Library

To setup default font for your full project:

  * Add all your fonts to assets folder.
  
  * Create an Application class and Add the following code to make a default app font for the overall projects: 
``` 
      public class App extentds Application{
        ...
          @Override
          public void onCreate() {
              super.onCreate();
              ...
              VFontManager.setDefaultAppFont(<Font-Name>);
              //example
              //VFontManager.setDefaultAppFont("avenir_italic.ttf");
              ...
          }
      }
```
or you could add particular fonts for each style:
  
 ``` 
      public class App extentds Application{
        ...
          @Override
          public void onCreate() {
              super.onCreate();
              ...
              VFontManager.setDefaultAppFont(<font-name>, VFontManager.STYLE_NORMAL);
              VFontManager.setDefaultAppFont(<font-name>, VFontManager.STYLE_BOLD);
              //example
              //VFontManager.setDefaultAppFont("avenir_italic.ttf", VFontManager.STYLE_ITALIC);
              ...
          }
      }
```
* To use VTextView 
Add to layout in your xml
``` 
  ...
    <com.vrjco.v.vtextview.VTextView
        android:id="@+id/tv"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        android:text="@string/demo_text"
        android:textColor="#000"
        android:textSize="17dp" />
  ...
```
If you don't specify a fontName in the xml, it will use the default font assigned in the application class.
If you specify a fontName, it will use it as a custom font.
```
  ...
  <com.vrjco.v.vtextview.VTextView
        android:id="@+id/tv"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        android:text="@string/demo_text"
        android:textColor="#000"
        android:textSize="17dp"
        app:fontName="custom_font.ttf"
        />
  ...
```
* To set Custom Font from your activity do this:
```
  ...
  VTextView tv = (VTextView) findViewById(R.id.tv);
  //example: setCustomFontFromAssetsName(<context>, <font-name>);
  tv.setCustomFontFromAssetsName(this, "custom_font.otf");
  ...
```

* You can also use the VButtonView packaged in the library, to use a button with custom fonts:
```
  <com.vrjco.v.vtextview.VButtonView
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="Button"
        android:textColor="#000"
        android:textSize="25dp"
        android:background="#b2b2b2"
        android:layout_margin="10dp"
        android:gravity="center" />
```
in your activity:
```
  VButtonView button = (VButtonView) findViewById(R.id.button);
  //example: setCustomFontFromAssetsName(<context>, <font-name>);
  button.setCustomFontFromAssetsName(this, "custom_font3.ttf");
```






