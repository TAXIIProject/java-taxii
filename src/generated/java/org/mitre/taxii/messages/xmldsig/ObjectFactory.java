
package org.mitre.taxii.messages.xmldsig;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.mitre.taxii.messages.xmldsig package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MgmtData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "MgmtData");
    private final static QName _KeyName_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyName");
    private final static QName _DigestValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestValue");
    private final static QName _SignatureMethodHMACOutputLength_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "HMACOutputLength");
    private final static QName _X509DataX509IssuerSerial_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509IssuerSerial");
    private final static QName _X509DataX509Certificate_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509Certificate");
    private final static QName _X509DataX509SKI_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SKI");
    private final static QName _X509DataX509SubjectName_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SubjectName");
    private final static QName _X509DataX509CRL_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509CRL");
    private final static QName _TransformXPath_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "XPath");
    private final static QName _SPKIDataSPKISexp_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SPKISexp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mitre.taxii.messages.xmldsig
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KeyInfo }
     * 
     */
    public KeyInfo createKeyInfo() {
        return new KeyInfo();
    }

    /**
     * Create an instance of {@link KeyValue }
     * 
     */
    public KeyValue createKeyValue() {
        return new KeyValue();
    }

    /**
     * Create an instance of {@link DSAKeyValue }
     * 
     */
    public DSAKeyValue createDSAKeyValue() {
        return new DSAKeyValue();
    }

    /**
     * Create an instance of {@link RSAKeyValue }
     * 
     */
    public RSAKeyValue createRSAKeyValue() {
        return new RSAKeyValue();
    }

    /**
     * Create an instance of {@link RetrievalMethod }
     * 
     */
    public RetrievalMethod createRetrievalMethod() {
        return new RetrievalMethod();
    }

    /**
     * Create an instance of {@link Transforms }
     * 
     */
    public Transforms createTransforms() {
        return new Transforms();
    }

    /**
     * Create an instance of {@link Transform }
     * 
     */
    public Transform createTransform() {
        return new Transform();
    }

    /**
     * Create an instance of {@link X509Data }
     * 
     */
    public X509Data createX509Data() {
        return new X509Data();
    }

    /**
     * Create an instance of {@link X509IssuerSerialType }
     * 
     */
    public X509IssuerSerialType createX509IssuerSerialType() {
        return new X509IssuerSerialType();
    }

    /**
     * Create an instance of {@link PGPData }
     * 
     */
    public PGPData createPGPData() {
        return new PGPData();
    }

    /**
     * Create an instance of {@link SPKIData }
     * 
     */
    public SPKIData createSPKIData() {
        return new SPKIData();
    }

    /**
     * Create an instance of {@link SignedInfo }
     * 
     */
    public SignedInfo createSignedInfo() {
        return new SignedInfo();
    }

    /**
     * Create an instance of {@link CanonicalizationMethod }
     * 
     */
    public CanonicalizationMethod createCanonicalizationMethod() {
        return new CanonicalizationMethod();
    }

    /**
     * Create an instance of {@link SignatureMethod }
     * 
     */
    public SignatureMethod createSignatureMethod() {
        return new SignatureMethod();
    }

    /**
     * Create an instance of {@link Reference }
     * 
     */
    public Reference createReference() {
        return new Reference();
    }

    /**
     * Create an instance of {@link DigestMethod }
     * 
     */
    public DigestMethod createDigestMethod() {
        return new DigestMethod();
    }

    /**
     * Create an instance of {@link Signature }
     * 
     */
    public Signature createSignature() {
        return new Signature();
    }

    /**
     * Create an instance of {@link SignatureValue }
     * 
     */
    public SignatureValue createSignatureValue() {
        return new SignatureValue();
    }

    /**
     * Create an instance of {@link Object }
     * 
     */
    public Object createObject() {
        return new Object();
    }

    /**
     * Create an instance of {@link Manifest }
     * 
     */
    public Manifest createManifest() {
        return new Manifest();
    }

    /**
     * Create an instance of {@link SignatureProperty }
     * 
     */
    public SignatureProperty createSignatureProperty() {
        return new SignatureProperty();
    }

    /**
     * Create an instance of {@link SignatureProperties }
     * 
     */
    public SignatureProperties createSignatureProperties() {
        return new SignatureProperties();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "MgmtData")
    public JAXBElement<String> createMgmtData(String value) {
        return new JAXBElement<String>(_MgmtData_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyName")
    public JAXBElement<String> createKeyName(String value) {
        return new JAXBElement<String>(_KeyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DigestValue")
    public JAXBElement<byte[]> createDigestValue(byte[] value) {
        return new JAXBElement<byte[]>(_DigestValue_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "HMACOutputLength", scope = SignatureMethod.class)
    public JAXBElement<BigInteger> createSignatureMethodHMACOutputLength(BigInteger value) {
        return new JAXBElement<BigInteger>(_SignatureMethodHMACOutputLength_QNAME, BigInteger.class, SignatureMethod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X509IssuerSerialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509IssuerSerial", scope = X509Data.class)
    public JAXBElement<X509IssuerSerialType> createX509DataX509IssuerSerial(X509IssuerSerialType value) {
        return new JAXBElement<X509IssuerSerialType>(_X509DataX509IssuerSerial_QNAME, X509IssuerSerialType.class, X509Data.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509Certificate", scope = X509Data.class)
    public JAXBElement<byte[]> createX509DataX509Certificate(byte[] value) {
        return new JAXBElement<byte[]>(_X509DataX509Certificate_QNAME, byte[].class, X509Data.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509SKI", scope = X509Data.class)
    public JAXBElement<byte[]> createX509DataX509SKI(byte[] value) {
        return new JAXBElement<byte[]>(_X509DataX509SKI_QNAME, byte[].class, X509Data.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509SubjectName", scope = X509Data.class)
    public JAXBElement<String> createX509DataX509SubjectName(String value) {
        return new JAXBElement<String>(_X509DataX509SubjectName_QNAME, String.class, X509Data.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509CRL", scope = X509Data.class)
    public JAXBElement<byte[]> createX509DataX509CRL(byte[] value) {
        return new JAXBElement<byte[]>(_X509DataX509CRL_QNAME, byte[].class, X509Data.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "XPath", scope = Transform.class)
    public JAXBElement<String> createTransformXPath(String value) {
        return new JAXBElement<String>(_TransformXPath_QNAME, String.class, Transform.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SPKISexp", scope = SPKIData.class)
    public JAXBElement<byte[]> createSPKIDataSPKISexp(byte[] value) {
        return new JAXBElement<byte[]>(_SPKIDataSPKISexp_QNAME, byte[].class, SPKIData.class, ((byte[]) value));
    }

}
