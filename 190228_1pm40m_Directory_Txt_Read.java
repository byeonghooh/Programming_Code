import java.io.File;
import java.util.ArrayList;

public class Directory_Txt_Read {

	private int Number_Of_Txt_File = 0;

	public ArrayList<String> Txt_Read_In_Directory(String DirectoryPath) {

		ArrayList<String> list = new ArrayList<String>();

		// ���� ��� ����
		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles(); // ���ϸ���Ʈ �迭�� �ּ� ����

		for (File f : fileList) { // fileList�� ù��° �ε��� ������ ������
			String str = f.getPath(); // ���� �� ������
			if (f.isDirectory()) {
			} 
			else {
				// .txt�� ������ ����(txt ����) ��� ����
				if (str.endsWith(".txt") && str.contains("Ű�߱޽�û")) {
					Number_Of_Txt_File++;
					System.out.println(Number_Of_Txt_File + "��°" + " " + "txt���� : " + str + "\t" + f.length() + "bytes");
					list.add(str);
				}
			}
		}
		return list;
	}

}
