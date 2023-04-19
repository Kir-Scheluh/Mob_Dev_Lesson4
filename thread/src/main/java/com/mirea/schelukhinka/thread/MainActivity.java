package com.mirea.schelukhinka.thread;

import static java.util.logging.Logger.global;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.schelukhinka.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private	ActivityMainBinding	binding;
    private	int	counter	=	0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener()	{
            @Override
            public	void	onClick(View	v)	{
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        float les = Float.parseFloat(binding.lessons.getText().toString())/Float.parseFloat(binding.days.getText().toString());
                        binding.textView.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.textView.setText("Среднее кол-во пар в день " +Float.toString(les));
                            }
                        });
                    }
                };
                Thread thread  = new Thread(runnable);
                thread.start();
            }
        });
    }
}