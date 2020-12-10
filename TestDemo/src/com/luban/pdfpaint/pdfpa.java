package com.luban.pdfpaint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class pdfpa {
public static void main(String[] args) throws Exception {
	 // 模板文件路径
    String templatePath = "C:\\Users\\asus\\Desktop\\shenzhen.pdf";
    // 生成的文件路径
    String targetPath = "C:\\Users\\asus\\Desktop\\target.pdf";
    // 书签名
    String fieldName = "field";
    // 图片路径
    String imagePath = "‪C:\\Users\\asus\\Desktop\\789.jpg";
 
    // 读取模板文件
    InputStream input = new FileInputStream(new File(templatePath));
    PdfReader reader = new PdfReader(input);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(targetPath));
    // 提取pdf中的表单
    AcroFields form = stamper.getAcroFields();
    form.addSubstitutionFont(BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));
 
    // 通过域名获取所在页和坐标，左下角为起点
    int pageNo = form.getFieldPositions(fieldName).get(0).page;
    Rectangle signRect = form.getFieldPositions(fieldName).get(0).position;
    float x = signRect.getLeft();
    float y = signRect.getBottom();
 
    // 读图片
    Image image = Image.getInstance(imagePath);
    // 获取操作的页面
    PdfContentByte under = stamper.getOverContent(pageNo);
    // 根据域的大小缩放图片
    image.scaleToFit(signRect.getWidth(), signRect.getHeight());
    // 添加图片
    image.setAbsolutePosition(x, y);
    under.addImage(image);
 
    stamper.close();
    reader.close();
}
}
