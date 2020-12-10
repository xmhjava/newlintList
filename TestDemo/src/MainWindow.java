import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
 
import java.io.FileOutputStream;
public class MainWindow {
	public static void main(String[] args) throws Exception{
        imagePdf("D:\\123.png", "D:\\shenzhen.pdf");
    }
 
    /**
     * 功能描述:
     * @Description:
     * @param urljPG 水印图片
     * @param urlPdf PDF路径
     * @Author: Mr.Jie
     */
    public static void imagePdf(String urljPG, String urlPdf) throws Exception {
        // 获取去除后缀的文件路径
        String fileName = urlPdf.substring(0, urlPdf.lastIndexOf("."));
        System.out.println("==fileName=="+fileName);
        //把截取的路径，后面追加四位随机数
        String pdfUrl = fileName + (int) ((Math.random() * 9 + 1) * 1000) + ".pdf";
        System.out.println("==pdfUrl=="+pdfUrl);
        //要加水印的原pdf文件路径
        PdfReader reader = new PdfReader(urlPdf, "PDF".getBytes());
        //加了水印后要输出的路径
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(pdfUrl));
        // 插入水印
        Image img = Image.getInstance(urljPG);
        //原pdf文件的总页数
        int pageSize = reader.getNumberOfPages();
        //印章位置
        img.setAbsolutePosition(370, 90);
        //印章大小
        img.scalePercent(50);
        for (int i = 1; i <= pageSize; i++) {
            //背景被覆盖
            PdfContentByte under = stamp.getUnderContent(i);
            //文字被覆盖
           // PdfContentByte under = stamp.getOverContent(i);
            //添加电子印章
            under.addImage(img);
        }
        // 关闭
        stamp.close();
        //关闭
        reader.close();
    }
	
	
}
