import java.io.*;
import java.net.*;
class TCPServer
{
    public static void main(String argv[]) throws Exception
    {
        //Code to Create the Server side sockets
        ServerSocket welcomeSocket = new ServerSocket(3000);
        Socket connectionSocket = welcomeSocket.accept();
        System.out.println("Connected To the Server");
        InetAddress InetAddr = InetAddress.getByName("10.59.121.100");
        //Initialize the File object with the data
        File file = new File("C:\\Users\\91900\\Desktop\\College\\Computer Networks Lite\\Lab 7\\TCPConnection\\index.html");
        //Create the File Reading Buffers for the I/p and O/p of data
        FileInputStream fInputStream = new FileInputStream(file);
        BufferedInputStream bInputStream =  new BufferedInputStream(fInputStream);
        OutputStream outputStream = connectionSocket.getOutputStream();
        //Creating the array to store the file data.
        byte[] fileContents;
        long fileLength = file.length();
        long currentFilePointer = 0;
        long start = System.nanoTime();
        //Read the data in the File to transfer information from one file to another
        while(currentFilePointer!=fileLength)
        {
            int size=10000;
            if(fileLength-currentFilePointer>=size)
                currentFilePointer+=size;
            else
            {
                size = (int)(fileLength-currentFilePointer);
                currentFilePointer=fileLength;
            }
            fileContents = new byte[size];
            bInputStream.read(fileContents,0,size);
            outputStream.write(fileContents);
            System.out.print("Sending file ... "+(currentFilePointer*100)/fileLength+"% complete!");
        }
        //Close the sockets to terminate the connection
        outputStream.flush();
        connectionSocket.close();
        welcomeSocket.close();
        System.out.println("File has been transferred sucessfully");
    }
}