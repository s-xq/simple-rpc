import client.RpcImporter;
import server.EchoService;
import server.EchoServiceImpl;
import server.RpcExporter;

import java.net.InetSocketAddress;

public class main {


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8088);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echo.echo("Are you ok?"));

    }
}
