package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mStoryTextView;
    Button mButtonTop,mButtonBottom;

    int mIndexStory = 0;


    final Story storyLine[] = new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new Story(R.string.T4_End,R.string.T4_Ans1,R.string.T4_Ans2),
            new Story(R.string.T5_End,R.string.T5_Ans1,R.string.T5_Ans2),
            new Story(R.string.T6_End,R.string.T6_Ans1,R.string.T6_Ans2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
           mIndexStory = savedInstanceState.getInt("mIndexStory",mIndexStory);

        }else{
            mIndexStory = 0;
        }

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);



        mStoryTextView.setText(storyLine[mIndexStory].getStory());
        mButtonTop.setText(storyLine[mIndexStory].getAns_1());
        mButtonBottom.setText(storyLine[mIndexStory].getAns_2());

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mIndexStory){
                    case 0:
                        mIndexStory=2;
                        break;
                    case 2:
                        mIndexStory = 5;
                        break;
                    case 1:
                        mIndexStory = 2;
                        break;
                }
                setStory();
            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mIndexStory){
                    case 2:
                        mIndexStory = 4;
                        break;
                    case 0:
                        mIndexStory=1;
                        break;
                    case 1:
                        mIndexStory = 3;
                        break;
                }
                setStory();

            }
        });



    }

    public void setStory(){
        mStoryTextView.setText(storyLine[mIndexStory].getStory());
        mButtonTop.setText(storyLine[mIndexStory].getAns_1());
        mButtonBottom.setText(storyLine[mIndexStory].getAns_2());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mIndexStory",mIndexStory);
    }
}
