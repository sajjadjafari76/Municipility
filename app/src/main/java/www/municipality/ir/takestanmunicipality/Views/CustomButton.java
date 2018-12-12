package www.municipality.ir.takestanmunicipality.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import www.municipality.ir.takestanmunicipality.R;

public class CustomButton extends AppCompatButton {


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

    private void setCustomFont(Context ctx, String asset) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(ctx.getAssets(), asset);
        }catch (Exception c) {
            c.printStackTrace();
        }
        setTypeface(typeface);
    }

}
