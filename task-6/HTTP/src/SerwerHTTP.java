import java.io.*;
import java.net.*;
 
class ObslugaZadania extends Thread
{
   Socket sock;
 
   ObslugaZadania(Socket klientSocket)  
   {                                   
      this.sock=klientSocket;          
   }                                   
 
   public void run() 
   {                 
 
   }                 
}
 
public class SerwerHTTP
{
   public static void main(String[] args) throws IOException     
   {                                                            
      ServerSocket serv=new ServerSocket(80);                   
 
      while(true)                                               
      {                                                         
         //przyjecie polaczenia                                 
         System.out.println("Oczekiwanie na polaczenie...");    
         Socket sock=serv.accept();                             
 
         //tworzenie watku obslugi tego polaczenia              
         new ObslugaZadania(sock).start();                      
      }                                                         
   }                                                            
}