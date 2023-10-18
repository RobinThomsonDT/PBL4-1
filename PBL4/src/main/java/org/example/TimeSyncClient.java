import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;

public class TimeSyncClient {
    public static void main(String[] args) {
        String ntpServer1 = "0.pool.ntp.org";
        String ntpServer2 = "192.168.1.8";

        try {
            // Tạo một đối tượng NTPUDPClient
            NTPUDPClient client = new NTPUDPClient();

            // Thiết lập timeout cho 5 giây
            client.setDefaultTimeout(5000);

            // Lấy thông tin thời gian từ máy chủ NTP thứ nhất
            InetAddress ntpServerAddress1 = InetAddress.getByName(ntpServer1);
            TimeInfo timeInfo1 = client.getTime(ntpServerAddress1);

            // Lấy thông tin thời gian từ máy chủ NTP thứ hai
            InetAddress ntpServerAddress2 = InetAddress.getByName(ntpServer2);
            TimeInfo timeInfo2 = client.getTime(ntpServerAddress2);

            // Lấy chênh lệch thời gian giữa hai máy tính
            long timeDifference = timeInfo2.getReturnTime() - timeInfo1.getReturnTime();

            // Hiển thị kết quả
            System.out.println("Chênh lệch thời gian giữa hai máy tính (đơn vị: millisecond): " + timeDifference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}