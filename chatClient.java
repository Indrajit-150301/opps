import java.net.*;
import java.io.*;



public class Client {

    Socket socket;

    BufferedReader br;
    PrintWriter out;



    public Client()
    {
        try {
            socket = new Socket("localhost",9990);
            System.out.println("connection done.");

            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
       
        } catch (Exception e) {
            // TODO: handle exception
        }    
    }

    public void startReading(){
        //thread-read karke deta rahega
        Runnable r1=()->{
            System.out.println("reader started...");
            
            try{

            while(true)
            {
                
                String msg = br.readLine();

                if(msg.equals("exit"))
                {
                    System.out.println("Server terminated the chat");
                    socket.close();
                    break;
                }

                System.out.println("FROM Server:" +msg);

            
        

        }
    }catch(Exception e)
    {
       // e.printStackTrace();
       System.out.println("connection closed");
    }
    };

    new Thread(r1).start();
}   

public void startWriting(){
    //thread-data user and the send karega client tak

    System.out.println("writer started....");
    Runnable r2=()->{

        try{
        while(!socket.isClosed()){
       

            BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
            String content = br1.readLine();
            out.println(content);
            out.flush();
            
            if(content.equals("exit")){
                socket.close();
                break;
            }
       
    }

} catch(Exception e) {
    // TODO: handle exception
    e.printStackTrace();
}

    };

    new Thread(r2).start();
}

    public static void main(String[] args) {
        System.out.println("Clent..............");
        new Client();
    }
}
