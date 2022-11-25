import java.io.*;
import java.net.*;
class TCPClient
{
    public static void main(String argv[]) throws Exception
    {
        //Initialize the Client side socket
        Socket clientSocket = new Socket(InetAddress.getByName("10.59.121.100"), 3000);
        //Create the 
        byte[] fileContents = new byte[10000];
        FileOutputStream fOutputStream = new FileOutputStream("C:\\Users\\91900\\Desktop\\College\\Computer Networks Lite\\Lab 7\\TCPConnection\\TrasnferredIndex.html");
        BufferedOutputStream bOutputStream = new BufferedOutputStream(fOutputStream);
        InputStream inputStream = clientSocket.getInputStream();
        //Creating the while loop to read the data from the server side file and transfer it into the client side file
        int byteRead = 0;
        while((byteRead=inputStream.read(fileContents))!=-1)
            bOutputStream.write(fileContents,0,byteRead);
        bOutputStream.flush();
        clientSocket.close();
        System.out.println("File Recieved Successfully");
    }
}
 