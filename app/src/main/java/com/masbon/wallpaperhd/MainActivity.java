package com.masbon.wallpaperhd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;



public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
//    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
//    private ViewPager mViewPager;
    private InterstitialAd mInter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdView adView2 = (AdView) findViewById(R.id.adView2);
//        InterstitialAd mInter = mInter.setAdUnitId(getString(R.string.intt));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        adView2.loadAd(adRequest);
//        mInter.loadAd(adRequest);
        createInterstitial();

        ImageButton btnImg = (ImageButton) findViewById(R.id.wall);
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();

            }
        });

    }

    public void createInterstitial() {
        mInter = new InterstitialAd(this);
        mInter.setAdUnitId(getString(R.string.intt)); // Ganti sesuai dengan kode interstitial ads anda
        loadInterstitial();
    }

    public void loadInterstitial() {
        AdRequest interstitialRequest = new AdRequest.Builder().build();
        mInter.loadAd(interstitialRequest);
    }

    public void showInterstitial() {
        if (mInter.isLoaded()) {
            mInter.show();
            mInter.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    // not call show interstitial ad from here
                }

                @Override
                public void onAdClosed() {
                    loadInterstitial();

                    ////////////////////////////////
                    Intent inte = new Intent(MainActivity.this, wallpaper.class);
                    startActivity(inte);
                    ////////////////////////////////
                }
            });
        } else {
            loadInterstitial();

            ////////////////////////////////
            Intent inte = new Intent(MainActivity.this, wallpaper.class);
            startActivity(inte);
            ////////////////////////////////
        }
    }
}