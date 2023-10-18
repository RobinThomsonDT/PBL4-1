package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            // Tạo một đối tượng DatagramSocket để gửi dữ liệu
            DatagramSocket socket = new DatagramSocket();

            // Lấy thời gian hiện tại
            long currentTime = System.currentTimeMillis();

            // Chuyển thời gian thành mảng byte
            byte[] timeBytes = Long.toString(currentTime).getBytes();

            // Xác định địa chỉ và cổng của máy tính 2
            InetAddress recipientAddress = InetAddress.getByName("192.168.1.8");

            // Tạo một gói dữ liệu DatagramPacket
            DatagramPacket packet = new DatagramPacket(timeBytes, timeBytes.length, recipientAddress, PORT);

            // Gửi gói dữ liệu đi
            socket.send(packet);

            // Đóng socket
            socket.close();

            // Hiển thị thời gian đã gửi
            Date date = new Date(currentTime);
            System.out.println("Đã gửi thời gian: " + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}