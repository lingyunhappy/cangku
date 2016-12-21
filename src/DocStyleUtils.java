import java.awt.Color;

import com.lowagie.text.*;



public class DocStyleUtils {

	/**
	 * 
	 * 
	 * ����˵���������������ʽ����ɫΪ��ɫ</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param family
	 *            ��������
	 * 
	 * 
	 * @param size
	 * 
	 *            �����С��22fΪ���ţ�18fΪС���ţ�16fΪ����
	 * 
	 * 
	 * @param style
	 *            ������ʽ
	 * 
	 * 
	 * @return
	 */

	public static Font setFontStyle(String family, float size, int style) {

		return setFontStyle(family, Color.BLACK, size, style);

	}

	/**
	 * 
	 * 
	 * ����˵���������������ʽ</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param family
	 *            ��������
	 * 
	 * 
	 * @param color
	 *            ������ɫ
	 * 
	 * 
	 * @param size
	 * 
	 *            �����С��22fΪ���ţ�18fΪС���ţ�16fΪ����
	 * 
	 * 
	 * @param style
	 *            ������ʽ
	 * 
	 * 
	 * @return
	 */

	public static Font setFontStyle(String family, Color color, float size,
			int style) {

		Font font = new Font();

		font.setFamily(family);


		font.setSize(size);

		font.setStyle(style);

		return font;

	}

	/**
	 * 
	 * 
	 * ����˵����Ϊ�������ǳ��ɫ����</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param content
	 *            ��Ҫ��䱳����ɫ������
	 * 
	 * 
	 * @param appendStr
	 *            ����Ҫ��䱳����ɫ������
	 * 
	 * 
	 * @return
	 */

	private static Phrase setPhraseStyle(String content, String appendStr) {

		Chunk chunk = new Chunk(content);

		// ���ı�����ɫΪǳ��ɫ


		Phrase phrase = new Phrase(chunk);

		phrase.add(appendStr);

		return phrase;

	}

	/**
	 * 
	 * 
	 * ����˵�������ö������ʽ������ǰ������ݺͺ������ݸ�ʽ��һ���Ķ�����ʽ</BR>
	 * 
	 * 
	 * �޸��գ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param content
	 *            ǰ�������
	 * 
	 * 
	 * @param font
	 * 
	 *            �������ʽ
	 * 
	 * 
	 * @param firstLineIndent
	 *            �������������ַ���16fԼ����һ���ַ�
	 * 
	 * 
	 * @param appendStr
	 *            ��������
	 * 
	 * 
	 * @return
	 */

	public static Paragraph setParagraphStyle(String content, Font font,
			float firstLineIndent, String appendStr) {

		Paragraph par = setParagraphStyle(content, font, 0f, 12f);

		Phrase phrase = new Phrase();

		phrase.add(par);

		phrase.add(appendStr);

		Paragraph paragraph = new Paragraph(phrase);

		paragraph.setFirstLineIndent(firstLineIndent);

		// ���ö��뷽ʽΪ���˶���

		paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED_ALL);

		return paragraph;

	}

	/**
	 * 
	 * 
	 * ����˵�������ö������ʽ������ǰ������������ǳ��ɫ�ı�����ɫ����������û�б�����ɫ�Ķ�����ʽ</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param content
	 *            ǰ����б�����ɫ������
	 * 
	 * 
	 * @param font
	 * 
	 *            �������ʽ
	 * 
	 * 
	 * @param firstLineIndent
	 *            �����������ַ���16fԼ����һ���ַ�
	 * 
	 * 
	 * @param leading
	 *            �м��12f��ʾ�����о�
	 * 
	 * 
	 * @param appendStr
	 *            ��������
	 * 
	 * 
	 * @return
	 */

	public static Paragraph setParagraphStyle(String content, Font font,
			float firstLineIndent, float leading, String appendStr) {

		Phrase phrase = setPhraseStyle(content, appendStr);

		Paragraph par = new Paragraph(phrase);

		par.setFont(font);

		par.setFirstLineIndent(firstLineIndent);

		par.setLeading(leading);

		// ���ö��뷽ʽΪ���˶���

		par.setAlignment(Paragraph.ALIGN_JUSTIFIED_ALL);

		return par;

	}

	/**
	 * 
	 * 
	 * ����˵�������ö������ʽ��һ���������ñ���</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param content
	 *            ���������
	 * 
	 * 
	 * @param font
	 * 
	 *            ������ʽ
	 * 
	 * 
	 * @param leading
	 *            �м��
	 * 
	 * 
	 * @param alignment
	 *            ���뷽ʽ
	 * 
	 * 
	 * @return
	 */

	public static Paragraph setParagraphStyle(String content, Font font,
			float leading, int alignment) {

		return setParagraphStyle(content, font, 0f, leading, 0f, alignment);

	}

	/**
	 * 
	 * 
	 * ����˵�������ö������ʽ�����뷽ʽΪ���˶��룬������ʽ���ı�֮��0.2����</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param content
	 *            ���������
	 * 
	 * 
	 * @param font
	 * 
	 *            �������ʽ
	 * 
	 * 
	 * @param firstLineIndent
	 *            �������������ַ���16fԼ����һ���ַ�
	 * 
	 * 
	 * @param leading
	 *            �м��
	 * 
	 * 
	 * @return
	 */

	public static Paragraph setParagraphStyle(String content, Font font,
			float firstLineIndent, float leading) {

		return setParagraphStyle(content, font, firstLineIndent, leading, 0.6f,
				Paragraph.ALIGN_JUSTIFIED_ALL);

	}

	/**
	 * 
	 * 
	 * ����˵�������ö������ʽ</BR>
	 * 
	 * 
	 * �޸����ڣ�2011-04-27
	 * 
	 * 
	 * @author myclover
	 * 
	 * 
	 * @param content
	 *            ���������
	 * 
	 * 
	 * @param font
	 * 
	 *            �������ʽ
	 * 
	 * 
	 * @param firstLineIndent
	 *            �������������ַ���16fԼ����һ���ַ�
	 * 
	 * 
	 * @param leading
	 *            �м��
	 * 
	 * 
	 * @param indentationRight
	 *            ������ʽ�е��ı�֮����ٺ��ף�0.6f�൱��0.2����
	 * 
	 * 
	 * @param alignment
	 *            ���뷽ʽ
	 * 
	 * 
	 * @return
	 */

	public static Paragraph setParagraphStyle(String content, Font font,
			float firstLineIndent, float leading, float indentationRight,
			int alignment) {

		Paragraph par = new Paragraph(content, font);

		par.setFirstLineIndent(firstLineIndent);

		par.setLeading(leading);

		par.setIndentationRight(indentationRight);

		par.setAlignment(alignment);

		return par;

	}
}
