package com.masbon.wallpaperhd;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomPager extends Fragment{

    public static final String PAGE = "page";
    ViewGroup viewGroup ;
    ImageView imageView ;

    public CustomPager() {
// TODO Auto-generated constructor stub
    }

    public static CustomPager create(int page) {

        CustomPager customPager = new CustomPager();
        Bundle data = new Bundle();
        data.putInt(PAGE, page);
        customPager.setArguments(data);
        return customPager ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.wallset, container, false);
        imageView = (ImageView) viewGroup.findViewById(R.id.img_wallpaper);

        switch (getArguments().getInt(PAGE)) {

            case 0:
                imageView.setImageResource(R.drawable._1);
                break;
            case 1:
                imageView.setImageResource(R.drawable._2);
                break;
            case 2:
                imageView.setImageResource(R.drawable._3);
                break;
            case 3:
                imageView.setImageResource(R.drawable._4);
                break;
            case 4:
                imageView.setImageResource(R.drawable._5);
                break;
            case 5:
                imageView.setImageResource(R.drawable._5);
                break;
            case 6:
                imageView.setImageResource(R.drawable._5);
                break;
            case 7:
                imageView.setImageResource(R.drawable._5);
                break;

            default:
                break;
        }

        return viewGroup;
    }

}