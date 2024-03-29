package www.municipality.ir.takestanmunicipality.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import www.municipality.ir.takestanmunicipality.R;


public class CustomEdittext extends AppCompatEditText {

    public CustomEdittext(Context context) {
        super(context);
    }

    public CustomEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context,attrs);
    }

    public CustomEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context,attrs);
    }

//    public CustomEdittext(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        setCustomFont(context,attrs);
//    }

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

    private void setCustomFont(Context ctx) {
        setTypeface(CFProvider.getIRANIANSANS(ctx));
    }

}
