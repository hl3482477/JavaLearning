package com.study.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * @author HULU
 * @version 创建时间：2021/3/5 14:56
 */
public class BioClient {

    public static void main(String[] args) {
        Socket clientSocket = null;
        OutputStream outputStream = null;
        try {
            // 新建一个Socket请求
            clientSocket = new Socket("localhost", 9999);
            System.out.println("Build the connection successfully!" + " ," + new Date().toString());
            outputStream = clientSocket.getOutputStream();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Please input a String !" + " ," + new Date().toString());
                String string = scanner.nextLine();

                outputStream.write(string.getBytes());

            }

        } catch (Exception e) {

        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
