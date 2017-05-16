package com.monkey.testtextattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Description:
 * Author: lanjing
 * Time: 2017/5/16 11:46
 */

public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
        init(null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     *
     * @param attrs 这个参数不能少，否则得不到值
     */
    private void init(AttributeSet attrs) {
        //TypedArray typeArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyTextView,0,0);
        //TypedArray typeArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyTextView,android.R.attr.text,0);
        //TypedArray typeArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyTextView,0,R.style.myTextViewText2);
        TypedArray typeArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyTextView,android.R.attr.text,R.style.myTextViewText2);

        int textColor =  typeArray.getColor(R.styleable.MyTextView_myTextColor, Color.rgb(255,00,00));
        int textSize = typeArray.getDimensionPixelSize(R.styleable.MyTextView_myTextSize,20);
        String text = typeArray.getString(R.styleable.MyTextView_android_text);
        setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        setTextColor(textColor);
        setText(text);
        Log.e("MyTextView", "textColor: "+textColor+"  textSize:"+textSize+"  text:"+text);
        typeArray.recycle();

        test(attrs);
    }

    public void test(AttributeSet attrs){
        TypedArray typeArray = getContext().obtainStyledAttributes(attrs,new int[]{android.R.attr.layout_height});
        Log.e("MyTextView", "height:"+typeArray.getInt(0,0));

        TypedValue typeValue = new TypedValue();
        //getContext().getTheme().resolveAttribute(R.styleable.MyTextView_myTextSize,typeValue,true);
        boolean result = getContext().getTheme().resolveAttribute(android.R.attr.layout_height,typeValue,true);
        Log.e("MyTextView", "result:"+result+"  typeValue:"+typeValue.toString());
    }
}
