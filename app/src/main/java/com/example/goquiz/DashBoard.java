package com.example.goquiz;

import static com.example.goquiz.MainActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DashBoard extends AppCompatActivity {


    CountDownTimer countDownTimer;
    int timerValue=20;
    ProgressBar progressBar;

    List<Modelclass> allQuestionsList;
    Modelclass modelclass;
    int index=0;
    TextView card_question,optiona,optionb,optionc,optiond;
    CardView cardOA,cardOB,cardOC,cardOD;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);



        Hooks();
        allQuestionsList=list;
        //for ramdom questions.
        Collections.shuffle(allQuestionsList);
        modelclass=list.get(index);


        SetAllData();


        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
              timerValue=timerValue-1;
              progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog= new Dialog(DashBoard.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_finish_dialog);
                dialog.show();


                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(DashBoard.this,DashBoard.class);
                        startActivity(intent);
                    }
                });


            }
        }.start();


    }

    private void SetAllData() {

        card_question.setText(modelclass.getQuestion());
        optiona.setText(modelclass.getoA());
        optionb.setText(modelclass.getoB());
        optionc.setText(modelclass.getoC());
        optiond.setText(modelclass.getoD());
    }

    private void Hooks() {

        progressBar=findViewById(R.id.quiz_timer);
        card_question=findViewById(R.id.card_question_sathi);
        optiona=findViewById(R.id.card_option_A_sathi);
        optionb=findViewById(R.id.card_option_B_sathi);
        optionc=findViewById(R.id.card_option_C_sathi);
        optiond=findViewById(R.id.card_option_D_sathi);


        cardOA=findViewById(R.id.cardA);
        cardOB=findViewById(R.id.cardB);
        cardOC=findViewById(R.id.cardC);
        cardOD=findViewById(R.id.cardD);


        nextBtn=findViewById(R.id.nextBtn);

    }


    public void Correct(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.green));


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelclass=list.get(index);
                SetAllData();

            }
        });

    }
    public void Wrong(CardView cardOA){
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.redcolor));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wrongCount++;
                if(index<list.size()-1){
                    index++;
                    modelclass=list.get(index);
                    SetAllData();
                    resetColor();

                }else {
                    GameWon();
                }

            }
        });
    }

    private void GameWon() {
        Intent intent =new Intent(DashBoard.this,WonActivity.class);
        startActivity(intent);
    }

    public void  enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void  disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionAClick(View view){
        nextBtn.setClickable(true);

        if (modelclass.getoA().equals(modelclass.getAns()))
        {
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));

              if (index<list.size()-1){

                  Correct(cardOA);
              }else{
                  GameWon();
              }
        }else{
            Wrong(cardOA);
        }
    }

    public void OptionBClick(View view){
        nextBtn.setClickable(true);

        if (modelclass.getoB().equals(modelclass.getAns()))
        {
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){

                Correct(cardOB);
            }else{
                GameWon();
            }
        }else{
            Wrong(cardOB);
        }
    }


    public void OptionCClick(View view){

        nextBtn.setClickable(true);

        if (modelclass.getoC().equals(modelclass.getAns()))
        {
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){


                Correct(cardOC);
            }else{
                GameWon();
            }
        }else{
            Wrong(cardOC);
        }
    }


    public void OptionDClick(View view){
        nextBtn.setClickable(true);

        if (modelclass.getoD().equals(modelclass.getAns()))
        {
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){


                Correct(cardOD);
            }else{
                GameWon();
            }
        }else{
            Wrong(cardOD);
        }
    }
}