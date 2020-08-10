package com.example.activity0810_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class VoteResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VC");
        String[] imgName = intent.getStringArrayExtra("ImageName");

        TextView tvArr[] = new TextView[9];
        RatingBar rbarArr[] = new RatingBar[9];
        int tvId[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4
                , R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        int rbarId[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};
        for (int i = 0; i < 9; i++) {
            tvArr[i] = findViewById(tvId[i]);
            rbarArr[i] = findViewById(rbarId[i]);

            tvArr[i].setText(imgName[i]);
            rbarArr[i].setRating((float) voteResult[i]);

            Button doneBtn = (Button) findViewById(R.id.doneBtn);
            doneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}