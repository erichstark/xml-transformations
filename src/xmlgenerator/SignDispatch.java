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
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.bouncycastle.tsp.TimeStampResponse;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.util.encoders.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SignDispatch {
    String xsdName;
    String xslName;
    String xmlName;
    

    public SignDispatch(String xsdName, String xslName, String xmlName) {
        this.xsdName = xsdName;
        this.xslName = xslName;
        this.xmlName = xmlName;
    }
    
    public void Sign() {
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

    private static String getTimestamp(java.lang.String dataB64) {
        ws.TS service = new ws.TS();
        ws.TSSoap port = service.getTSSoap();
        return port.getTimestamp(dataB64);
    }

    public void SignTimeStamp() throws SAXException, ParserConfigurationException, IOException {
        //String ocspUrl = "http://test.ditec.sk/timestampws/TS.ampx";
        byte[] digest = getZnacka().getBytes();
        //OutputStream out = null;

        try {
            String str = getTimestamp(new String(Base64.encode(digest)));
            byte[] out = Base64.decode(str.getBytes());
            TimeStampResponse tsresp = new TimeStampResponse(out);
            TimeStampToken tsToken = tsresp.getTimeStampToken();
            VlozPeciatku(new String(Base64.encode(tsToken.getEncoded())));
            System.out.println("Opeciatkovane");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getZnacka() throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse("podpisane.xml");
        NodeList a = ((Element) doc.getElementsByTagName("ds:Signature").item(0)).getElementsByTagName("ds:SignatureValue");
        Element b = (Element) a.item(0);
        NodeList c = b.getChildNodes();
        String retazec = new String(((Node) c.item(0)).getNodeValue());
        return retazec;
    }

    private void VlozPeciatku(String strPeciatka) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("podpisane.xml");
            Node qN = doc.getElementsByTagName("xades:QualifyingProperties").item(0);
            Element uN = doc.createElement("xades:UnsignedProperties");
            qN.appendChild(uN);
            qN = doc.getElementsByTagName("xades:UnsignedProperties").item(0);
            uN = doc.createElement("xades:UnsignedSignatureProperties");
            qN.appendChild(uN);
            qN = doc.getElementsByTagName("xades:UnsignedSignatureProperties").item(0);
            uN = doc.createElement("xades:SignatureTimeStamp");
            qN.appendChild(uN);
            qN = doc.getElementsByTagName("xades:SignatureTimeStamp").item(0);
            uN = doc.createElement("xades:EncapsulatedTimeStamp");
            uN.appendChild(doc.createTextNode(strPeciatka));
            uN.setAttribute("Id", "IdTimeStamp");
            qN.appendChild(uN);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(new File("podpisaneTS.xml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
