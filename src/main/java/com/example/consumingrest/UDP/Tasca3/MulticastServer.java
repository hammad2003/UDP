package com.example.consumingrest.UDP.Tasca3;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName("224.0.0.1");

            String[] wordList = {"apple", "banana", "orange", "grape", "kiwi"};
            Random random = new Random();

            while (true) {
                String randomWord = wordList[random.nextInt(wordList.length)];

                byte[] sendData = randomWord.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, 9878);
                socket.send(sendPacket);

                Thread.sleep(2000); // Wait for 2 seconds before sending the next word
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

