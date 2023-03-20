import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RequestConnection {

    public static StringBuffer getData(String urlVar) throws Exception{
        URL url = new URL(urlVar);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        InputStream inputStream = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = reader.readLine())!=null){
            response.append(inputLine);
        }
        return response;
    }

    public static boolean writeData(){
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the url: ");
        String url = sc.nextLine();
        String response = getData(url).toString();
        for(String s:response.split("    ")){
            System.out.println(s);
        }
    }
}
