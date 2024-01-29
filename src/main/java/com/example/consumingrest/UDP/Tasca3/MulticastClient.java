package com.example.consumingrest.UDP.Tasca3;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.0.0.1");
            MulticastSocket socket = new MulticastSocket(9878);
            socket.joinGroup(group);

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedWord = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received word: " + receivedWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}