package com.ipk.handbookforrun;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by LF on 2016/10/7.
 */

public class WeekActivity extends Activity implements View.OnClickListener{
    String[] weekContents={"第1周：步伐\n\n第1课（34分钟)\n跑步1分钟，行走2分钟，做8次。\n第2课（28分钟）\n跑步1分钟，行走2分钟，做6次。\n第3课（31分钟)\n跑步1分钟，行走2分钟，做7次\n",
              "第2周：建立基础\n\n第1课（38分钟)\n跑步2分钟，行走2分钟，做7次。\n第2课（31分钟）\n跑步1分钟，行走2分钟，做7次。\n第3课（34分钟）\n跑步2分钟，行走2分钟，做6次\n",
              "第3周：增加跑步的时间\n\n第1课（45分钟）\n跑步3分钟，行走2分钟，做7次。\n第2课（34分钟）\n跑步2分钟，行走2分钟，做6次。\n第3课（40分钟）\n跑步3分钟，行走2分钟，做6次。\n",
              "第4周：轻松的恢复周\n\n第1课（40分钟）\n跑步3分钟，行走2分钟，做6次。\n第2课（30分钟）\n跑步2分钟，行走2分钟，做5次。\n第3课（40分钟）\n跑步2分钟，行走3分钟，做6次。\n " ,
              "第5周：注意“拖着脚跑步”\n\n第1课（46分钟）\n跑步3分钟，行走1分钟，做9次。\n第2课（34分钟）\n跑步2分钟，行走1分钟，做8次。\n第3课（42分钟）\n跑步3分钟，行走1分钟，做8次。\n" ,
              "第6周：增加训练量\n\n第1课（52分钟）\n跑步5分钟，行走1分钟，做7次。\n第2课（38分钟）\n跑步3分钟，行走1分钟，做7次。\n第3课（50分钟）\n跑步3分钟，行走1分钟，做10次。\n ",
              "第7周：训练过了一半\n\n第1课（54分钟或者5000米距离）\n跑步10分钟，行走1分钟，做4次。\n或者按这个模式完成5000米。\n第2课（40分钟）\n跑步4分钟，行走1分钟，做6次。\n第3课（52分钟）\n跑步5分钟，行走1分钟，做7次。\n " ,
            "第8周：轻松的恢复周\n\n第1课（54分钟）\n跑步10分钟，行走1分钟，做4次。\n第2课（38分钟）\n跑步3分钟，行走1分钟，做7次。\n第3课（46分钟）\n跑步5分钟，行走1分钟，做6次。\n " ,
            "第9周：回到训练中\n\n第1课（69分钟）\n跑步10分钟，行走1分钟。\n跑步15分钟，行走1分钟。\n跑步20分钟，行走1分钟。\n跑步10分钟，行走1分钟。\n第2课（46分钟）\n跑步5分钟，行走1分钟，做6次。\n第3课（54分钟）\n跑步10分钟，行走1分钟，做4次。\n " ,
            "第10周：漫长的一周\n\n第1课（73分钟）\n跑步10分钟，行走1分钟。\n跑步20分钟，行走1分钟。\n跑步30分钟，行走1分钟。\n第2课（54分钟）\n跑步10分钟，行走1分钟，做4次。\n第3课（58分钟）\n跑步20分钟，行走1分钟。\n跑步15分钟，行走1分钟。\n跑步10分钟，行走1分钟。\n " ,
            "第11周：树立信心\n\n第1课（71分钟）\n跑步40分钟，行走1分钟。\n跑步20分钟\n第2课（54分钟）\n跑步10分钟，行走1分钟，做4次。\n第3课（58分钟）\n跑步20分钟，行走1分钟。\n跑步15分钟，行走1分钟。\n跑步10分钟，行走1分钟。\n "  ,
            "第12周：轻松的一周\n\n第1课（61分钟）\n跑步50分钟,行走1分钟。\n第2课（43分钟）\n跑步10分钟，行走1分钟，做3次。\n第3课（53分钟）\n跑步15分钟，行走1分钟。\n跑步15分钟，行走1分钟。\n跑步10分钟，行走1分钟。\n" ,
            "第13周：祝贺！\n\n第1课（51分钟）\n跑步40分钟,行走1分钟。\n第2课（43分钟）\n跑步10分钟，行走1分钟，做3次。\n第3课\n10公里：享受乐趣，注意别跑太快\n"
    };
    private TextView mTv1;
    /*
    * 特别的：9周1课，12周3课,待特别定制
    *
    * 每一组四个数据的意义分别是:跑步分钟，步行分钟，重复次数，跑步分钟等差变化值
    * */
    private int[][][] mPlan=new int[][][]{
            {{1,2,8,0},{1,2,6,0},{1,2,7,0}},
            {{2,2,7,0},{1,2,7,0},{2,2,6,0}},
            {{3,2,7,0},{2,2,6,0},{3,2,6,0}},
            {{3,2,6,0},{2,2,5,0},{2,3,6,0}},
            {{3,1,9,0},{2,1,8,0},{3,1,8,0}},
            {{5,1,7,0},{3,1,7,0},{3,1,10,0}},
            {{10,1,4,0},{4,1,6,0},{5,1,7,0}},
            {{10,1,4,0},{3,1,7,0},{5,1,6,0}},
            {{10,1,4,5},{5,1,6,0},{10,1,4,0}},
            {{10,1,3,10},{10,1,4,0},{20,1,3,-5}},
            {{40,1,2,-20},{10,1,4,0},{20,1,3,-5}},
            {{50,1,1,0},{10,1,3,0},{20,1,3,-5}},
            {{40,1,1,0},{10,1,3,0},{60,1,1,0}},
    };
    private int mWeek=0; //第几周
    private SoundPool mSoundPool;
    private int[] mSoundIds=new int[12];
    private Timer mTimer;
    private Timer nTimer;
    private int mAccount=0;//当前训练次数
    private int mTime=0;//本次课需要训练次数
    private Button startButton1;
    private Button startButton2;
    private Button startButton3;
    private float mVolume=1.0f;
    private int mPlayTime=3; //每次播放循环次数
    private float mPlayRate=1.0f;//每次播放速度，越大越快，0-2
    private int mTimeRule=60000; //时间标度，毫秒，这里默认是正常的1分钟，调试时可调方便看效果
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks);
        mTv1 = (TextView)findViewById(R.id.textView1);
        startButton1 = (Button)findViewById(R.id.startButton1);
        startButton2 = (Button)findViewById(R.id.startButton2);
        startButton3 = (Button)findViewById(R.id.startButton3);
        startButton1.setOnClickListener(this);
        startButton2.setOnClickListener(this);
        startButton3.setOnClickListener(this);
        Intent intent = getIntent();
        confirmWeek(intent.getIntExtra("week",0));
        mTv1.setText(weekContents[mWeek-1]);
    }

    /*
    * 确定为哪一周
    * */
    public void confirmWeek(int id){
        if(id==R.id.weekButton1){
            mWeek=1;
        }else if(id==R.id.weekButton2){
            mWeek=2;
        }else if(id==R.id.weekButton3){
            mWeek=3;
        }else if(id==R.id.weekButton4){
            mWeek=4;
        }else if(id==R.id.weekButton5){
            mWeek=5;
        }else if(id==R.id.weekButton6){
            mWeek=6;
        }else if(id==R.id.weekButton7){
            mWeek=7;
        }else if(id==R.id.weekButton8){
            mWeek=8;
        }else if(id==R.id.weekButton9){
            mWeek=9;
        }else if(id==R.id.weekButton10){
            mWeek=10;
        }else if(id==R.id.weekButton11){
            mWeek=11;
        }else if(id==R.id.weekButton12){
            mWeek=12;
        }else if(id==R.id.weekButton13){
            mWeek=13;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSoundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);

        // Context, ResourceID, Priority
        mSoundIds[0] = mSoundPool.load(this, R.raw.b9, 1);                  //行走间歇结束的铃声
        mSoundIds[1] = mSoundPool.load(this, R.raw.firstblood, 1);          //拿下一血！
        mSoundIds[2] = mSoundPool.load(this, R.raw.killingspree, 1);        //大杀特杀！
        mSoundIds[3] = mSoundPool.load(this, R.raw.rampage, 1);             //疯狂杀戮！
        mSoundIds[4] = mSoundPool.load(this, R.raw.unstoppedable, 1);       //不可阻挡！
        mSoundIds[5] = mSoundPool.load(this, R.raw.dominating, 1);          //主宰比赛！
        mSoundIds[6] = mSoundPool.load(this, R.raw.godlike, 1);             //成神了！
        mSoundIds[7] = mSoundPool.load(this, R.raw.legendary, 1);           //成为传奇！
        mSoundIds[8] = mSoundPool.load(this, R.raw.doublekill, 1);          //双杀！
        mSoundIds[9] = mSoundPool.load(this, R.raw.triplekill, 1);          //三杀！
        mSoundIds[10] = mSoundPool.load(this, R.raw.quatrekill, 1);         //四杀！
        mSoundIds[11] = mSoundPool.load(this, R.raw.penta, 1);              //五杀！
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null!=mTimer){
            mTimer.cancel();
            mTimer=null;
        }
        if(null!=nTimer){
            nTimer.cancel();
            nTimer=null;
        }
        if(mSoundPool!=null){
            mSoundPool.release();
            mSoundPool = null;
        }
    }

    @Override
    public void onClick(View v) {
        mAccount=0;
        startButton1.setClickable(false);
        startButton2.setClickable(false);
        startButton3.setClickable(false);
        startButton1.setText("开始第1课");
        startButton2.setText("开始第2课");
        startButton3.setText("开始第3课");
        nTimer=new Timer();
        if(v.getId()==R.id.startButton1){
            startButton1.setText("奔跑吧兄弟");
            mTime=mPlan[mWeek-1][0][2];
            if(mWeek==9){
                goToTrainInNineWeekFirstClass();
            }else{
                doRunAndWalkMuch(mPlan[mWeek-1][0][0],mPlan[mWeek-1][0][1],mPlan[mWeek-1][0][2],mPlan[mWeek-1][0][3],startButton1);
            }
        }
        if(v.getId()==R.id.startButton2){

            startButton2.setText("奔跑吧兄弟");
            mTime=mPlan[mWeek-1][1][2];
            Log.e("button2",mWeek+"");
            doRunAndWalkMuch(mPlan[mWeek-1][1][0],mPlan[mWeek-1][1][1],mPlan[mWeek-1][1][2],mPlan[mWeek-1][1][3],startButton2);
        }
        if(v.getId()==R.id.startButton3){
            startButton3.setText("奔跑吧兄弟");
            mTime=mPlan[mWeek-1][2][2];
            if(mWeek==12){
                goToTrainInTwelveWeekThirdClass();
            }else {
                doRunAndWalkMuch(mPlan[mWeek-1][2][0],mPlan[mWeek-1][2][1],mPlan[mWeek-1][2][2],mPlan[mWeek-1][2][3],startButton3);
            }
        }
    }
    public void goToPlay(int soundPosition){
        //每次课最后一次跑步后为pendakill
        if(soundPosition!=0 && soundPosition%mTime==0){
            Log.e("播放结束","::"+soundPosition);
            mSoundPool.play(mSoundIds[11], mVolume, mVolume, 1, mPlayTime, mPlayRate);
        }else{
            Log.e("播放次数","::"+soundPosition);
            mSoundPool.play(mSoundIds[soundPosition%12], mVolume, mVolume, 10, mPlayTime, mPlayRate);
        }
    }

    /*
    * 当有跑步时间等差时需采用的递归方法
    * */
    public void goToTrain(final int runMinute, final int walkMinute, final int timeSpace, final int account, final int goalAccount, final Button pressedButton ){
        if(account<=goalAccount){
            nTimer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            goToPlay(account);
                            nTimer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    goToPlay(0);
                                    goToTrain(runMinute+timeSpace,walkMinute,timeSpace,account+1,goalAccount,pressedButton);
                                }
                            },walkMinute*mTimeRule);

                        }
                    },runMinute*mTimeRule
            );
        }else{
            doAfterFinishRun(pressedButton);
        }
    }
    public void doRunAndWalkMuch(final int runMinute, final int walkMinute, final int goalAccount,final int timeSpace, final Button theButton){
        Log.e("跑步参数",runMinute+":"+walkMinute+":"+goalAccount+":"+timeSpace+":"+theButton);
        if(timeSpace!=0){
            goToTrain(runMinute,walkMinute,timeSpace,1,goalAccount,theButton);
        }else {
            nTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mAccount++;
                    if (mAccount < goalAccount + 1) {
                        doRunAndWalkOnce(runMinute, walkMinute);
                    } else {
                        doAfterFinishRun(theButton);
                    }
                }
            }, 0, (runMinute + walkMinute) * mTimeRule);
        }
    }
    public void doAfterFinishRun(final Button theButton){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                startButton1.setClickable(true);
                startButton2.setClickable(true);
                startButton3.setClickable(true);
                theButton.setText("少年，还要再来一发吗");
            }
        });
        nTimer.cancel();
        nTimer = null;
    }
    public void doRunAndWalkOnce(int runMinute, final int walkMinute){
        mTimer=new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                goToPlay(mAccount);
                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        goToPlay(0);
                    }
                },walkMinute*mTimeRule);
            }
        },runMinute*mTimeRule);
    }
    
    public void goToTrainInNineWeekFirstClass(){
        nTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                goToPlay(1);
                nTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        goToPlay(0);
                        nTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                goToPlay(2);
                                nTimer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        goToPlay(0);
                                        nTimer.schedule(new TimerTask() {
                                            @Override
                                            public void run() {
                                                goToPlay(3);
                                                nTimer.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        goToPlay(0);
                                                        nTimer.schedule(new TimerTask() {
                                                            @Override
                                                            public void run() {
                                                                goToPlay(4);
                                                                nTimer.schedule(new TimerTask() {
                                                                    @Override
                                                                    public void run() {
                                                                        goToPlay(0);
                                                                        doAfterFinishRun(startButton1);
                                                                    }
                                                                },mTimeRule);
                                                            }
                                                        },10*mTimeRule);
                                                    }
                                                },mTimeRule);
                                            }
                                        },20*mTimeRule);
                                    }
                                },mTimeRule);
                            }
                        },15*mTimeRule);
                    }
                },mTimeRule);
            }
        },10*mTimeRule);
    }
    public void goToTrainInTwelveWeekThirdClass(){
        nTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                goToPlay(1);
                nTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        goToPlay(0);
                        nTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                goToPlay(2);
                                nTimer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        goToPlay(0);
                                        nTimer.schedule(new TimerTask() {
                                            @Override
                                            public void run() {
                                                goToPlay(3);
                                                nTimer.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        goToPlay(0);
                                                        doAfterFinishRun(startButton3);
                                                    }
                                                },mTimeRule);
                                            }
                                        },10*mTimeRule);
                                    }
                                },mTimeRule);
                            }
                        },15*mTimeRule);
                    }
                },mTimeRule);
            }
        },15*mTimeRule);
    }
}
