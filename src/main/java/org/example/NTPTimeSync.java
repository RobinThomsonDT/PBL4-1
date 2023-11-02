import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import java.util.Date;
import java.net.InetAddress;
import java.io.IOException;

public class NTPTimeSync {
    public static void main(String[] args) {
        NTPUDPClient client = new NTPUDPClient();
        try {
            client.open();
            InetAddress address = InetAddress.getByName("pool.ntp.org");
            TimeInfo timeInfo = client.getTime(address);

            long serverTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
            long localTime = System.currentTimeMillis();

            // Synchronized time = Local time + Server time - Request time
            long synchronizedTime = localTime + (serverTime - timeInfo.getReturnTime());

            System.out.println("Synchronized time: " + synchronizedTime);
            Date realTime = new Date(synchronizedTime); // Chuyển đổi thành đối tượng Date

            System.out.println(realTime); // In ra thời gian thực

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}