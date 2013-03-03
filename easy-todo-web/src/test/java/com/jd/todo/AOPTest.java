package com.jd.todo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class AOPTest {

    private static int thread_num = 40;

    private static int client_num = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(thread_num);
        for (int index = 0; index < client_num; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        //http://localhost:8080/login/reg_register.action?email=ztrea@si.com&pwd=111&SQ_ID=3123
                        semp.acquire();
                        System.out.println("Thread:" + NO);
                        String host = "http://localhost:8080/login/reg_register.action?";
                        String para = "email=ztrea@si.com&pwd=111&SQ_ID=$" + Math.random();
                        System.out.println(host + para);
                        URL url = new URL(host);// 此处填写供测试的url
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setDoOutput(true);
                        connection.setDoInput(true);
                        PrintWriter out = new PrintWriter(connection.getOutputStream());
                        out.print(para);
                        out.flush();
                        out.close();
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line = "";
                        String result = "";
                        while ((line = in.readLine()) != null) {
                            result += line;
                        }
                        System.out.println("第：" + NO + " 个");
                        semp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
// 退出线程池
        exec.shutdown();
    }

}