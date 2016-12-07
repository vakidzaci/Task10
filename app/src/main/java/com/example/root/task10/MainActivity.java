package com.example.root.task10;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener {
    TextView tv;
    AbsoluteLayout al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);
        al=(AbsoluteLayout)findViewById(R.id.activity_main);
        al.setOnTouchListener(this);

    }
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // событие
        int actionMask = event.getActionMasked();
        // индекс касания
        int pointerIndex = event.getActionIndex();
        // число касаний
        int pointerCount = event.getPointerCount();

        switch (actionMask) {
            case MotionEvent.ACTION_DOWN: // первое касание
            case MotionEvent.ACTION_POINTER_DOWN: // последующие касания
                break;
            case MotionEvent.ACTION_UP: // прерывание последнего касания
                if(Math.abs(tv.getX()-300)<100&&Math.abs(tv.getY()-600)<100){
                    tv.setText("");
                }
            case MotionEvent.ACTION_POINTER_UP: // прерывания касаний
                break;
            case MotionEvent.ACTION_MOVE: // движение
                if(Math.abs(tv.getX()-event.getX())<50&&Math.abs(tv.getY()-event.getY())<50){
                tv.setX(event.getX());
                tv.setY(event.getY());}
                break;
        }
        return true;
    }
}
