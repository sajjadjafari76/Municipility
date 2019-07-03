package www.municipality.ir.takestanmunicipality;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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

        String info = null;
        if (getIntent().getExtras() != null) {
            info = getIntent().getExtras().getString("info");
        }

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
//                    webView.loadUrl("http://www.takestancity.ir/HomePage.aspx?TabID=4660&Site=DouranPortal&Lang=fa-IR");
                    webView.loadUrl("http://137.takestancity.ir");
                    break;
//                case "5":
//                    webView.loadUrl("http://137.takestancity.ir");
//                    break;
            }
        }



    }

    private class MyCustomBrowser extends WebViewClient {

        private ProgressDialog progressBar;

        MyCustomBrowser(ProgressDialog progressBar) {
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
