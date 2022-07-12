package com.example.velog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input_layout);

        final EditText etx1 = findViewById(R.id.password);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "nanumsquare.ttf");
        etx1.setTypeface(typeFace);
        final ImageButton see_pw = findViewById(R.id.viewPassword);

        etx1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        etx1.clearFocus();
                        InputMethodManager imm =
                                (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(etx1.getWindowToken(), 0);
                        return true;
                    }
                }
                return false;
            }
        });

        see_pw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // 터치 동작에 따라 텍스트 인풋 타입 변경
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        etx1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD); // 보이는 비밀번호
                        // 위에서 inpuType을 변경하게 되면 커서가 맨 앞으로 오는 문제가 발생하므로
                        // 전체 택스트의 길이만큼 커서를 뒤로 이동 시킨다
                        etx1.setSelection(etx1.length());
                        etx1.setTypeface(typeFace);
                        see_pw.setImageResource(R.drawable.invisibleeye);
                        break;
                    case MotionEvent.ACTION_UP:
                        etx1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD); // 암호인 텍스트
                        etx1.setSelection(etx1.length());
                        etx1.setTypeface(typeFace);
                        see_pw.setImageResource(R.drawable.visibleeye);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        etx1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD); // 암호인 텍스트
                        etx1.setSelection(etx1.length());
                        etx1.setTypeface(typeFace);
                        see_pw.setImageResource(R.drawable.visibleeye);
                        break;
                }
                return true;
            }
        });
    }
}
/*final TextView text3 =  findViewById(R.id.text3);
        final EditText text1 = findViewById(R.id.text1);

        text1.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3.setText("재인증");
            }
        });*/