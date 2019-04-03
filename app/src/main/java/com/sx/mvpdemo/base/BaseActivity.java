package com.sx.mvpdemo.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.sx.mvpdemo.R;
import com.sx.mvpdemo.app.App;
import com.sx.mvpdemo.utils.KL;

public abstract class BaseActivity extends AppCompatActivity {

    protected AppCompatActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KL.d(this.getClass(), this.getClass().getName() + "------>onCreate");
        init();
        setContentView(getLayout());
        getIntentData();
        mContext = this;

    }


    protected void init() {
        setTranslucentStatus(true);
    }



    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }


    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 处理Intent传递的值
     */
    protected abstract void getIntentData();

}
