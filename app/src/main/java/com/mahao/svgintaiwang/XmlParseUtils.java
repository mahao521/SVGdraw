package com.mahao.svgintaiwang;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by mahao on 17/6/1.
 */

public class XmlParseUtils {

    private List<ProvinceBean> mList;


    /**
     *  dom解析
     * @param inputStream
     * @return
     */

    public List<ProvinceBean> domParseXml(InputStream inputStream){


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document parse = documentBuilder.parse(inputStream);
            NodeList childNodes = parse.getChildNodes();

            mList = new ArrayList<>();
            for(int i = 0; i < childNodes.getLength(); i++){

                Element element = (Element) childNodes.item(i);
                String path = element.getAttribute("pathData");
                ProvinceBean provinceBean = new ProvinceBean();
                provinceBean.setPath(path);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mList;
    }



    public void SaxParseXml(InputStream inputStream){


        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(inputStream, new );



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Saxhanlder extends DefaultHandler{


        private String preTag; //作用：记住解析上一个节点的名称
        private ProvinceBean mProvince;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();

            mList = new ArrayList<>();

        }


        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {


            if(qName.equals("path")){

                mProvince = new ProvinceBean();
                String path = attributes.getValue(3);
                mProvince.setPath(path);
            }
            preTag = qName;
        }


        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);

            if("path".equals(qName)){

               mList.add(mProvince);
               mProvince = null;

            }

            preTag = null;  //能够跳出内层的循环

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if(preTag != null){



            }
        }
    }



}
