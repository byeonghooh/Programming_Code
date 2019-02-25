
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
		
//		Java_Txt_parsing_gui Text_Parsing_GUI = new Java_Txt_parsing_gui();
		
//		Text_Parsing_GUI.setVisible(true);
		
		
		String DirectoryPath = args[0];  
		
	/*	args = new String[2];
		args[0] = "Enter DirectoryPath : ";
		args[1] = new*/
		
		
		int Number_Of_Txt_File = 0;
		int count = 0;

		String User_Divider = "����";
		String User_Name = "����";
		String Email_Address = "����";
		String Institution = "����";
		String Institution_Department = "����";
		String Institution_Location_OR_UserResidence = "����";
		String Duty_OR_Research = "����";
		String Key_Issuance_Purpose = "����";
		String Service_Access_Path = "����";
		String Institution_Information_Homepage_Address = "����";

		String User_Divider_Value[] = { "����", "�б�", "���" };
		String User_Name_Value[] = new String[3];
		String Email_Address_Value[] = new String[3];
		String Institution_Value[] = new String[3];
		String Institution_Department_Value[] = new String[3];
		String Institution_Location_OR_UserResidence_Value[] = new String[3];
		String Duty_OR_Research_Value[] = new String[3];
		String Key_Issuance_Purpose_Value[] = new String[3];
		String Service_Access_Path_Value[] = new String[3];
		String Institution_Information_Homepage_Address_Value[] = new String[3];

		for (int i = 0; i < User_Name_Value.length; i++) {

			User_Name_Value[i] = null;
			Email_Address_Value[i] = null;
			Institution_Value[i] = null;
			Institution_Department_Value[i] = null;
			Institution_Location_OR_UserResidence_Value[i] = null;
			Duty_OR_Research_Value[i] = null;
			Key_Issuance_Purpose_Value[i] = null;
			Service_Access_Path_Value[i] = null;
			Institution_Information_Homepage_Address_Value[i] = null;

		}

//		Test
//		File file = new File("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\4.combine\\UserData.csv");
		File file = new File(
				"C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\combine\\More1+1\\UserData.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

		ArrayList<String> list = new ArrayList<String>();

		// int count = 0;
//		String DirectoryPath = " "; // DP
//		String DirectoryPath = "";  
		
		int first_row_flag = 0;

//		Test
//		DirectoryPath = "C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\4.combine";
		
		
//		System.out.println(" Main �Լ� - GUI �Լ� �� " + Text_Parsing_GUI.getDirectoryPath());
//		DirectoryPath = Text_Parsing_GUI.getDirectoryPath();
		//System.out.println(Text_Parsing_GUI.getDirectoryPath());

		// ���� ��� ����
		File path = new File(DirectoryPath);
//		System.out.println("Path �ﳪ��:?" + path);
		File[] fileList = path.listFiles(); // ���ϸ���Ʈ �迭�� �ּ� ����

//		System.out.println("path.listFile �� " + fileList);
		
		for (File f : fileList) { // fileList�� ù��° �ε��� ������ ������
			String str = f.getPath(); // ���� �� ������
			if (f.isDirectory()) {
			} 
			else {
				// .txt�� ������ ����(txt ����) ��� ����
				if (str.endsWith(".txt")) {
					Number_Of_Txt_File++;
					System.out
							.println(Number_Of_Txt_File + "��°" + " " + "txt���� : " + str + "\t" + f.length() + "bytes");
					list.add(str);
				}
			}
		}

		// ���� ����Ʈ �б�
		for (int k = 0; k < list.size(); k++) {
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // �Է� ��Ʈ��(FileReader ��ü)�� // ���� �� ���� �а�
																					// ������? ��
			BufferedReader in2 = new BufferedReader(new FileReader(list.get(k)));

			int addLineIndex_User_Divider = -1;
			int addLineIndex_Key = -1;
			int addLineIndex_Duty = -1;
			int addLineIndex_Service = -1;

			String s = " "; // �̽�1
			String AllText = " ";
			while ((s = in.readLine()) != null) {
				AllText += s; // �� ���� ��Ʈ��
			}

			// �������� �ʱ�ȭ
			User_Divider = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			User_Name = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Email_Address = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Institution = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Institution_Department = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Institution_Location_OR_UserResidence = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Duty_OR_Research = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Key_Issuance_Purpose = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Service_Access_Path = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			Institution_Information_Homepage_Address = "����(����� ���Է�)";

			//
			while ((s = in2.readLine()) != null) {// ���� ���� ������ ���� // ������ size ���� { // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带
													// �̿��ؼ�

				// line by line Debugging
				System.out.println(s);

				// User_Divider
				if (AllText.contains("���λ����")) { // || s.contains("����")
					User_Divider = User_Divider_Value[0];
				}

				if (s.contains("�а�") || AllText.contains("�б�")) { //
					User_Divider = User_Divider_Value[1];
				}

				if (s.contains("1)") && (s.contains("ȸ��") || s.contains("�μ�"))
						&& User_Divider.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) {
					User_Divider = User_Divider_Value[2];
					addLineIndex_User_Divider = count + 1;
				} else {
					if (addLineIndex_User_Divider == count && (s.contains("http") || s.contains("co"))) {
						User_Divider = User_Divider_Value[2];
					}
				}

				// User_Name
				if (s.contains("Ű�߱޽�û")) {
					User_Name_Value = s.split("\\]");
					System.out.println("���� �ִ�" + User_Name_Value[1].substring(1, 4));
					User_Name = User_Name_Value[1].substring(1, 4);
					System.out.println("��¥ Į�� ��" + " : " + User_Name);
				}

				// User_Email_Address
				int Email_Address_Last_Idx = 0;
				int Email_Address_First_Idx = 0;

				if (s.contains("���� ���") && !s.contains("�̹���") && !s.contains("�����") && s.contains("@")) { // ������ �� ���� //
																											// ����¥���� ���⼭
																											// �� ���

					if(AllText.contains(">")) {
					Email_Address_Last_Idx = AllText.indexOf(">");
					Email_Address = AllText.substring(0, Email_Address_Last_Idx);
					Email_Address_First_Idx = Email_Address.indexOf("<");

					Email_Address = Email_Address.substring(Email_Address_First_Idx + 1).trim();
					System.out.println("üũ ����Ʈ 1 : " + Email_Address);

					if (Email_Address.contains("wykim@etri.re.kr")) {
						Email_Address = "�����ڰ� Ȯ�� �ʿ�";
						System.out.println("������ �̸��� ���� 1" + Email_Address);

					}
					}
				}

				else if (Email_Address.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)") && s.contains("@")) { // ó���� ������ ���´� ����

					Email_Address_Last_Idx = AllText.indexOf(">");
					Email_Address = AllText.substring(0, Email_Address_Last_Idx); // �� �ε����� ���� X �̰�, allText ���� ( > ��������
																					// ©�� )
					Email_Address_First_Idx = Email_Address.indexOf("<");

					Email_Address = Email_Address.substring(Email_Address_First_Idx + 1);
					System.out.println("üũ ����Ʈ 2 : " + Email_Address);

					if (Email_Address.contains("wykim@etri.re.kr")) {
						Email_Address = "�����ڰ� Ȯ�� �ʿ�";
						System.out.println("������ �̸��� ���� 2" + Email_Address);

					}
				}

				// User Email ���� ���� - ��� �� ��ȿ���� (���̽� �ʹ� ����)
//				else if(s.contains("���� ���") && s.contains("@")) {
//					//Email_Address_First_Idx = AllText.indexOf("���� ���");
//					
//					Email_Address_Last_Idx = AllText.indexOf("���� ��¥");
//					Email_Address = AllText.substring(0, Email_Address_Last_Idx);
//					Email_Address_First_Idx = Email_Address.indexOf("���� ���");
//					Email_Address = Email_Address.substring(Email_Address_First_Idx+6, Email_Address_Last_Idx).trim();
//					
//					//Email_Address = AllText.substring(Email_Address_First_Idx, Email_Address_Last_Idx).trim();
//					
//					System.out.println("üũ ����Ʈ 3 : "+ Email_Address);
//				}

				// Institution
				int Institution_First_Idx = 0;
				int Institution_Last_Idx = 0;

				if (s.contains("Ű�� ��û�ϽǶ� �Ҽ�������")) {
					Institution_First_Idx = s.indexOf("�Ҽ�������");
					Institution_Last_Idx = s.indexOf("��� �Է�");
					Institution_Last_Idx = s.indexOf("���");

					System.out.println("ù��° �ε��� �� : " + Institution_First_Idx);
					System.out.println("������ �ε��� �� : " + Institution_Last_Idx);

					Institution = s.substring(Institution_First_Idx + 5, Institution_Last_Idx - 1).trim();
				}

				else if (AllText.contains("���λ����") || AllText.contains("���θ���")) {

					if (s.contains("�Ҽӱ�� ����")) {
						Institution_Value = s.split(":");
						if (Institution_Value.length >= 2) {
							Institution = Institution_Value[1].trim();
						}

					} else {
						Institution = "�Ҽӱ�� ����(���λ����)";
						Institution_Department = "�ҼӺμ� ����(���λ����)";
					}
				}

				// Institution_Department

				int Institution_Department_First_Idx = AllText.indexOf("�μ�");
				int Institution_Department_Last_Idx = 0;

				// �μ��� 1���� ��ġ�� ���� �� - 2�� ������ ����
				if (s.contains("1)") && (s.contains("�μ�:") || s.contains("�μ� :"))
						&& Institution_Department != "�ҼӺμ� ����(���λ����)") {

					String subText_Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();

					if ((subText_Institution_Department.contains("����") || subText_Institution_Department.contains("��ġ")) && (subText_Institution_Department.contains("2)")
							|| subText_Institution_Department.contains("2."))) {
						Institution_Department_Last_Idx = subText_Institution_Department.indexOf("2");

						System.out.println("2)�� ��ġ Ž��" + Institution_Department_Last_Idx);

						Institution_Department = AllText.substring(Institution_Department_First_Idx + 3,
								Institution_Department_First_Idx + Institution_Department_Last_Idx).trim();
						System.out.println("ID_1!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					} else {
						Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();
						System.out.println("ID_2!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					}

				}

				// �μ��� 2���� ��ġ������ �� - 3�� ������ ����
				else if ((s.contains("2)") || s.contains("2.")) && (s.contains("�μ�:") || s.contains("�μ� :"))
						&& Institution_Department != "�ҼӺμ� ����(���λ����)") {
					String subText_Institution_Department_2 = AllText.substring(Institution_Department_First_Idx)
							.trim();

//					if (Institution_Department == "����") {
					if ((subText_Institution_Department_2.contains("3)")
							|| subText_Institution_Department_2.contains("3."))) {
						Institution_Department_Last_Idx = subText_Institution_Department_2.indexOf("3");
						System.out.println("3)�� ��ġ Ž��" + Institution_Department_Last_Idx);

						Institution_Department = AllText.substring(Institution_Department_First_Idx + 3,
								Institution_Department_First_Idx + Institution_Department_Last_Idx).trim();

						System.out.println("ID_3!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);
					}

					else {
						Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();
						System.out.println("ID_4!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);
					}

//					}

				}

				Institution_Department_First_Idx = AllText.indexOf("�а�");
				Institution_Department_Last_Idx = 0;

				// �μ��� 1���� ��ġ�� ���� �� - 2�� ������ ����
				if (s.contains("1)") && (s.contains("�а�:") || s.contains("�а� :"))
						&& Institution_Department != "�ҼӺμ� ����(���λ����)") {
//					Sysout
					String subText_Institution_Department_3 = AllText.substring(Institution_Department_First_Idx)
							.trim();

					if (subText_Institution_Department_3.contains("����")
							&& (subText_Institution_Department_3.contains("2)")
									|| subText_Institution_Department_3.contains("2."))) {
						Institution_Department_Last_Idx = subText_Institution_Department_3.indexOf("2)");

						System.out.println("2)�� ��ġ Ž��" + Institution_Department_Last_Idx);

						Institution_Department = AllText.substring(Institution_Department_First_Idx + 4,
								Institution_Department_First_Idx + Institution_Department_Last_Idx).trim();
						System.out.println("ID_1!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					} else {
						Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();
						System.out.println("ID_2!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					}

				}

				// Institution_Location_OR_UserResidence

				if ((s.contains("����:") || s.contains("���� :"))
						&& Institution_Location_OR_UserResidence.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) {
					Institution_Location_OR_UserResidence_Value = s.split(":");

					if (Institution_Location_OR_UserResidence_Value.length == 2) {
						Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence_Value[1].trim();
					}
					if (Institution_Location_OR_UserResidence.contains("(��")) // Ȯ���ʿ�
						Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence
								.substring(0, Institution_Location_OR_UserResidence.indexOf("(��")).trim();

					if (Institution_Location_OR_UserResidence == "") {
						Institution_Location_OR_UserResidence = "��ĭ�� ����(�����̽�=>������)";
					}

					// Ȯ�ο� Institution_Location_OR_UserResidence =
					// Institution_Location_OR_UserResidence.trim();
				}

				// �����ġ �Ǵ� �������� �Ľ� ���ܻ���
				else if (s.contains("��") && Institution_Location_OR_UserResidence.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) // ��
																															// ��������
																															// ���
																															// (������
																															// �����ʹ�
																															// ����)
				{
					System.out.println("�ٺ�");
					if (s.indexOf("��") + 3 == s.indexOf("��") || s.indexOf("��") + 4 == s.indexOf("��")) // O��, OO��
					{
						System.out.println("�ٺ�2");
						String subString = s.substring(s.indexOf("��")); // �ú��� �����ؼ� ���ڿ� ������
						Institution_Location_OR_UserResidence = s
								.substring(s.indexOf("��") - 2, s.indexOf("��") + subString.indexOf("��") + 1).trim();
						System.out.println("�Ҽӱ������!!!!!" + Institution_Location_OR_UserResidence);
					}
				}

				// Duty_OR_Research

				int Duty_OR_Research_First_Idx = 0;

				if ((s.contains("����:") || s.contains("���� :") || s.contains("����:"))
						&& Duty_OR_Research.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) {
					Duty_OR_Research_Value = s.split(":");
					if (Duty_OR_Research_Value.length == 2) {
						Duty_OR_Research = Duty_OR_Research_Value[1];
					}

					if (Duty_OR_Research.contains("(��")) {
						Duty_OR_Research = Duty_OR_Research.substring(0, Duty_OR_Research.indexOf("(��"));
					}
//	        		 else addLineIndex_Duty = count + 1; // �̽� 2

					Duty_OR_Research = Duty_OR_Research.trim();

					// ���� �����Ͱ� ������ ��� �������� ó�� -> �ι�° ����� ��Ŀ��� �а� �����
					if (Duty_OR_Research.equals(""))
						Duty_OR_Research = "����"; // Ȯ��
//					  else addLineIndex_Duty = count + 1; // ���� X ( ������ �� ��� ��� )
					addLineIndex_Duty = count + 1; // �ؿ��� �ɸ��ϱ� else�� ���� �ʿ� ����
				}

				// ��� ���� �Ľ� ���ܻ���
				else if (!s.contains("�μ�") && (s.contains("����"))
						&& Duty_OR_Research.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)") && s.contains(")")) // ���� ���� ��� ����
																										// (������ ���� ����
																										// �߻�)
				{
					Duty_OR_Research_First_Idx = s.indexOf(")");
					Duty_OR_Research = s.substring(Duty_OR_Research_First_Idx + 1).trim();

					Duty_OR_Research = Duty_OR_Research.trim();
				}

				// �ٷ� ���� �ڵ� ������ ��
				else if (addLineIndex_Duty == count && !(s.contains(":"))) {
					// ���� ��
					Duty_OR_Research = s.trim(); // ���� ����
				}

				// Key_Issuance_Purpose
				int Key_Issuance_Purpose_First_Idx = 0;

				if ((s.contains("����:") || s.contains("���� :"))
						&& Key_Issuance_Purpose.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) {

					Key_Issuance_Purpose_Value = s.split(":");

					if (Key_Issuance_Purpose_Value.length == 2) {
						Key_Issuance_Purpose = Key_Issuance_Purpose_Value[1].trim();
					}

					if (Key_Issuance_Purpose.contains("(��"))
						Key_Issuance_Purpose = Key_Issuance_Purpose.substring(0, Key_Issuance_Purpose.indexOf("(��"))
								.trim();

					Key_Issuance_Purpose = Key_Issuance_Purpose.trim();

					// ���� �����Ͱ� ������ ��� �������� ó��

					addLineIndex_Key = count + 1;

				}

				// �ٷ� ���� �ڵ� ������ ��
				else if (addLineIndex_Key == count && !(s.contains(":"))) {
					// ���� ��
					if (Key_Issuance_Purpose.contains("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)"))
						Key_Issuance_Purpose = s;
					else
						Key_Issuance_Purpose += s;
				}

				// �߱� ���� �Ľ� ���ܻ���
				if ((s.contains("����") || s.contains("����"))
						&& Key_Issuance_Purpose.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) {
					Key_Issuance_Purpose_First_Idx = s.indexOf(")");
					Key_Issuance_Purpose = s.substring(Key_Issuance_Purpose_First_Idx + 1).trim();

					Key_Issuance_Purpose = Key_Issuance_Purpose.trim();
				}

				// Service_Access_Path
				// �˻� ��� �Ľ�
				if ((s.contains("���") || s.contains("���:") || s.contains("��� :"))
						&& Service_Access_Path.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)")) {
					Service_Access_Path_Value = s.split(":");

					if (Service_Access_Path_Value.length == 2) {
						Service_Access_Path = Service_Access_Path_Value[1].trim();
					}

					if (Service_Access_Path.contains("(��"))
						Service_Access_Path = Service_Access_Path.substring(0, Service_Access_Path.indexOf("(��"))
								.trim();

					Service_Access_Path = Service_Access_Path.trim();

					// ���� ����ڰ� ������ �Է� �� �� ��� �ʱⰪ ����
//	        		 if(Service_Access_Path.equals(""))
//	        			 Service_Access_Path = "����";

					addLineIndex_Service = count + 1;
				}

				// Enter ó�� (
				else if (addLineIndex_Service == count && !(s.contains(":"))) {
					// ���� ��
					if (Service_Access_Path.contains("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)"))
						Service_Access_Path = s;
					else
						Service_Access_Path += s;
				}

				// �˻� ��� �Ľ� ���ܻ��� (��ζ� �ؽ�Ʈ���� �ٷ� ���ͳ��̶� �亯�� ����...)
				else if (s.contains("���ͳ�") && Service_Access_Path.equals("�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)"))
					Service_Access_Path = "���ͳ�";

				count++;
			}

			// Institution_Information_Homepage_Address
			// Ȩ������ �ּ� �� �Ҽ� ��� ���� �Ľ� (���� �� �� �ٷ� ���� ó��)
			int Homepage_Address_FirstIndex = AllText.indexOf("http");
			int Homepage_Address_LastIndex = 0;

			if (AllText.contains("http")) {
				String subText = AllText.substring(Homepage_Address_FirstIndex);

				if (subText.contains(")")) {
					Homepage_Address_LastIndex = subText.indexOf(")") - 1; // 2) ������ �ڸ� ( Ȩ������ ���� �߰� ���ؼ� )

					Institution_Information_Homepage_Address = AllText.substring(Homepage_Address_FirstIndex,
							Homepage_Address_FirstIndex + Homepage_Address_LastIndex).trim();
				}

				else {
					Institution_Information_Homepage_Address = AllText.substring(Homepage_Address_FirstIndex).trim();
				}

			}

			else if (AllText.contains("www")) {
				Homepage_Address_FirstIndex = AllText.indexOf("www");
				String subText = AllText.substring(Homepage_Address_FirstIndex);

				Homepage_Address_LastIndex = subText.indexOf(")") - 1; // 2) ������ �ڸ� ( Ȩ������ ���� �߰� ���ؼ� )

				Institution_Information_Homepage_Address = AllText.substring(Homepage_Address_FirstIndex,
						Homepage_Address_FirstIndex + Homepage_Address_LastIndex).trim();

				Institution_Information_Homepage_Address = Institution_Information_Homepage_Address.trim();
			}

			// ���� ����� ���� ���� ���� üũ
			if (Institution == "�Ҽӱ�� ����(���λ����)" && Institution_Department == "�ҼӺμ� ����(���λ����)") {
				User_Divider = User_Divider_Value[0];
			}

			Institution_Department = Institution_Department.replaceAll(" ", "");
			Institution_Department = Institution_Department.trim();

			if (Institution_Department.length() == 0) {
				Institution_Department = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
			}

			Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.replaceAll(" ", "");
			Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.trim();

			if (Institution_Location_OR_UserResidence.length() == 0) {
				Institution_Location_OR_UserResidence = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
			}

			Duty_OR_Research = Duty_OR_Research.replaceAll(" ", "");
			Duty_OR_Research = Duty_OR_Research.trim();

			/*
			 * if (Duty_OR_Research.length() == 0) { Duty_OR_Research=
			 * "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)"; }
			 */
			
			/*
			 * if (Duty_OR_Research == "") { // �ּҰ� �� (��ü�� ���ϼ� �Ǵ�)
			 * 
			 * Duty_OR_Research = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� or ���� ���ؼ�)"; }
			 */
			
			  if (Duty_OR_Research.equals("")) { // ��ü�� �� ��
			  
			  Duty_OR_Research = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� or ���� ���ؼ�)"; }
			 
			Key_Issuance_Purpose = Key_Issuance_Purpose.replaceAll(" ", "");
			Key_Issuance_Purpose = Key_Issuance_Purpose.trim();

			if (Key_Issuance_Purpose.length() == 0) {
				Key_Issuance_Purpose = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
			}
			
			

			Service_Access_Path = Service_Access_Path.replaceAll(" ", "");
			Service_Access_Path = Service_Access_Path.trim();

			if (Service_Access_Path.length() == 0) {
				Service_Access_Path = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
			}
			
			if(Duty_OR_Research.length() < 4 && Key_Issuance_Purpose.length() < 4   ) {
				Duty_OR_Research = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
				Key_Issuance_Purpose = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
				Service_Access_Path = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
				
				
			}
			
			//  �ֺ����θ� ©���� ���̽���
			if(Service_Access_Path.contains("�ֺ�") && Service_Access_Path.length() < 3) {
				System.out.println("truetrue");
				Service_Access_Path = "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
			}
			
			if( Institution.length() > 40 ||  Institution_Department.length() > 40  ||  Institution_Location_OR_UserResidence.length() > 40
				|| Duty_OR_Research.length() > 40 || (Key_Issuance_Purpose.length() > 40 && !Key_Issuance_Purpose.contains("�ϴ�"))
				|| Service_Access_Path.length() > 100 ) 
			{
				Institution_Department = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
				Institution_Location_OR_UserResidence = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
				Duty_OR_Research = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
				Key_Issuance_Purpose = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
				Service_Access_Path = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";				
				Institution_Information_Homepage_Address = "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� �Ǵ� ���� ���ؼ�)";
			}
			
//			
//			if ( ) {
//				Service_Access_Path =  "�����ڰ� �Է� �ʿ�(���� ���ؼ� �Ǵ� ���� ����)";
//			}

//			if (Institution_Location_OR_UserResidence== null) {
//				
//				Institution_Location_OR_UserResidence= "�����ڰ� Ȯ�� �ʿ�(���� ���� �ٸ� or ���� ���ؼ�)";
//			}
//			
			System.out.println("1 : " +User_Divider + " 2 :" + User_Name + "3 :" + Email_Address + "4 :" + Institution + " 5 :"
					+ Institution_Department + "6 :" + Institution_Location_OR_UserResidence);
			System.out.println(Duty_OR_Research + "7 :" + Key_Issuance_Purpose + "8 :" + Service_Access_Path + " 9:"
					+ Institution_Information_Homepage_Address);
//			
//			

			in.close();
			in2.close();
			
			
			if (file.isFile() && file.canWrite()) {
				if (first_row_flag == 0) { // ù° �� Į���� ����

					bufferedWriter.write("����ڱ���" + "\t" + "�̸�" + "\t" + "�̸��� �ּ�" + "\t" + "�Ҽӱ����" + "\t" + "�ҼӺμ�(�а�)��"
							+ "\t" + "�Ҽӱ����ġ �Ǵ� ��������" + "\t" + "������/����" + "\t" + "�߱޸���" + "\t"
							+ "����(open API ����Ʈ) ���� ���" + "\t" + "�Ҽӱ��������Ȩ�������ּ�" + "\t");
					bufferedWriter.newLine();

					first_row_flag++;
				}

				bufferedWriter.write(
						"\"" + User_Divider + "\"" + "\t" + "\"" + User_Name + "\"" + "\t" + "\"" + Email_Address + "\""
								+ "\t" + "\"" + Institution + "\"" + "\t" + "\"" + Institution_Department + "\"" + "\t"
								+ "\"" + Institution_Location_OR_UserResidence + "\"" + "\t" + "\"" + Duty_OR_Research
								+ "\"" + "\t" + "\"" + Key_Issuance_Purpose + "\"" + "\t" + "\"" + Service_Access_Path
								+ "\"" + "\t" + "\"" + Institution_Information_Homepage_Address + "\"" + "\t");
				bufferedWriter.newLine();

			}
			
		}
		bufferedWriter.close();
		

	}
}
