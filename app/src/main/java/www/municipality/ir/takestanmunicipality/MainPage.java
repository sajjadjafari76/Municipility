package www.municipality.ir.takestanmunicipality;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.q42.android.scrollingimageview.ScrollingImageView;

public class MainPage extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private KenBurnsView image;
    private ImageView logo;
    private boolean doubleBackToExitPressedOnce, state = true;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        FloatingActionButton button = findViewById(R.id.MainPage_Btn);
        final FloatingActionButton sound = findViewById(R.id.MainPage_Sound);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state) {
                    mediaPlayer.pause();
                    sound.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_speaker));
                    state = false;
                    Log.e("status", "true");
                }else {
                    mediaPlayer.start();
                    sound.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_speaker1));
                    state = true;
                    Log.e("status", "false");
                }
            }
        });


//        image = findViewById(R.id.MainPage_Image);
        logo = findViewById(R.id.MainPage_Logo);
//
//        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.slide);
//        image.setAnimation(animSlide);

        RandomTransitionGenerator generator = new
                RandomTransitionGenerator(5000L, new DecelerateInterpolator());
//        image.setTransitionGenerator(generator);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(4000);

        logo.setAnimation(scaleAnimation);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.toro);
        mediaPlayer.start();

        Log.e("timestamo", mediaPlayer.getTimestamp().getMediaClockRate() + " | "
        + mediaPlayer.getTimestamp().getAnchorMediaTimeUs() + " | " +
        mediaPlayer.getTimestamp().getAnchorSytemNanoTime());

        ScrollingImageView scrollingBackground = findViewById(R.id.MainPage_Image);
//        scrollingBackground.stop();
        scrollingBackground.start();

//        Animation _translateAnimation;
//        ImageView _image; _image = findViewById(R.id.MainPage_Image);
//        _translateAnimation = new TranslateAnimation(TranslateAnimation.ABSOLUTE, 0f,
//                TranslateAnimation.ABSOLUTE, 1000f, TranslateAnimation.ABSOLUTE, 0f, TranslateAnimation.ABSOLUTE, 0f);
//        _translateAnimation.setDuration(5000); _translateAnimation.setRepeatCount(-1);
//        _translateAnimation.setRepeatMode(Animation.REVERSE); _translateAnimation.setInterpolator(new LinearInterpolator());
//        _image.setAnimation(_translateAnimation);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }


    @Override
    public void onBackPressed() {

        if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "جهت خروج دکمه برگشت را مجددا کلیک کنید!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            startActivity(new Intent(getApplicationContext(), Exit_Page.class));
            finish();
        }

    }
}
