package com.mirea.schelukhinka.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mirea.schelukhinka.data_thread.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.threadInfo.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.threadInfo.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.threadInfo.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.threadInfo.postDelayed(runn2, 5000);
                    binding.threadInfo.post(runn3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        binding.textView.setText("runOnUiThread - выполняет указанное действие в потоке пользовательского интерфейса. Если текущий поток является потоком пользовательского интерфейса, то действие выполняется немедленно." +
                "\n post - Приводит к добавлению выполняемого файла в очередь сообщений. Запускаемый файл будет выполняться в потоке пользовательского интерфейса." +
                "\n postDelayed - Приводит к добавлению выполняемого объекта в очередь сообщений, который будет запущен по истечении указанного промежутка времени.");
    }
}