package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            // Tạo một đối tượng DatagramSocket để nhận dữ liệu
            DatagramSocket socket = new DatagramSocket(PORT);

            // Tạo một mảng byte để chứa dữ liệu nhận được
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Nhận gói dữ liệu
            socket.receive(packet);

            // Chuyển mảng byte thành dữ liệu thời gian
            long receivedTime = Long.parseLong(new String(packet.getData()).trim());

            // Hiển thị thời gian nhận được
            System.out.println("Thời gian nhận được: " + receivedTime);

            // Đóng socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
