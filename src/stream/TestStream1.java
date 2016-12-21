package stream;
import java.io.*;

public class TestStream1 {
	public static void main(String[] args) throws IOException {
        // �ڵ���FileOutputStreamֱ����A.txt��Ϊ����Դ����
        FileOutputStream fileOutputStream = new FileOutputStream("A.txt");
        // ������BufferedOutputStream��һ��װ�νڵ������ṩ����д
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                fileOutputStream);
        // ������DataOutputStream��һ��װ�ι�������ʹ���ṩ�����������͵�д
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeInt(3);
        out.writeBoolean(true);
        out.writeBytes("1234567");
        out.flush();
        out.close();
        // �˴�����ڵ��������������ø��ϱ������Ӧ�����߿ɾ�һ����
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("A.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readBoolean());
        in.close();
}
}
