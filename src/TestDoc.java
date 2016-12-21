import java.io.FileOutputStream;


import com.lowagie.text.Element;
import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;


public class TestDoc {

	/**
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		exportDoc("D:\\test.doc");

	}

	public static void exportDoc(String fileName) {

		try {

			com.lowagie.text.Document doc = new com.lowagie.text.Document();

			RtfWriter2.getInstance(doc, new FileOutputStream(fileName));

			// ���ĵ�

			doc.open();

			// ����ҳ�߾࣬�ϡ���25.4���ף���Ϊ72f������31.8���ף���Ϊ90f

			doc.setMargins(90f, 90f, 72f, 72f);

			// ���ñ���������ʽ�����塢���š���������

			Font tfont = DocStyleUtils.setFontStyle("��������", 22f, Font.BOLD);

			// �����������ݵ�������ʽ�����桢���š�����_GB2312

			Font bfont = DocStyleUtils.setFontStyle("����_GB2312", 16f,
					Font.NORMAL);

			// �������⣬���ж��룬12f��ʾ�����о�

			Paragraph title = DocStyleUtils.setParagraphStyle(
					"����Itext����Word�ĵ�", tfont, 12f, Paragraph.ALIGN_CENTER);
			Chapter chapter1 = new Chapter(title, 1);
			 chapter1.setBookmarkOpen(true);       
			// ������������

			StringBuffer contentSb = new StringBuffer();

			contentSb.append("�����Ŀ��æ���������Ŀ��ʹ�õ��ģ����������ܽ�һ�£��Ա�����Բο�ʹ�ã�");

			contentSb.append("2011��4��27�� �� 2011��5��20�գ������¼�������ʹ�ã�");

			contentSb.append("Itext��");

			contentSb.append("Excel��");

			contentSb.append("Word��");

			contentSb.append("PPT��");

			// ��������2�ַ����м��1.5���о�

			Paragraph bodyPar = DocStyleUtils.setParagraphStyle(contentSb
					.toString(), bfont, 32f, 18f);

			Paragraph bodyEndPar = DocStyleUtils.setParagraphStyle(
					"����2011��4��28�գ����ּ����Ѿ���ȫʵ�֡�", bfont, 32f, 18f);

			// ���ÿ���

			Paragraph blankRow = new Paragraph(18f, " ", bfont);

			Paragraph deptPar = DocStyleUtils.setParagraphStyle("���������������£�",
					bfont, 12f, Paragraph.ALIGN_RIGHT);

			Paragraph datePar = DocStyleUtils.setParagraphStyle("2011-04-30",
					bfont, 12f, Paragraph.ALIGN_RIGHT);

			// ���ĵ����������
			
			doc.add((Element) chapter1);

		
			// ���һ��Ҫ��ס�ر�

			doc.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
