package ms.drunkdiary.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import ms.drunkdiary.R;

/**
 * Created by orc12 on 2015-12-01.
 */
public class SplashActivity extends Activity {

    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove titlebar
        setContentView(R.layout.activity_splash);
        h= new Handler();
        h.postDelayed(mrun, 1000); //delay
    }

    Runnable mrun = new Runnable(){
        @Override
        public void run(){
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            //fade in,out
        }
    };

    //set back button
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        h.removeCallbacks(mrun);
    }
}