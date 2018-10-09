package www.municipality.ir.takestanmunicipality;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebView_Electronic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view__electronic);

        WebView webView = findViewById(R.id.WebView_webview);
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setMessage("لطفا صبر کنید!!");

        webView.setWebViewClient(new MyCustomBrowser(progressBar));
        webView.setInitialScale(100);
        webView.getSettings().setBuiltInZoomControls(true);

        String info = getIntent().getExtras().getString("info");
//        Toast.makeText(this, info + " |", Toast.LENGTH_SHORT).show();
        if (info != null) {
            switch (info) {
                case "1":
                    Log.e("sajjad",webView.getProgress() + " |");
                    webView.loadUrl("http://www.takestancity.ir/HomePage.aspx?TabID=4657&Site=DouranPortal&Lang=fa-IR");
                    break;
                case "2":
                    webView.loadUrl("http://www.takestancity.ir/HomePage.aspx?TabID=4658&Site=DouranPortal&Lang=fa-IR");
                    break;
                case "3":
                    webView.loadUrl("http://www.takestancity.ir/HomePage.aspx?TabID=4659&Site=DouranPortal&Lang=fa-IR");
                    break;
                case "4":
                    webView.loadUrl("http://www.takestancity.ir/HomePage.aspx?TabID=4660&Site=DouranPortal&Lang=fa-IR");
                    break;
                case "5":
                    webView.loadUrl("http://stit.ir/samaneh/");
                    break;
            }
        }



    }

    private class MyCustomBrowser extends WebViewClient {

        private ProgressDialog progressBar;

        public MyCustomBrowser(ProgressDialog progressBar) {
            this.progressBar = progressBar;
            progressBar.show();
        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.dismiss();
            progressBar.cancel();

        }
    }
}