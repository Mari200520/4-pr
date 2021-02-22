package com.example.chislo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer guess;
    Boolean gameFinished;

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo=(TextView)findViewById(R.id.textView);
        etInput=(EditText)findViewById(R.id.editText);
        bControl=(Button)findViewById(R.id.button);

        guess=(int)(Math.random()*100);
        gameFinished=false;

    }
    public void onClick(View v){

        if (! gameFinished) {
            if (etInput.getText().toString().isEmpty()) {
                Toast toast=Toast.makeText(this,R.string.empty, Toast.LENGTH_LONG);
                toast.show();
                etInput.setText(R.string.empty2);
            }
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp>100 || inp<1)  {
                Toast toast=Toast.makeText(this,R.string.error, Toast.LENGTH_LONG);
                toast.show();
                etInput.setText(R.string.empty2);
            }
            if(inp>guess)
                tvInfo.setText(getResources().getText(R.string.ahead));
            if(inp<guess)
                tvInfo.setText(getResources().getText(R.string.behind));
            if (inp==guess) {
                tvInfo.setText(getResources().getText(R.string.hit));
                bControl.setText(getResources().getText(R.string.play_more));
                gameFinished=true;
            }
        }
        else
        {
            guess=(int)(Math.random()*100);
            bControl.setText(getResources().getText(R.string.input_value));
            tvInfo.setText(getResources().getText(R.string.try_to_guess));
            gameFinished=false;
        }
        etInput.setText("");
    }

}