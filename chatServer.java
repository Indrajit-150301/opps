import java.net.*;
import java.io.*;


class Server{


    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    //Constructor
    public Server(){
        try{
            server = new ServerSocket(9990); 
            System.out.println("Server is ready to accept connnection");
            System.out.println("waiting..........");
            socket=server.accept();

            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());


            startReading();
            startWriting();

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    // start reading
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
                    System.out.println("Client terminated the chat");
                    socket.close();
                    break;
                }

                System.out.println("FROM Client:" +msg);

           
        

        }
    }catch(Exception e)
    {
        //e.printStackTrace();
        System.out.println("connection closed");
    }
    };

    new Thread(r1).start();
}   
    //Start writing
    public void startWriting(){
        //thread-data user and the send karega client tak

        System.out.println("writer started....");
        Runnable r2=()->{

            try {
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

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        };

        new Thread(r2).start();
    }
    public static void main(String[] args) {
        System.out.println("Server page is running!............");
        new Server();
    }
}