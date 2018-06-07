package com.masbon.wallpaperhd;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.masbon.wallpaperhd.viewPagerAdapter;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

import java.io.IOException;

public class wallActivity extends FragmentActivity implements OnClickListener {

    ViewPager viewPager ;
    Button buttonKiri, buttonKanan, buttonSet;
    com.masbon.wallpaperhd.viewPagerAdapter viewPagerAdapter;
    int page = 0 ;
    WallpaperManager wallpaperManager ;
    Bitmap bitmap1, bitmap2 ;
    DisplayMetrics displayMetrics ;
    int width, height;
    BitmapDrawable bitmapDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        initObject();

        initComponentViews();

        initConfigurationView();

        initOnImplementsView();




    }

    private void initObject(){
        viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
    }

    private void initComponentViews(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        buttonKiri = (Button) findViewById(R.id.btn_previous);
        buttonKanan = (Button) findViewById(R.id.btn_next);
        buttonSet = (Button) findViewById(R.id.btn_OK);
        wallpaperManager  = WallpaperManager.getInstance(getApplicationContext());

        bitmapDrawable = (BitmapDrawable) wallpaperManager.getDrawable();

        bitmap1 = bitmapDrawable.getBitmap();

    }

    private void initConfigurationView(){
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initOnImplementsView(){
        buttonKiri.setOnClickListener(this);
        buttonKanan.setOnClickListener(this);
        buttonSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_previous:

                page -= 1;

                viewPager.setCurrentItem(page);
                if (page<=0) {
                    buttonKiri.setVisibility(Button.INVISIBLE);
                }else{
                    buttonKiri.setVisibility(Button.VISIBLE);
                }
                if (page==7) {
                    buttonKanan.setVisibility(Button.VISIBLE);
                }
                break;

            case R.id.btn_next:
                page += 1;
                viewPager.setCurrentItem(page);

                if (page>= com.masbon.wallpaperhd.viewPagerAdapter.PAGER_LENGTH) {
                    buttonKanan.setVisibility(Button.INVISIBLE);
                }else{
                    buttonKiri.setVisibility(Button.VISIBLE);
                }
                if (page==1) {
                    buttonKiri.setVisibility(Button.VISIBLE);
                }
                break;
            case R.id.btn_OK:
                GetScreenWidthHeight();

                SetBitmapSize();

                wallpaperManager = WallpaperManager.getInstance(wallActivity.this);

                try {

                    wallpaperManager.setBitmap(bitmap2);

                    wallpaperManager.suggestDesiredDimensions(width, height);


                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            default:
                break;
        }
    }
    public void GetScreenWidthHeight(){

        displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        width = displayMetrics.widthPixels;

        height = displayMetrics.heightPixels;

    }

    public void SetBitmapSize(){

        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width, height, false);

    }
}