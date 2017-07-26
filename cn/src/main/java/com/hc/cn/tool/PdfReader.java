package com.hc.cn.tool;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfReader {
public void writeDocument(String content,String filePath){
    File file=new File(filePath);
        FileOutputStream out = null;
        try {
            if(!file.exists())
            file.createNewFile();
             out=new FileOutputStream(file,false);
            out.write(content.getBytes("utf-8"));
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
public String getFileContent(String filePath){
    File pdfFile = new File(filePath);
    PDDocument document = null;
    String content = null;
    try
    {
        // 方式一：
        /**
         InputStream input = null;
         input = new FileInputStream( pdfFile );
         //加载 pdf 文档
         PDFParser parser = new PDFParser(new RandomAccessBuffer(input));
         parser.parse();
         document = parser.getPDDocument();
         **/

        // 方式二：
        document=PDDocument.load(pdfFile);

        // 获取页码
        int pages = document.getNumberOfPages();

        // 读文本内容
        PDFTextStripper stripper=new PDFTextStripper();
        // 设置按顺序输出
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(pages);
         content = stripper.getText(document);

    }
    catch(Exception e)
    {

    }
    return  content;
}
    public static void main(String[] args){
        PdfReader pdfReader = new PdfReader();
        String content = pdfReader.getFileContent("D:/charlie.pdf");
        pdfReader.writeDocument(content,"D:/test.doc");

    }

}