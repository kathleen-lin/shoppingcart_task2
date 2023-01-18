package practice.networking;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException {
        
        String[] nameConnection = args[0].split("@");
        String userName = nameConnection[0];
        String host_portnum = nameConnection[1];
        String[] hostportNum = host_portnum.split(":");
        String host = hostportNum[0];
        int portNum = Integer.parseInt(hostportNum[1]);

        Socket sock = new Socket(host, portNum);

        System.out.printf(" Connected to shopping cart server at %s on %s port %d\n", host, userName, portNum );

        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os); 



        // first stream
        dos.writeUTF(userName);
        dos.flush();
        // second stream
        String msg = dis.readUTF();
        System.out.println(msg);

        //read console and send to server
        Console cons = System.console();
        String clientInput = cons.readLine("> ");

        while(!clientInput.equals("exit")){

            // third stream
            clientInput = cons.readLine("> ");
            dos.writeUTF(clientInput);
            dos.flush();

            try {
                
                // fouth stream
                String output = dis.readUTF();
                System.out.println(output);
            } catch (Exception e) {
                break;
            }
            
        
        }

        //System.out.println("closing socket");
        //sock.close();

        
    }
}
