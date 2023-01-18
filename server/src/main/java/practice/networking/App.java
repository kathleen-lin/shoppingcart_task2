package practice.networking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

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

        //file
        String pathName = args[0];

        System.out.printf("Starting shopping cart server on port %s\n", args[1]);
        System.out.printf("Using %s directory for persistence\n", args[0]);

        //Initiate a server
        ServerSocket server = new ServerSocket(Integer.parseInt(args[1]));
        Socket sock = server.accept();
        System.out.println("Connection received");
        
        //setup input and output streams
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os); 
        
        // check if userName shopping cart exist, if not exist, create file
        // first stream
        String userName = dis.readUTF();
        System.out.println(userName);
        String fileName = userName + ".cart";
        System.out.println(fileName);

        File f = new File(pathName, fileName);

        if (f.createNewFile()){
            //load
            Cart cart = new Cart();
            cart.load(f);
            //second stream
            dos.writeUTF(userName + " shopping cart loaded");
            dos.flush();
            Boolean stop = false;

            while(!stop){

            // third stream
                String clientInput = dis.readUTF();

                if (clientInput.equals("exit")){
                    // fouth stream
                    dos.writeUTF("exit programme");
                    dos.flush();
                    stop = true;
                    break;
                }
                if (clientInput.equals("list")){
                    String list = cart.list();
                    // fouth stream
                    dos.writeUTF(list);
                    dos.flush();

                }
                /*
                if (clientInput.startsWith("delete")){
                    // fouth stream

                }
                if (clientInput.equals("save")){
                    // fouth stream

                }
                if (clientInput.startsWith("add")){
                    // fouth stream

                }  */
                else {
                    
                    dos.writeUTF("hello, world");

                }
            }
        } else {
            //load
            Cart cart = new Cart();
            cart.load(f);
            //second stream
            dos.writeUTF(userName + " shopping cart loaded");
            dos.flush();
            Boolean stop = false;

            while(!stop){

            // third stream
                String clientInput = dis.readUTF();

                if (clientInput.equals("exit")){
                    // fouth stream
                    dos.writeUTF("exit programme");
                    dos.flush();
                    stop = true;
                    break;
                }
                if (clientInput.equals("list")){
                    String list = cart.list();
                    // fouth stream
                    dos.writeUTF(list);
                    dos.flush();

                }
                /*
                if (clientInput.startsWith("delete")){
                    // fouth stream

                }
                if (clientInput.equals("save")){
                    // fouth stream

                }
                if (clientInput.startsWith("add")){
                    // fouth stream

                }  */
                else {
                    
                    dos.writeUTF("hello, world");

                }
            }

        }

        
            
            
        }
 

        
        


    
}
