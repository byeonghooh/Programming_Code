
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // �������̽� Ŭ����, java.util.collection interface ����

public class Text_UserData_Parsing {

	public static void main(String[] args) throws IOException {

		int count = 0;
		int count1 = 0;
		int count2 = 0;
		
		
		
		String User_Divider = " ";
		String User_Name = " ";
		String Email_Address = " ";
		String Institution = " ";
		String Institution_Department = " ";
		String Institution_Location_OR_UserResidence = " ";
		String Duty_OR_Research = " ";
		String Key_Issuance_Purpose = " ";
		String Service_Access_Path = " ";
		String Institution_Information_Homepage_Address = " ";

		String User_Divider_Value[] = new String[10];
		String User_Name_Value[] = new String[10];
		String Email_Address_Value[] = new String[10];
		String Institution_Value[] = new String[10];
		String I_D_V[] = new String[10];
		String Institution_Location_OR_UserResidence_Value[] = new String[10];
		String Duty_OR_Research_Value[] = new String[10];
		String Key_Issuance_Purpose_Value[] = new String[10];
		String Service_Access_Path_Value[] = new String[10];
		String Institution_Information_Homepage_Address_Value[] = new String[10];

		for (int i = 0; i < User_Name_Value.length; i++) {
			User_Divider_Value[i] = null;
			User_Name_Value[i] = null;
			Email_Address_Value[i] = null;
			Institution_Value[i] = null;
			I_D_V[i] = null;
			Institution_Location_OR_UserResidence_Value[i] = null;
			Duty_OR_Research_Value[i] = null;
			Key_Issuance_Purpose_Value[i] = null;
			Service_Access_Path_Value[i] = null;
			Institution_Information_Homepage_Address_Value[i] = null;

		}

		File file = new File(
				"C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\4.combine\\UserData.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

		ArrayList<String> list = new ArrayList<String>();

		// int count = 0;
		String DirectoryPath = " "; // DP
		int flag = 0;

		DirectoryPath = "C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\4.combine";

		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles(); // ���ϸ���Ʈ �迭�� �ּ� ����

		for (File f : fileList) { // fileList�� ù��° �ε��� ������ ������
			String str = f.getPath(); // ���� �� ������
			if (f.isDirectory()) {
			} else {
				// .txt�� ������ ����(txt ����) ��� ����

				if (str.endsWith(".txt")) {
					count++;
					System.out.println(count + "��°" + " " + "txt���� : " + str + "\t" + f.length() + "bytes");
					list.add(str);

				}
			}
		}

//		File file2 = new File(
//				"C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\4.combine\\UserData.csv");
//		BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
//
//		for (int k = 0; k < list.size(); k++) {
//			if (file2.isFile() && file2.canWrite()) {
//				// ��� �������� �ֱ�
//
//				bufferedWriter2.write("����" + "\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" + "����"
//						+ "\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" + "����" + "\t"
//						+ "����" );
//				
//				bufferedWriter2.newLine();
//				
//			}
//			
//		}
//		bufferedWriter2.close();
//		
		// -------------------------------------------------------------------------------------------

		// File file2 = new
		// File("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company\\Writer3.csv");
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
		//

		String[] UserData_ = new String[10]; // : �� Ȱ�� // ������� : ���� count ������ ���� ��� �����ϱ�
		String[] UserData2 = new String[10];
		String[] UserDataStr = new String[10]; // cut before ":" , cut after "��:"

		// String s;
		// s.contains("d");

		
		
		for (int k = 0; k < list.size(); k++) // ���ϸ���Ʈ�� ������ ���� ���ΰ�.. �⺻������ ���� �ּ� ����..
		{
			List<String> ListStr = new ArrayList<String>(); // ListStr�̶�� ArrayList ��ü ����
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // �Է� ��Ʈ��(FileReader ��ü)��
																					// BufferedReader �Ű������� ���,
																					// BufferedReader ��ü ����
			
//			String p = " ";
//			int line_counter = 0;
//			while ( (p = in.readLine()) != null ) // ���� ���� ������ ���� // ������ size ����
//			{ // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带 �̿��ؼ� 
//				ListStr.add(p); // ArrayList ��ü�� ListStr�� ���ڿ��� �߰�, index�� ���ʷ� �Էµ�
//				                       // ���� �� ó�� ����
//				line_counter++;
//			}
			

	
			String s = " ";
			String Previous_User_Name = " "; 
			  while ( (s = in.readLine()) != null ) 
			  {// ���� ���� ������ ���� // ������ size ���� { // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带 �̿��ؼ�
				  
//			  ListStr.add(s);
				 // line_counter++;
				  
				   System.out.println(s);
				   
				   // ���� ��� if�� ���!
				   
				   // User_Name(����� �̸�)
				   if(s.contains("Ű�߱޽�û")){
					  // System.out.println("���� �ִ�" + count1++);
					   User_Name_Value = s.split("\\]");
					   System.out.println("���� �ִ�" + User_Name_Value[1].substring(1, 4));
					   User_Name = User_Name_Value[1].substring(1, 4);
					   System.out.println("��¥ Į�� ��" + " : " + User_Name);
					   Previous_User_Name = User_Name;
					   if (Previous_User_Name == User_Name) { // ���� ���� ��
						   User_Name = Previous_User_Name;
					   }
					   
				   }
				   
				   // Email_Address
				   if(s.contains("���� ���") && !s.contains("�̹���") && !s.contains("�����") && s.contains("@")) {
					   System.out.println("������� �ִ�" + (++count1) );
					   
					   Email_Address_Value = s.split("<");
					   System.out.println("���� �ִ�" + Email_Address_Value[1]);
					   
				   }
				   
				   else if(s.contains("���� ���") && !s.contains("@")) { // �����ڴ� ������ ù �ٿ� �̸��̳� ���̵� ��Ÿ��!
					   System.out.println("��ĭ ��� �ִ�" + "���� if���� �����Ǵ��� üũ�� �� : " + count1 + " /" + (++count2) );
//					   System.out.println(line_counter + " :        " + ListStr.get(line_counter));
					   
					   if (s.contains("���� ���") && s.contains("@")) {
						 System.out.println("���� �� ���� �Ϸ�");  
						   
					   }					   
					   
				   }
				   
				   
			  }
				    
				   
				  

//			while ((s = in.readLine()) != null) // ���� ���� ������ ���� // ������ size ����
//			{ // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带 �̿��ؼ�
//				// �̸� ���
//				if (s.contains("Ű�߱޽�û") == false) {
//					System.out.println("true");
//
//					User_Name_Value = s.split("\\]");
//
//					User_Name = User_Name_Value[1].substring(1, 3);
//					System.out.println(User_Name);
//				}
//			}

			
			
			 
//					 
//			{
//				
//				
//				System.out.println(s);

//				System.out.println(++i + "��° ����");
//				Institution_Department = s.substring(s.lastIndexOf("1") + 2); 
//				Institution_Department = Institution_Department.trim();
//				I_D_V[I_D_V.length - 1] = Institution_Department;
//				
//				System.out.println("Last IDV 1" +" ------------" + I_D_V[I_D_V.length-1]);
//				if(Institution_Department != null) {
//					System.out.println("Last ID : " + "----------------" +  Institution_Department + ++i);
//				}

//				if (s.contains(":") && !s.contains("http") )  //  : �� ������ Ȩ�������� �ƴ� ���
//				{
//					
//					
//					I_D_V = s.split(":");
//					
//					if( I_D_V[I_D_V.length - 1] == null || I_D_V[I_D_V.length - 1].contains("����") ) {
//					  I_D_V[I_D_V.length - 1] = "����" ;
//					}
//					
//					else {
//					I_D_V[I_D_V.length-1] = I_D_V[I_D_V.length-1].trim();
//					}
//				System.out.println(s);
//					System.out.println();
//					System.out.println("Last IDV 2" +" ------------" + I_D_V[I_D_V.length-1]);
//					System.out.println("Last IDV 2" +" ------------" + I_D_V[I_D_V.length-0]);
//

			//
			// if (s.split(":") != null) {
			// ListStr.add(s.split(":").toString());
			//
			// System.out.println("����������");
			// }

//				count++;
//				System.out.println(count);

			// ListStr.add(s); // ArrayList ��ü�� ListStr�� ���ڿ��� �߰�, index�� ���ʷ� �Էµ�

			// System.out.println(" ");

			// System.out.println(s);
			// System.out.println(ListStr); // ListStr �迭�� ������ �ִ� �ε��� �� ��� ���

//
//			if (ListStr.size() == count ) {
//				System.out.println("�ִ� ��" + count);
//			}
			// for(int i = 0; i < ListStr.size(); i++)
			// {
			//
			// UserData_Criterion_1 = ListStr.get(i).split(":"); // �ؽ�Ʈ ������ �� ���� :�� �������� �迭��
			// ���� (2�κ����� ����)
			// UserDataStr[i] = UserData_Criterion_1[UserData_Criterion_1.length-1]; // : ����
			// ���, ���ϰ� ���� => string�̴ϱ� �׳� string���� ����!
			//
			// if ( i == 0 && UserData_Criterion_1.length-2 != -1 &&
			// !( (ListStr.get(0).contains("�а�")) || (ListStr.get(0).contains("�л�")) ||
			// (ListStr.get(0).contains("����")) ) ) { // ����� ��� ����ڸ� �� if���� ����ǵ��� �س�����
			//
			// UserDataStr[0] = UserData_Criterion_1[UserData_Criterion_1.length-2].trim();
			// // 0���� ���� �Ǵ� �̽� �߻�, ȸ�� �Ұ� or Ȩ������ �ּ�
			// UserDataStr[1] = UserData_Criterion_1[UserData_Criterion_1.length-1].trim();
			// // Ȩ������ �ּ� or ȸ�� �Ұ�
			// UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // ���ڿ� ��ġ�� (�̽� �ذ�)
			// //username = UserDataStr[0];
			//
			// }
			//
			// else { // if �����ϰ� ��� ����� (no problem)
			// UserData2 =
			// UserData_Criterion_1[UserData_Criterion_1.length-1].split("\\(��"); //
			// UserData�� �� �κ��� ����ؾ� �Ѵٴ� ���� �˾��� ���� ������ ( ������ Ž�� ��� �ʿ��� ��!)
			// UserDataStr[i] = UserData2[0];
			//
			// }
			// UserDataStr[i] = UserDataStr[i].trim();
			// }

			// System.out.println("���� ���");
			// for(int i = 0; i < ListStr.size() ; i++)
			// {
			// // count++;
			// // System.out.print(" " + count + " ");
			// System.out.println(ListStr.get(i).toString());
			//// System.out.println(UserDataStr[i]) ; // ���������� �츮�� ����� �ϴ� ��
			// // System.out.println(ListStr.size());
			//
			// }

			// for(int i = 0; i <ListStr.size(); i++) {

			if (file.isFile() && file.canWrite()) {
				if (flag == 0) { // ù° �� Į���� ����

					bufferedWriter.write("����ڱ���" + "\t" + "�̸�" + "\t" + "�̸��� �ּ�" + "\t" + "�Ҽӱ����" + "\t" + "�ҼӺμ�(�а�)��"
							+ "\t" + "�Ҽӱ����ġ �Ǵ� ��������" + "\t" + "������/����" + "\t" + "�߱޸���" + "\t" + "���񽺰��" + "\t"
							+ "�Ҽӱ��������Ȩ�������ּ�" + "\t");
					bufferedWriter.newLine();

					flag++;
				}

				bufferedWriter.write("����" + "\t" + "\"" + User_Name + "\"" + "\t");
//				bufferedWriter.write("����" + "\t" + "\"" + I_D_V[I_D_V.length-1] + "\"" + "\t" );
				bufferedWriter.newLine();

				// bufferedWriter.write("����" + "\t" + "����" + "\t" + "����" + "\t" + "\"" + "\"" +
				// "\t" +"\"" + UserDataStr[1] + "\"" + "\t" +"\"" + UserDataStr[2] + "\""
				// + "\t" +"\"" + UserDataStr[3] + "\"" + "\t" +"\"" + UserDataStr[4] + "\"" +
				// "\t" +"\"" + UserDataStr[5] + "\"" + "\t" + UserDataStr[0]);
				// bufferedWriter.newLine();

			}
			// }
		}
		bufferedWriter.close();
		
	}
}
