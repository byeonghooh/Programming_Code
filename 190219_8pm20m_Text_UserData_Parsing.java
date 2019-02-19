
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

		int Number_Of_Txt_File = 0;
		int count1 = 0;
		int count2 = 0;

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

		String User_Divider_Value[] = {"����", "�б�", "���"};
		String User_Name_Value[] = new String[10];
		String Email_Address_Value[] = new String[10];
		String Institution_Value[] = new String[10];
		String Institution_Department_Value[] = new String[10];
		String Institution_Location_OR_UserResidence_Value[] = new String[10];
		String Duty_OR_Research_Value[] = new String[10];
		String Key_Issuance_Purpose_Value[] = new String[10];
		String Service_Access_Path_Value[] = new String[10];
		String Institution_Information_Homepage_Address_Value[] = new String[10];

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

		File file = new File(
				"C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\4.combine\\UserData.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

		ArrayList<String> list = new ArrayList<String>();

		// int count = 0;
		String DirectoryPath = " "; // DP
		int first_row_flag = 0;
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
					Number_Of_Txt_File++;
					System.out.println(Number_Of_Txt_File + "��°" + " " + "txt���� : " + str + "\t" + f.length() + "bytes");
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

		for (int k = 0; k < list.size(); k++) // ���ϸ���Ʈ�� ������ ���� ���ΰ�.. �⺻������ ���� �ּ� ����..
		{
			List<String> ListStr = new ArrayList<String>(); // ListStr�̶�� ArrayList ��ü ����
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // �Է� ��Ʈ��(FileReader ��ü)�� // ���� �� ���� �а� ������?
			BufferedReader in2 = new BufferedReader(new FileReader(list.get(k)));
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

			int count = 0;
			int addLineIndex = -1;
			String s = " ";
			String AllText = " ";
			while ( (s= in.readLine()) != null) 
			{
				AllText += s; // �� ���� ��Ʈ��

			}

			//			System.out.println(AllText); 

			// �������� �ʱ�ȭ
			User_Divider = "����";
			User_Name = "����";
			Email_Address = "����";
			Institution = "����";
			Institution_Department = "����";
			Institution_Location_OR_UserResidence = "����";
			Duty_OR_Research = "����";
			Key_Issuance_Purpose = "����";
			Service_Access_Path = "����";
			Institution_Information_Homepage_Address = "����";


			//			String Previous_User_Name = " "; 
			while ( (s = in2.readLine()) != null ) 
			{// ���� ���� ������ ���� // ������ size ���� { // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带 �̿��ؼ�

				System.out.println(s);

				// User_Divider
				if(AllText.contains("���λ����") ) { // || s.contains("����")
					User_Divider = User_Divider_Value[0];
				}

				if(s.contains("�а�") || AllText.contains("�б�")) { // 
					User_Divider = User_Divider_Value[1];
				}


				if (s.contains("1)") && (s.contains("ȸ��") || s.contains("�μ�")) && User_Divider.equals("����")) 
				{
					User_Divider = User_Divider_Value[2];
					addLineIndex = count + 1; 
				}
				else {
					if (addLineIndex == count && (s.contains("http") || s.contains("co")) ) {
						User_Divider = "ȸ��";
					}
				}

				// User_Name
				if(s.contains("Ű�߱޽�û")){
					// System.out.println("���� �ִ�" + count1++);
					User_Name_Value = s.split("\\]");
					System.out.println("���� �ִ�" + User_Name_Value[1].substring(1, 4));
					User_Name = User_Name_Value[1].substring(1, 4);
					System.out.println("��¥ Į�� ��" + " : " + User_Name);
					//Previous_User_Name = User_Name;
				}

				//				//���� ����, ���� ����!
				//				if(s.contains("������") ) { // ** (OOO��)
				//					User_Name = "������";
				//				}
				//			}

				// Email_Address
				int Email_Address_Last_Idx = 0;
				int Email_Address_First_Idx = 0;

				if(s.contains("���� ���") && !s.contains("�̹���") && !s.contains("�����") && s.contains("@")) { // ������ �� ���� // ����¥���� ���⼭ �� ���

					Email_Address_Last_Idx = AllText.indexOf(">");
					AllText =AllText.substring(0, Email_Address_Last_Idx);
					Email_Address_First_Idx = AllText.indexOf("<");

					//			        Debugging
					//					System.out.println("�̸��� ù��° �ε��� ��ġ" + Email_Address_First_Idx);
					//					System.out.println("�̸��� ������ �ε��� ��ġ" + Email_Address_Last_Idx);
					//					System.out.println(AllText.substring(Email_Address_First_Idx+1));

					Email_Address = AllText.substring(Email_Address_First_Idx+1);
				}

				else if(Email_Address.equals("����") && s.contains("@")) { // ó���� ������ ���´� ����

					Email_Address_Last_Idx = AllText.indexOf(">");
					AllText =AllText.substring(0, Email_Address_Last_Idx); // �� �ε����� ���� X �̰�, allText ���� ( > �������� ©�� )
					Email_Address_First_Idx = AllText.indexOf("<");

					//			        Debugging
					//					System.out.println("�̸��� ù��° �ε��� ��ġ" + Email_Address_First_Idx);
					//					System.out.println("�̸��� ������ �ε��� ��ġ" + Email_Address_Last_Idx);
					//					System.out.println(AllText.substring(Email_Address_First_Idx+1)); // ���� �ε����� ������

					Email_Address = AllText.substring(Email_Address_First_Idx+1);

					//					System.out.println("�̸��� �Ŀ� ��ĭ ��� �ִ�" + (++count2) );

				}

				// Institution
				
				int Institution_First_Idx = 0;
				int Institution_Last_Idx = 0;
				
				if(s.contains("Ű�� ��û�ϽǶ� �Ҽ�������")) {
					Institution_First_Idx = s.indexOf("�Ҽ�������");
					Institution_Last_Idx = s.indexOf("��� �Է�");
					
					System.out.println("ù��° �ε��� �� : " + Institution_First_Idx);
					System.out.println("������ �ε��� �� : " + Institution_Last_Idx);
					
					Institution = s.substring(Institution_First_Idx+5, Institution_Last_Idx-1).trim();
					
					/*
					 * Institution_Last_Idx = Institution.indexOf("\""); Institution =
					 * s.substring(Institution_First_Idx, Institution_Last_Idx);
					 */
//			        if(Institution.contains(){
//						Institution_Last_Idx = Institution.indexOf("\"");
//					}

				}
				else if (AllText.contains("���λ����") || AllText.contains("���θ���")) {
					
					if(s.contains("�Ҽӱ�� ����")) {
						Institution_Value = s.split(":");
						if (Institution_Value.length >= 2) {
						Institution = Institution_Value[1].trim();	
						}
					}
					else {
						Institution = "�Ҽӱ�� ����(���λ����)";
					}
				}
				
				// Institution_Department

				int Instiution_Department_First_Idx = 0;
				int Instiution_Department_Last_Idx = 0;

				if(s.contains("�μ�")) { // ������ �� ���� // ����¥���� ���⼭ �� ���

					Instiution_Department_First_Idx = s.indexOf("�μ�");
					Institution_Department_Value = s.split("�μ�"); // �����ڰ� �Է��ϴ� ����

					if (Institution_Department.equals("����")) {

						Institution_Department = s.substring(Instiution_Department_First_Idx+3).trim(); // ù��° ����� ��
						System.out.println("�μ��� : " + Institution_Department);
					}

				}


				if(s.contains("�а�")) { // ������ �� ���� // ����¥���� ���⼭ �� ���

					Instiution_Department_First_Idx = s.indexOf("�а�");
					Institution_Department_Value = s.split("�а�"); // �����ڰ� �Է��ϴ� ����
					//					Institution_Department_Value = s.split("�а� :");
					//					Institution_Department_Value = s.split("�а�  :");

					if (Institution_Department.equals("����") && Institution_Department_Value.length == 2) {

						Institution_Department = s.substring(Instiution_Department_First_Idx+4).trim(); // ù��° ����� ��
						System.out.println("�а��� : " + Institution_Department);
					}

				}
				
				//Institution_Location_OR_UserResidence
				
				 if( (s.contains("����:") || s.contains("���� :") ) && Key_Issuance_Purpose.equals("����") )
	        	 {
	        		 Institution_Location_OR_UserResidence_Value = s.split(":");
	        		 
	        		 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence_Value[1].trim();
	        		 
	        		 if(Institution_Location_OR_UserResidence.contains("(��"))
	        			 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.substring(0, Institution_Location_OR_UserResidence.indexOf("(��")).trim();
	        		 
	        		 if(Institution_Location_OR_UserResidence.contains(","))
	        			 
	        		 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.trim();
	        	 }

	        	 // �����ġ �Ǵ� �������� �Ľ� ���ܻ���
	        	 else if(s.contains("��")&& Key_Issuance_Purpose.equals("����"))
	        	 {
	        		 if(s.indexOf("��") + 3 == s.indexOf("��") || s.indexOf("��") + 4 == s.indexOf("��")) // O��, OO��
	        		 {
	        			 String subString = s.substring(s.indexOf("��"));
	        			 Institution_Location_OR_UserResidence = s.substring(s.indexOf("��") - 2, s.indexOf("��") + subString.indexOf("��") + 1).trim();
	        		 }
	        	 }
				 
				//Duty_OR_Research
				 
				 if((s.contains("����:") || s.contains("���� :") || s.contains("����:")) && Key_Issuance_Purpose.equals("����"))
	        	 {
	        		 Duty_OR_Research_Value = s.split(":");
	        		 
	        		 Duty_OR_Research = Duty_OR_Research_Value[1].trim();
	        		 
	        		 if(Duty_OR_Research.contains("(��"))
	        			 Duty_OR_Research = Duty_OR_Research.substring(0, Duty_OR_Research.indexOf("(��")).trim();
	        		 
	        		 if(Duty_OR_Research.contains(","))
	        		 
	        		 Duty_OR_Research = Duty_OR_Research.trim();
	        		 
	        		 // ���� �����Ͱ� ������ ��� �������� ó��
	        		 if(Duty_OR_Research.equals(""))
	        			 Duty_OR_Research = "����"; // 
	        	 }
	        	// ��� ���� �Ľ� ���ܻ���
	        	 else if((s.contains("����")) && Duty_OR_Research.equals("����") && s.contains(")")) // ���� ���� ��� ���� (������ ���� ���� �߻�)
	        	 {
	        		 int startIndex = s.indexOf(")");
	        		 Duty_OR_Research = s.substring(startIndex + 1).trim();
	        		 
	        		 Duty_OR_Research = Duty_OR_Research.trim();
	        	 }
				 
				 
				//Key_Issuance_Purpose
				 
				 if((s.contains("����:") || s.contains("���� :")) && Key_Issuance_Purpose.equals("����"))
	        	 {
	        		 Key_Issuance_Purpose_Value = s.split(":");
	        		 
	        		 Key_Issuance_Purpose = Key_Issuance_Purpose_Value[1].trim();
	        		 
	        		 if(Key_Issuance_Purpose.contains("(��"))
	        			 Key_Issuance_Purpose = Key_Issuance_Purpose.substring(0, Key_Issuance_Purpose.indexOf("(��")).trim();
	        		 
	        		 Key_Issuance_Purpose = Key_Issuance_Purpose.trim();
	        		 
	        		 // ���� �����Ͱ� ������ ��� �������� ó��
	        		 if(Key_Issuance_Purpose.equals(""))
	        			 Key_Issuance_Purpose = "����".trim();
	        		 else
	        			 addLineIndex = count + 1; // ����
	        	 }
	        	// ���Ͱ� �Ǿ��ִ� ��� ó��
	        	 else 
	        	 {
	        		 if(addLineIndex == count && !(s.contains(":"))) // ���� ��
	        			 Key_Issuance_Purpose += s; // ���ڿ� ���̱� *����! => ��)�� ������ �����ִ� ��Ȳ?
	        		 
	        		 if(Key_Issuance_Purpose.contains("(��"))
	        			 Key_Issuance_Purpose = Key_Issuance_Purpose.substring(0, Key_Issuance_Purpose.indexOf("(��")).trim();
	        	 }
	        	// �߱� ���� �Ľ� ���ܻ���
	        	 if((s.contains("����") || s.contains("����")) && Key_Issuance_Purpose.equals("����"))
	        	 {
	        		 int startIndex = s.indexOf(")");
	        		 Key_Issuance_Purpose = s.substring(startIndex + 1).trim();
	        		 	        		 
	        		 Key_Issuance_Purpose = Key_Issuance_Purpose.trim();
	        	 }
				
	      
				//Service_Access_Path 
	        	 
	        	// �˻� ��� �Ľ�
	        	 if(s.contains("���") && Service_Access_Path.equals("����"))
	        	 {
	        		 Service_Access_Path_Value = s.split(":");
	        		 
	        		 Service_Access_Path = Service_Access_Path_Value[1].trim();
	        		 
	        		 if(Service_Access_Path.contains("(��"))
	        			 Service_Access_Path = Service_Access_Path.substring(0, Service_Access_Path.indexOf("(��")).trim();
	        		 
	        		 Service_Access_Path = Service_Access_Path.trim();
	        		 
	        		 // ������ ��� �������� ó��
	        		 if(Service_Access_Path.equals(""))
	        			 Service_Access_Path = "����";
	        	 }
	        	 // �˻� ��� �Ľ� ���ܻ��� (��ζ� �ؽ�Ʈ���� �ٷ� ���ͳ��̶� �亯�� ����...)
	        	 else if(s.contains("���ͳ�") && Service_Access_Path.equals("����"))
	        		 Service_Access_Path = "���ͳ�";
	        	 
	        	//Institution_Information_Homepage_Address 

	 			// Ȩ������ �ּ� �� �Ҽ� ��� ���� �Ľ� (���� �� �� �ٷ� ���� ó��)
	        	 int Homepage_Address_FirstIndex = AllText.indexOf("http");
 	    		 int Homepage_Address_LastIndex = 0;
	        	 
	        	 if(AllText.contains("http"))
	 	    	 {
	 	    		
	 	    		 String subText = AllText.substring(Homepage_Address_FirstIndex);

	 	    		 Homepage_Address_LastIndex = subText.indexOf(")") - 1; // 2) ������ �ڸ� ( Ȩ������ ���� �߰� ���ؼ� )
	 	    		 
	 	    		 Institution_Information_Homepage_Address = AllText.substring(Homepage_Address_FirstIndex, Homepage_Address_FirstIndex + Homepage_Address_LastIndex).trim();
	 	    		 
	 	    		 Institution_Information_Homepage_Address = Institution_Information_Homepage_Address.trim();
	 	    	 }
	        	 
	        	
				count++;
			}

			
			

			if (file.isFile() && file.canWrite()) {
				if (first_row_flag == 0) { // ù° �� Į���� ����

					bufferedWriter.write("����ڱ���" + "\t" + "�̸�" + "\t" + "�̸��� �ּ�" + "\t" + "�Ҽӱ����" + "\t" + "�ҼӺμ�(�а�)��"
							+ "\t" + "�Ҽӱ����ġ �Ǵ� ��������" + "\t" + "������/����" + "\t" + "�߱޸���" + "\t" + "����(open API ����Ʈ) ���� ���" + "\t"
							+ "�Ҽӱ��������Ȩ�������ּ�" + "\t");
					bufferedWriter.newLine();

					first_row_flag++;
				}

				bufferedWriter.write("\"" + User_Divider + "\"" + "\t" + "\"" + User_Name + "\"" + "\t" + "\"" + Email_Address + "\"" + "\t" + "\"" + Institution + "\"" + "\t"
						+ "\"" + Institution_Department + "\"" + "\t" + "\"" + Institution_Location_OR_UserResidence + "\"" + "\t" + "\"" + Duty_OR_Research + "\"" + "\t" 
						+ "\"" + Key_Issuance_Purpose + "\"" + "\t" + "\"" + Service_Access_Path + "\"" + "\t" + "\"" + Institution_Information_Homepage_Address + "\"" + "\t");
				//				bufferedWriter.write("����" + "\t" + "\"" + I_D_V[I_D_V.length-1] + "\"" + "\t" );
				bufferedWriter.newLine();

				// bufferedWriter.write("����" + "\t" + "����" + "\t" + "����" + "\t" + "\"" + "\"" +
				// "\t" +"\"" + UserDataStr[1] + "\"" + "\t" +"\"" + UserDataStr[2] + "\""
				// + "\t" +"\"" + UserDataStr[3] + "\"" + "\t" +"\"" + UserDataStr[4] + "\"" +
				// "\t" +"\"" + UserDataStr[5] + "\"" + "\t" + UserDataStr[0]);
				// bufferedWriter.newLine();

			}

		}
		bufferedWriter.close();

	}
}
