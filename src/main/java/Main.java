import java.io.*;
import java.net.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        var client = new Client("settings.txt");
        client.connect();
    }
}