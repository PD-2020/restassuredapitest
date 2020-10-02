package commons;

import java.io.BufferedReader;
import java.io.FileReader;

public class ApiConfig {

    public final String base_uri = "https://craftplacer.trexion.com";
    public final String gameDB_base_uri = "http://localhost:8080/app";
    public final String gp_contact_base_uri = "http://3.13.86.142:3000";

    public String read(String filePath) {
        String finalText = null;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            finalText = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalText;
    }

    public String getPayload(String filename){
        String path =System.getProperty("user.dir")+"/src/test/resources/payloads/"+filename+".json";
        String payload = read(path).trim();
        return payload;
    }




}
