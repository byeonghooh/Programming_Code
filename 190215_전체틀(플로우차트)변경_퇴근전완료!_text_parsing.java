import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // �������̽� Ŭ����, java.util.collection interface ����

public class text_parsing {


	public static void main(String args[]) throws IOException {

	    File file2 = new File("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company\\Writer7.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

		ArrayList<String> list = new ArrayList<String>();

		//		int count = 0;
		String DirectoryPath= " "; // DP

		DirectoryPath = "C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company";

		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles();  // ���ϸ���Ʈ �迭�� �ּ� ����

		for(File f: fileList) { // fileList�� ù��° �ε��� ������ ������
			String str = f.getPath(); // ���� �� ������
			if(f.isDirectory()) {
			}
			else {
				// .txt�� ������ ����(txt ����) ��� ����
				if(str.endsWith(".txt")) 
				{ 	
					System.out.println("txt���� : " + str + "\t" + f.length() + "bytes");
					list.add(str);
				}
			}
		}

		// -------------------------------------------------------------------------------------------

//		File file2 = new File("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company\\Writer3.csv");
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
//
//		String username  = " ";
//		String department = " ";
//		String location = " ";
//		String csvrow = " ";

		String[] UserData =  new String[100]; //  ������� : ���� count ������ ���� ��� �����ϱ�
		String[] UserData2 =  new String[100];
		String[] UserDataStr = new String[100]; // cut before ":"  , cut after "��:"

		for(int k = 0 ; k < list.size() -1; k++)  // ���ϸ���Ʈ�� ������ ���� ���ΰ�.. �⺻������ ���� �ּ� ����..
		{ 
			List<String> ListStr = new ArrayList<String>(); // ListStr�̶�� ArrayList ��ü ����
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // �Է� ��Ʈ��(FileReader ��ü)�� BufferedReader �Ű������� ���, BufferedReader ��ü ����

			int count = 0;
			String s;
			while ( (s = in.readLine()) != null ) // ���� ���� ������ ���� // ������ size ����
			{ // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带 �̿��ؼ� 
				count++;
				ListStr.add(s); // ArrayList ��ü�� ListStr�� ���ڿ��� �߰�, index�� ���ʷ� �Էµ�

				//				System.out.println(" ");

				//				System.out.println(s);
				// System.out.println(ListStr); // ListStr �迭�� ������ �ִ� �ε��� �� ��� ���
			}

			for(int i = 0; i < ListStr.size(); i++) 
			{

				UserData = ListStr.get(i).split(":"); // �ؽ�Ʈ ������ �� ���� :�� �������� �迭�� ���� (2�κ����� ����)
				UserDataStr[i] = UserData[UserData.length-1]; // : ���� ���, ���ϰ� ���� =>  string�̴ϱ� �׳� string���� ����!

				if ( i == 0 && UserData.length-2 != -1 && 
						!( (ListStr.get(0).contains("�а�")) ||  (ListStr.get(0).contains("�л�")) || (ListStr.get(0).contains("����")) ) )  { // ����� ��� ����ڸ� �� if���� ����ǵ��� �س�����

					UserDataStr[0] = UserData[UserData.length-2].trim(); // 0���� ���� �Ǵ� �̽� �߻�, ȸ�� �Ұ� or Ȩ������ �ּ�
					UserDataStr[1] = UserData[UserData.length-1].trim(); // Ȩ������ �ּ� or ȸ�� �Ұ�
					UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // ���ڿ� ��ġ�� (�̽� �ذ�)
					//username = UserDataStr[0];

				}

				else { // if �����ϰ� ��� ����� (no problem)
					UserData2 = UserData[UserData.length-1].split("\\(��"); // UserData�� �� �κ��� ����ؾ� �Ѵٴ� ���� �˾��� ���� ������ ( ������ Ž�� ��� �ʿ��� ��!)
					UserDataStr[i] = UserData2[0];

				}
				UserDataStr[i] = UserDataStr[i].trim();
			}
			
			for(int i = 0; i < ListStr.size() ; i++) 
			{
				//				count++;
				//				System.out.print(" " + count + " ");
				System.out.println(UserDataStr[i]) ; // ���������� �츮�� ����� �ϴ� ��
//				System.out.println(ListStr.size());
				
			}

//			for(int i = 0; i <ListStr.size(); i++) {

				if(file2.isFile() && file2.canWrite() ) 
				{
					bufferedWriter.write("\"" +  UserDataStr[0] + "\"" + "\t" +"\"" +  UserDataStr[1] + "\"" + "\t" +"\"" +  UserDataStr[2] + "\"" 
													+ "\t" +"\"" +  UserDataStr[3] + "\"" + "\t" +"\"" +  UserDataStr[4] + "\"" + "\t" +"\"" +  UserDataStr[5] + "\"");
					bufferedWriter.newLine();	

				}
//			}
				
			

			}
		bufferedWriter.close();
		}
}
	