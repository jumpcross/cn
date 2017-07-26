package com.hc.cn.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.License;
import com.aspose.pdf.SaveFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 由于ASPOSE比较吃内存，操作大一点的文件就会堆溢出，所以请先设置好java虚拟机参数：-Xms1024m -Xmx1024m(参考值)<br>
 * 如有疑问，请在CSDN下载界面留言,或者联系QQ569925980<br>
 * 
 * @author Spark
 *
 */
public class PdfTool {

    private static InputStream license;
    private static InputStream pdf;

    /**
     * 获取license
     * 
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            license = PdfTool.class.getClassLoader().getResourceAsStream("\\license.xml");// license路径

            License aposeLic = new License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void saveFile(MultipartFile pdffile, String filePath) {
        // 验证License
        if (!getLicense()) {
            return;
        }

        try {
            long old = System.currentTimeMillis();
            pdf = pdffile.getInputStream();
            Document pdfDocument = new Document(pdf);
            File file = new File(filePath);// 输出路径
            FileOutputStream fileOS = new FileOutputStream(file);

            pdfDocument.save(fileOS, SaveFormat.DocX);

            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒\n\n" + "文件保存在:" + file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}