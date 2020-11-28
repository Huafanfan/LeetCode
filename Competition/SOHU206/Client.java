package Competition.SOHU206;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/27 15:58
 */

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            // 创建一个客户端Socket，参数为客户端IP和指定端口号，此处客户端和服务器在同一台电脑，所以IP地址相同
            socket = new Socket("10.28.219.148",9900);
            // 通过输出流，给服务器发送请求
            os = socket.getOutputStream();
            String info = "用户名：YeHuan; 密码：12345";
            byte[] infos = info.getBytes();
            os.write(infos);
            // 关闭输出流
            socket.shutdownOutput();

            // 获得输入流，接收服务器请求
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String reply;
            while((reply = br.readLine())!=null) {
                System.out.println(reply);
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
