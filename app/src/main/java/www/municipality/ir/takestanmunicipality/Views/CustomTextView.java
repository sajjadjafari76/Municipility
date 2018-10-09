package www.municipality.ir.takestanmunicipality.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import www.municipality.ir.takestanmunicipality.R;

/**
 * Created by sajjadnet on 11/16/2017.
 */

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context,attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context,attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setCustomFont(context,attrs);
    }


    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray array = ctx.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        try {
            setCustomFont(ctx);
        }finally {
            invalidate();
            requestLayout();
            array.recycle();
        }
    }

    private boolean setCustomFont(Context ctx) {
        setTypeface(CFProvider.getIRANIANSANS(ctx));
        return true;
    }

}
