/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerator;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Erich Stark
 */
public class GeneratorUI extends javax.swing.JFrame {

    String xmlko;
    String xsdecko;
    String xslko;

    String autori = "Na aplikácii pracovali:" + "\n"
            + "Jakub Rehák" + "\n" + "Erich Stark" + "\n" + "Ivan Polačik";

    /**
     * Creates new form generatorUI
     */
    public GeneratorUI() throws IOException {

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        textFieldCountryName = new javax.swing.JTextField();
        textFieldRozloha = new javax.swing.JTextField();
        textFieldCitizenNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddToXML = new javax.swing.JButton();
        textFieldCountryLink = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        labelWarMessages = new javax.swing.JLabel();
        btnSignXML = new javax.swing.JButton();
        btnTimeStamp = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        openSchema = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        generateTxtToFile = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XML Tool");
        setResizable(false);

        textFieldRozloha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRozlohaActionPerformed(evt);
            }
        });

        jLabel1.setText("Názov štátu:");

        jLabel2.setText("Rozloha:");

        jLabel3.setText("Počet obyvateľov:");

        btnAddToXML.setText("Pridať do XML");
        btnAddToXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToXMLActionPerformed(evt);
            }
        });

        jLabel4.setText("Odkaz na krajinu:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        btnSignXML.setText("Podpísať");
        btnSignXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignXMLActionPerformed(evt);
            }
        });

        btnTimeStamp.setText("Pečiatka");
        btnTimeStamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeStampActionPerformed(evt);
            }
        });

        jMenu3.setText("XML");

        open.setText("Otvoriť");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jMenu3.add(open);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Validacia");

        openSchema.setText("Výber schémy");
        openSchema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSchemaActionPerformed(evt);
            }
        });
        jMenu1.add(openSchema);

        jMenuItem1.setText("Validácia");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("TXT");

        jMenuItem3.setText("Načítanie XSL");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        generateTxtToFile.setText("Generovanie TXT do súboru");
        generateTxtToFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateTxtToFileActionPerformed(evt);
            }
        });
        jMenu2.add(generateTxtToFile);

        jMenuItem6.setText("Generovanie TXT do pop-up");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Help");

        jMenuItem5.setText("Pomocnik");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("About");

        jMenuItem4.setText("O nás");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelWarMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAddToXML, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4))
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldCountryLink, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldRozloha, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldCitizenNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane2)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimeStamp)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignXML, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldRozloha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldCitizenNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldCountryLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelWarMessages, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToXML, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignXML)
                    .addComponent(btnTimeStamp))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openSchemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSchemaActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            xsdecko = file.getPath();

        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openSchemaActionPerformed

    private void btnAddToXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToXMLActionPerformed
        try {
            createElement();

        } catch (TransformerException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAddToXMLActionPerformed

    private void textFieldRozlohaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRozlohaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRozlohaActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            xmlko = file.getName();
            refreshXml(xmlko);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        validateXSD();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void generateTxtToFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateTxtToFileActionPerformed
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xsl = new StreamSource(new File(xslko));
            Transformer transformer = factory.newTransformer(xsl);

            Source text = new StreamSource(new File(xmlko));
            transformer.transform(text, new StreamResult(new File("staty.txt")));
            labelWarMessages.setForeground(Color.green);
            labelWarMessages.setText("Vygenerovali ste staty.txt");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            labelWarMessages.setForeground(Color.red);
            labelWarMessages.setText("Pre generovanie txt treba zvoliť XSL");
        }

    }//GEN-LAST:event_generateTxtToFileActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            xslko = file.getPath();

        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JOptionPane.showMessageDialog(null, autori,
                "Autori", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String addToXml = "Pridanie štátu do XML:\n1. XML->Otvoriť \n2. Vyplniť údaje a potvdiť.\n\n";
        String validate = "Validácia schémy:\n1. Validácia->Výber schémy\n2. Validácia\n\n";
        String textGener = "Generovanie textu:\n1. TXT->Načítanie XSL\n2. Generovanie TXT";

        JOptionPane.showMessageDialog(null, addToXml + validate + textGener, "Pomocník", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            StringWriter outWriter = new StringWriter();
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xsl = new StreamSource(new File(xslko));
            Transformer transformer = factory.newTransformer(xsl);

            Source text = new StreamSource(new File(xmlko));
            transformer.transform(text, new StreamResult(outWriter));
            String output = outWriter.toString();
            labelWarMessages.setForeground(Color.green);
            labelWarMessages.setText("Vygenerovali ste staty do pop-up okna");
            JOptionPane.showMessageDialog(null, output, "Transformácia do textu", JOptionPane.INFORMATION_MESSAGE);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            labelWarMessages.setForeground(Color.red);
            labelWarMessages.setText("Pre generovanie txt treba zvoliť XSL");
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnSignXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignXMLActionPerformed
        new SignDispatch(xsdecko, xslko, xmlko).Sign();
        
    }//GEN-LAST:event_btnSignXMLActionPerformed

    private void btnTimeStampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeStampActionPerformed

        try {
            new SignDispatch(xsdecko, xslko, xmlko).SignTimeStamp();
        } catch (SAXException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimeStampActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GeneratorUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private void validateXSD() {
        try {
            Schema schema = null;
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = fact.newDocumentBuilder();
            doc = docBuilder.parse(new FileInputStream(xmlko));

            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);

            schema = factory.newSchema(new File(xsdecko));

            Validator validator = schema.newValidator();

            validator.validate(new DOMSource(doc));
            labelWarMessages.setForeground(Color.green);
            labelWarMessages.setText("Vas subor XML je validny");

        } catch (IOException | ParserConfigurationException | SAXException e) {

            labelWarMessages.setForeground(Color.red);
            labelWarMessages.setText("Validacia je neuspesna.Skontrolujte XSD alebo XML");

        }
    }

    private void refreshXml(String xmlko) {
        try {
            jTextArea2.setText("");
            FileReader f;
            System.out.print(xmlko);
            f = new FileReader(xmlko);

            BufferedReader b = new BufferedReader(f);

            boolean eof = false;

            while (!eof) {
                String lineIn = b.readLine();
                if (lineIn == null) {
                    eof = true;
                } else {
                    jTextArea2.append(lineIn + "\n");
                }
            }
        } catch (FileNotFoundException ex) {
            labelWarMessages.setText("Nieje zvolene XML na pracu");
        } catch (IOException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);
            labelWarMessages.setText("Nieje zvolene XML na pracu");
        }
    }

    ////
    public void createElement() throws TransformerConfigurationException, TransformerException {
        try {
            Country country = new Country();
            country.setNazov(textFieldCountryName.getText());
            country.setRozloha(textFieldRozloha.getText());
            country.setPocetObyvatelov(textFieldCitizenNumber.getText());
            country.setLink(textFieldCountryLink.getText());

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = null;
            try {
                document = documentBuilder.parse(xmlko);
            } catch (SAXException | IOException ex) {
                Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);

            } catch (Exception e) {
                labelWarMessages.setForeground(Color.red);
                labelWarMessages.setText("Nezvolili ste XML na pracu");
            }
            Element root = document.getDocumentElement();

            // Root Element
            Element rootElement = document.getDocumentElement();

            // server elements
            Element stat = document.createElement("stat");
            stat.setAttribute("link", country.getLink());
            rootElement.appendChild(stat);

            Element nazov = document.createElement("nazov");
            Element pocetObyvatelov = document.createElement("pocetObyvatelov");
            Element rozloha = document.createElement("rozloha");

            nazov.appendChild(document.createTextNode(country.getNazov()));
            stat.appendChild(nazov);

            rozloha.appendChild(document.createTextNode(country.getRozloha()));
            stat.appendChild(rozloha);

            pocetObyvatelov.appendChild(document.createTextNode(country.getPocetObyvatelov()));
            stat.appendChild(pocetObyvatelov);
            root.appendChild(stat);

            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(xmlko);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            labelWarMessages.setText("");
            refreshXml(xmlko);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GeneratorUI.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToXML;
    private javax.swing.JButton btnSignXML;
    private javax.swing.JButton btnTimeStamp;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuItem generateTxtToFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel labelWarMessages;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem openSchema;
    private javax.swing.JTextField textFieldCitizenNumber;
    private javax.swing.JTextField textFieldCountryLink;
    private javax.swing.JTextField textFieldCountryName;
    private javax.swing.JTextField textFieldRozloha;
    // End of variables declaration//GEN-END:variables

}
