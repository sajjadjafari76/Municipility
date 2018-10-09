package www.municipality.ir.takestanmunicipality.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import www.municipality.ir.takestanmunicipality.R;

public class CustomButton extends Button {


    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context,attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context,attrs);
    }


    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray array = ctx.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        String Font = array.getString(R.styleable.CustomTextView_Font);
        setCustomFont(ctx, Font);
        array.recycle();
    }

    private boolean setCustomFont(Context ctx, String asset) {
        Typeface typeface;
        try {
            typeface = Typeface.createFromAsset(ctx.getAssets(), asset);
        }catch (Exception c) {
            return false;
        }
        setTypeface(typeface);
        return true;
    }

}
