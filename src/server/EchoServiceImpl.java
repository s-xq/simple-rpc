package server;

/**
 * 模拟服务端发布的服务
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String ping) {

        return ping != null ? ping + " ---> I am ok." : "I am not ok.";

    }
}
