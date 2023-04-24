package com.mirea.schelukhinka.looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyLooper extends Thread {
    public Handler mHandler;
    private Handler mainHandler;

    public MyLooper(Handler mainThreadHandler) {
        mainHandler = mainThreadHandler;
    }

    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        mHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message msg) {
                String data = msg.getData().getString("KEY");
                Log.d("MyLooper	get	message:	", data);

                String job = msg.getData().getString("JOB");
                int age = msg.getData().getInt("AGE");
                Log.d("MyLooper get message: ", job);
                Log.d("MyLooper get message: ", String.valueOf(age));
                try{
                    TimeUnit.SECONDS.sleep(age);
                }
                catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

                int count = data.length();
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("letter count", String.format("The	number	of	letters	in	the	word	%s	is	%d	", data, count));
                bundle.putString("message", String.format("My job is %s and my age is %d years old ", job, age));
                message.setData(bundle);
                //	Send	the	message	back	to	main	thread	message	queue	use	main	thread	message	Handler.
                mainHandler.sendMessage(message);
            }
        };
        Looper.loop();
    }
}