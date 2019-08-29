package com.ssonsoft.ttcounter;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class HistoryActivity extends AppCompatActivity {
    /*private TickerView numPalyHome;
    private TickerView numPalyAway;
    private TickerView numSetHome;
    private TickerView numSetAway;
    private int plHomeCnt = 0;
    private int plAwayCnt = 0;
    private int setHomeCnt = 0;
    private int setAwayCnt = 0;
    private long pressTime = 0;
    private TextView mTxtSetCnt;
    private ImageView imvSvPl;
    private ImageView imvSvAw;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ttcnt);
        inItUiSet();    //화면구성 셋팅
    }

    public void inItUiSet(){
        /*numPalyHome = findViewById(R.id.num_paly_home);
        numPalyAway = findViewById(R.id.num_paly_away);
        numSetHome = findViewById(R.id.num_set_home);
        numSetAway = findViewById(R.id.num_set_away);
        mTxtSetCnt = findViewById(R.id.txt_set_cnt);
        imvSvPl = findViewById(R.id.imv_sv_pl);
        imvSvAw = findViewById(R.id.imv_sv_aw);*/
    }
}
