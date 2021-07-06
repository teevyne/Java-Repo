import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class XMLGenerator {

    private static final int PRIVATE_KEY = 1;
    private static final int PUBLIC_KEY = 2;
    private static final String[] PRIVATE_KEY_XML_NODES =  { "Modulus", "Exponent", "P", "Q", "DP", "DQ", "InverseQ", "D" };
    private static final String[] PUBLIC_KEY_XML_NODES =  { "Modulus", "Exponent" };

    public static void main(String args[]) {

//        if (args.length != 1) {
//            System.out.println("Usage:\njava XMLSec2PEM <XMLSecurityRSAKeyValueFile.xml>");
//            System.exit(0) ;
//        }

        try
        {
            Document XMLSecKeyDoc = parseXMLFile(args[0]);
            System.out.print("Determining the key type: ");
            int keyType = 0;
            if (XMLSecKeyDoc != null) {
                keyType = getKeyType(XMLSecKeyDoc);
            }
            if (keyType == PRIVATE_KEY || keyType == PUBLIC_KEY) {
                System.out.println("seems to be a " + ( keyType == PRIVATE_KEY ? "private" : "public" ) + " XML Security key");
            } else {
                System.exit(1);
            }

            System.out.print("Checking the XML file structure: ");
            if (checkXMLRSAKey(keyType, XMLSecKeyDoc)) {
                System.out.println("OK");
            } else {
                System.exit(1);
            }

            String pem;
            System.out.println("Outputting the resulting key:\n");
            if (keyType == PRIVATE_KEY) {
                pem = convertXMLRSAPrivateKeyToPEM(XMLSecKeyDoc);
                System.out.println("-----BEGIN PRIVATE KEY-----");
                System.out.println(pem);
                System.out.println("-----END PRIVATE KEY-----");
            } else {
                pem = convertXMLRSAPublicKeyToPEM(XMLSecKeyDoc);
                System.out.println("-----BEGIN PUBLIC KEY-----");
                System.out.println(pem);
                System.out.println("-----END PUBLIC KEY-----");
            }

        }

        catch (Exception e) {
            System.err.println("Exception from line 65");
        }
    }

    private static int getKeyType(Document xmldoc) {

        Node root = xmldoc.getFirstChild();
        if (!root.getNodeName().equals("RSAKeyValue")) {
            System.out.println("Expecting <RSAKeyValue> node, encountered <" + root.getNodeName() + ">");
            return 0;
        }
        NodeList children = root.getChildNodes();
        if (children.getLength() == PUBLIC_KEY_XML_NODES.length) {
            return PUBLIC_KEY;
        }
        return PRIVATE_KEY;

    }

    private static boolean checkXMLRSAKey(int keyType, Document xmldoc) {

        Node root = xmldoc.getFirstChild();
        NodeList children = root.getChildNodes();
        String[] wantedNodes;
        if (keyType == PRIVATE_KEY) {
            wantedNodes = PRIVATE_KEY_XML_NODES;
        } else {
            wantedNodes = PUBLIC_KEY_XML_NODES;
        }
//        for (int j = 0; j < wantedNodes.length; j++) {
        for (int j = 0; j < wantedNodes.length; j++) {
            String wantedNode = wantedNodes[j];
            boolean found = false;
            for (int i = 0; i < children.getLength(); i++) {
                if (children.item(i).getNodeName().equals(wantedNode)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Cannot find node <" + wantedNode + ">");
                return false;
            }
        }
        return true;

    }

    private static String convertXMLRSAPrivateKeyToPEM(Document xmldoc) {

        Node root = xmldoc.getFirstChild();
        NodeList children = root.getChildNodes();

        BigInteger modulus = null, exponent = null, primeP = null, primeQ = null,
                primeExponentP = null, primeExponentQ = null,
                crtCoefficient = null, privateExponent = null;

        for (int i = 0; i < children.getLength(); i++) {

            Node node = children.item(i);
            String textValue = node.getTextContent();
            switch (node.getNodeName()) {
                case "Modulus":
                    modulus = new BigInteger(b64decode(textValue));
                    break;
                case "Exponent":
                    exponent = new BigInteger(b64decode(textValue));
                    break;
                case "P":
                    primeP = new BigInteger(b64decode(textValue));
                    break;
                case "Q":
                    primeQ = new BigInteger(b64decode(textValue));
                    break;
                case "DP":
                    primeExponentP = new BigInteger(b64decode(textValue));
                    break;
                case "DQ":
                    primeExponentQ = new BigInteger(b64decode(textValue));
                    break;
                case "InverseQ":
                    crtCoefficient = new BigInteger(b64decode(textValue));
                    break;
                case "D":
                    privateExponent = new BigInteger(b64decode(textValue));
                    break;
            }

        }

        try {

            RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec (
                    modulus, exponent, privateExponent, primeP, primeQ,
                    primeExponentP, primeExponentQ, crtCoefficient);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey key = keyFactory.generatePrivate(keySpec);
            return b64encode(key.getEncoded());

        } catch (Exception e) {
            System.out.println("Exception encountered" + e);
        }
        return null;

    }

    private static String convertXMLRSAPublicKeyToPEM(Document xmldoc) {

        Node root = xmldoc.getFirstChild();
        NodeList children = root.getChildNodes();

        BigInteger modulus = null, exponent = null;

        for (int i = 0; i < children.getLength(); i++) {

            Node node = children.item(i);
            String textValue = node.getTextContent();
            if (node.getNodeName().equals("Modulus")) {
                modulus = new BigInteger(b64decode(textValue));
            } else if (node.getNodeName().equals("Exponent")) {
                exponent = new BigInteger(b64decode(textValue));
            }

        }

        try {

            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(keySpec);
            return b64encode(key.getEncoded());

        } catch (Exception e) {
            System.out.println("Another exception encountered" + e);
        }
        return null;

    }

    private static Document parseXMLFile(String filename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse( new File(filename) );
        } catch(Exception e) {
            System.err.println("Yet another error met jere" + e);
            return null;
        }
    }

    private static String b64encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data).trim();
    }

    private static byte[] b64decode(String data) {
        return Base64.getDecoder().decode(data.trim());
    }
}