/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerator;

/**
 *
 * @author Erich Stark
 */
import com.jacob.activeX.ActiveXComponent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class SignDispatch {

    public SignDispatch(String xsdName, String xslName, String xmlName) {
        String sign;
        ActiveXComponent ACX = new ActiveXComponent("DSig.XadesSigAtl");
        ActiveXComponent ACXp = new ActiveXComponent("DSig.XmlPluginAtl");

        String xsd = createXXXfile(xsdName, "xsd");
        String xsl = createXXXfile(xslName, "xsl");
        String xml = createXXXfile(xmlName, "xml");

        Variant dispatch = Dispatch.call(ACXp, "CreateObject", "Vzor", "Countries", 
                xml, xsd, "", "http://stark.guru/countries.xsd", xsl, "http://stark.guru/countries.xsl");
        if (dispatch == null) {
            return;
        }
        int oNumber = Dispatch.call(ACX, "AddObject", dispatch).toInt();
        if (oNumber != 0) {
            return;
        }
        Dispatch.call(ACX, "Sign", "signatureId", "sha256", "urn:oid:1.3.158.36061701.1.2.1").toInt();
        sign = ACX.getProperty("SignedXmlWithEnvelope").toString();

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("sign.xml"));
            out.write(sign);
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public String createXXXfile(String fileName, String fileType) {
        String data = new String();
        String line;
        try {
            FileInputStream fileInStream = new FileInputStream(fileName);
            DataInputStream dataInStream = new DataInputStream(fileInStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(dataInStream));

            while ((line = br.readLine()) != null) {
                data += line + "\n";
            }
            dataInStream.close();

        } catch (IOException ex) {
            System.err.println("Problem with: " + fileType);
        }
        return data;
    }

}
