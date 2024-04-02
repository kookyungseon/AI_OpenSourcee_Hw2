package com.cookandroid.project4_2;

import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    Button button;
    RadioButton dogButton, catButton, rabbitButton;
    RadioGroup radioGroup;
    TextView text1;
    ImageView image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkbox);
        button = findViewById(R.id.submitButton);
        dogButton = findViewById(R.id.dogButton);
        catButton = findViewById(R.id.catButton);
        rabbitButton = findViewById(R.id.rabbitButton);
        text1 = findViewById(R.id.text1);
        image1 = findViewById(R.id.image1);


        final int[] returnId = new int[1];

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true) {
                    text1.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                } else {
                    text1.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.dogButton) {
                    returnId[0] = R.id.dogButton;
                } else if (checkedId == R.id.catButton) {
                    returnId[0] = R.id.catButton;
                } else {
                    returnId[0] = R.id.rabbitButton;
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (returnId[0] == R.id.dogButton) {
                    AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                    ad.setTitle("강아지");
                    ad.setMessage("강아지 사진");
                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();

                    image1.setImageResource(R.drawable.dog);
                } else if (returnId[0] == R.id.catButton) {
                    AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                    ad.setTitle("고양이");
                    ad.setMessage("고양이 사진");
                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();
                    image1.setImageResource(R.drawable.cat);

                } else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                    ad.setTitle("토끼");
                    ad.setMessage("토끼 사진");
                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();
                    image1.setImageResource(R.drawable.rabit);
                }
            }
        });


    }
}