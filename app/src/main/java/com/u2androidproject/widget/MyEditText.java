package com.u2androidproject.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.u2androidproject.R;


/**
 * Created by cuilibao on 2017/6/19.
 */

public class MyEditText extends EditText {
    //drawable
    private Drawable drawable;

    public MyEditText(Context context) {
        super(context);
        init(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    private void init(Context context) {
        //初始化
        drawable = context.getResources().getDrawable(R.mipmap.editdel_delete);

        //显示或者隐藏
        //有文字 获取到了焦点
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //改变之前
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //改变时
            }

            @Override
            public void afterTextChanged(Editable s) {
                //改变后
                //String result = s.toString();
                showPic();
            }
        });

        //焦点的监听
        setOnFocusChangeListener(new OnFocusChangeListener() {
            /**
             *
             * @param v
             * @param hasFocus  有焦点 返回true
             *
             */
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                showPic();
            }
        });

    }

    public void showPic() {
        int length = getText().toString().length();
        if (length > 0 && hasFocus()) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        } else {
            setCompoundDrawables(null, null, null, null);

        }
        //设置小图片的点击事件

    }

    /**
     * 获取View触摸事件
     *
     * @param event
     * @return 事件的拦截和分发机制
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
//                //获取按下的坐标点
//                int x = (int) event.getRawX();
//                int y = (int) event.getRawY();
//                Rect rect = new Rect();
//                //获取有一个矩形区域 没有宽高
//                getGlobalVisibleRect(rect);
//                //撑开
//                rect.left = rect.right - 150;
//
//                if (rect.contains(x, y)) {
//                    //按下的区域正好落在矩形区域内
//                    //文字消失
//                    setText("");
//                }


                if (getCompoundDrawables()[2] != null) {
                    boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                            && (event.getX() < ((getWidth() - getPaddingRight())));
                    if (touchable) {
                        this.setText("");
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
