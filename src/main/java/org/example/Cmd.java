import java.awt.*;
import java.awt.event.KeyEvent;

public class Cmd {
    public static void main(String[] args) {
        try {
            // Mở cửa sổ cmd bằng cách gửi lệnh "cmd" và nhấn phím Enter
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.delay(1000);
            typeString(robot, "cmd");
            typeKey(robot, KeyEvent.VK_ENTER);
          //  robot.keyPress(KeyEvent.VK_ENTER);
          //  robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);

            // Gõ lệnh trong cửa sổ cmd
            typeString(robot, "dir");

            typeKey(robot, KeyEvent.VK_ENTER);
            robot.delay(1000);

            // Đóng cửa sổ cmd bằng cách gửi lệnh "exit" và nhấn phím Enter
           // typeString(robot, "exit");
           // typeKey(robot, KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // Hàm gõ chuỗi ký tự
    private static void typeString(Robot robot, String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robot.delay(400);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    // Hàm gõ phím
    private static void typeKey(Robot robot, int keyCode) {
        robot.delay(400);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
}