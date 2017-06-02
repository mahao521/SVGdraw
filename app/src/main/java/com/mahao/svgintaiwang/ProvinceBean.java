package com.mahao.svgintaiwang;

import android.content.Context;

import java.io.InputStream;

/**
 * Created by mahao on 17/6/1.
 */

public class ProvinceBean {


    private String path;
    private boolean isSelcet;
    private Context context;

    public ProvinceBean (){


        this.context = context;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSelcet() {
        return isSelcet;
    }

    public void setSelcet(boolean selcet) {
        isSelcet = selcet;
    }

    //解析raw文件
    public void getRawXmlBean{


        InputStream inputStream = context.getResources().openRawResource(R.raw.taiwanhigh);

        //使用不同的方式解析xml


    }


}






