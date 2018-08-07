package rpise_dstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rpise_dstream {
    public static   ArrayList<StreamingRoom> sm = new ArrayList<StreamingRoom>();
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
 
        System.out.println(" Server signing On :");
        ServerSocket soc = new ServerSocket(8096);
      // accept client socket
        //  Socket ss= soc.accept();

// create a array of rooms;
// loop through array to open socket
// start conversation.
 //      for (int i = 0; i < 5; i++)
 //      {
 //          sm.add(new  StreamingRoom(ss) );
 //      }

        StreamingRoom r2 = new StreamingRoom(soc);
         r2.setRoomName("Room2");
        //r2.init(soc);
        r2.start();
        StreamingRoom r1 = new StreamingRoom(soc);
        r1.setRoomName("Room1");
        //r1.init(soc);
        r1.start();

        try {
            r1.join();
            r2.join();
        } catch (InterruptedException ex) {
            System.out.println(" Thread Join Interruption..." + ex);
        }

        System.out.println(" Server signed out :");
    }

}
