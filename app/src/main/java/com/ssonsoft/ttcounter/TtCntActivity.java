package com.ssonsoft.ttcounter;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.robinhood.ticker.TickerView;

public class TtCntActivity extends AppCompatActivity {
    private TickerView numPalyHome;
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
    private ImageView imvSvAw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ttcnt);
        inItUiSet();    //화면구성 셋팅
    }

    public void inItUiSet(){
        numPalyHome = findViewById(R.id.num_paly_home);
        numPalyAway = findViewById(R.id.num_paly_away);
        numSetHome = findViewById(R.id.num_set_home);
        numSetAway = findViewById(R.id.num_set_away);
        mTxtSetCnt = findViewById(R.id.txt_set_cnt);
        imvSvPl = findViewById(R.id.imv_sv_pl);
        imvSvAw = findViewById(R.id.imv_sv_aw);
    }

    public void inItScore(boolean allYn) {
        plHomeCnt = 0;
        plAwayCnt = 0;
        numPalyHome.setText("00");
        numPalyAway.setText("00");
        if(allYn){
            setHomeCnt = 0;
            setAwayCnt = 0;
            numSetHome.setText("0");
            numSetAway.setText("0");
        }
    }

    public void homeScoreAdd() {
        if(plHomeCnt > 9){
            numPalyHome.setText(plHomeCnt+"");
        }else{
            numPalyHome.setText("0"+plHomeCnt);
        }
    }

    public void awayScoreAdd() {
        if(plAwayCnt > 9){
            numPalyAway.setText(plAwayCnt+"");
        }else{
            numPalyAway.setText("0"+plAwayCnt);
        }
    }

    //홈팀 점수 더하기
    public void addHomeCnt(View view) {
        if (System.currentTimeMillis() > pressTime + 300) {     //한번터치 점수 더하기
            pressTime = System.currentTimeMillis();
            plHomeCnt++;
            //11점이 되면 셋트 스코어를 올린다 (듀스계산11점일때 상대방과 2점차이상이 되어야 한다.)
            if(plHomeCnt > 10){
                if((plHomeCnt - plAwayCnt) > 1){    //셋트스코어 인정
                    inItScore(false);    //점수 초기화
                    setHomeCnt++;
                    if(setHomeCnt < 3){
                        numSetHome.setText(setHomeCnt+"");
                        mTxtSetCnt.setText((setHomeCnt+setAwayCnt+1)+"-SET");
                    }else{
                        numSetHome.setText(setHomeCnt+"");
                        //TODO 등록후 초기화
                        inItScore(true);    //점수 초기화
                    }
                }else{
                    homeScoreAdd();
                }
            }else{
                homeScoreAdd();
            }
            return;
        }
        if (System.currentTimeMillis() <= pressTime + 300) {    //두번터치 점수 빼기
            if(plHomeCnt < 2){
                Toast.makeText(getApplicationContext(),"0점 이하는 표시할 수 없습니다.",Toast.LENGTH_SHORT).show();
                plHomeCnt = 0;
                numPalyHome.setText("00");
            }else{
                plHomeCnt--;
                plHomeCnt--;
                if(plHomeCnt > 9){
                    numPalyHome.setText(plHomeCnt+"");
                }else{
                    numPalyHome.setText("0"+plHomeCnt);
                }
            }
        }
    }

    //원정팀 점수 더하기
    public void addAwayCnt(View view) {

        if (System.currentTimeMillis() > pressTime + 300) {     //한번터치 점수 더하기
            pressTime = System.currentTimeMillis();
            plAwayCnt++;
            //11점이 되면 셋트 스코어를 올린다 (듀스계산11점일때 상대방과 2점차이상이 되어야 한다.)
            if(plAwayCnt > 10){
                if((plAwayCnt - plHomeCnt) > 1){    //셋트스코어 인정
                    inItScore(false);    //점수 초기화
                    setAwayCnt++;
                    if(setAwayCnt < 3){
                        numSetAway.setText(setAwayCnt+"");
                        mTxtSetCnt.setText((setHomeCnt+setAwayCnt+1)+"-SET");
                    }else{
                        numSetAway.setText(setAwayCnt+"");
                        //TODO 등록후 초기화
                        inItScore(true);    //점수 초기화
                    }
                }else{
                    awayScoreAdd();
                }
            }else{
                awayScoreAdd();
            }
            return;
        }
        if (System.currentTimeMillis() <= pressTime + 300) {    //두번터치 점수 빼기
            if(plAwayCnt < 2){
                Toast.makeText(getApplicationContext(),"0점 이하는 표시할 수 없습니다.",Toast.LENGTH_SHORT).show();
                plAwayCnt = 0;
                numPalyAway.setText("00");
            }else{
                plAwayCnt--;
                plAwayCnt--;
                if(plAwayCnt > 9){
                    numPalyAway.setText(plAwayCnt+"");
                }else{
                    numPalyAway.setText("0"+plAwayCnt);
                }
            }
        }
    }

    //홈팀 셋트 점수 더하기
    public void delPlayCnt(View view) {

    }

    //원정팀 셋트 점수 더하기
    public void delAwayCnt(View view) {
    }
}
