package cn.guxiangfly.shiyan.kaoshi;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.FileWriter;
import java.io.Writer;

import org.dom4j.io.XMLWriter;
/**
 * XmlTest
 *
 * @author guxiang
 * @date 2018/1/3
 */
public class XmlTest {

    @Test
    public void testRead() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("D:\\IntellijIDEAWorkSpace\\JavaHomeWork\\src\\main\\resources\\book.xml");
        Element rootElement = document.getRootElement();
        Object shu = rootElement.element("书").element("书名").getText();
        System.out.println(shu);

        Element book2 = rootElement.addElement("书");
        book2.addAttribute("出版社","淮阴工学院");
        Element bookname = book2.addElement("书名");
        bookname.setText("凌迎港自传");
        XMLWriter writer = new XMLWriter(new FileWriter("D:\\IntellijIDEAWorkSpace\\JavaHomeWork\\src\\main\\resources\\book2.xml"));
        writer.write(document);
        writer.close();
    }
}
