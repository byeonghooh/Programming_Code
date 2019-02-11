import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List; // �������̽� Ŭ����, java.util.collection interface ����

public class text_parsing {

	// tokenizer ���! 

	public static List<String> fileLineRead(String name) throws IOException // java List<String> �Լ��� ���� (ũ�� ���� ���� ����)
	{
		List<String> ListStr = new ArrayList<String>(); // ListStr�̶�� ArrayList ��ü ����
		BufferedReader in = new BufferedReader(new FileReader(name)); // �Է� ��Ʈ��(FileReader ��ü)�� BufferedReader �Ű������� ���, BufferedReader ��ü ����
		String s; 
		while ((s = in.readLine()) != null) { // �� �� ������ ó���� �� �ִ� readLine �޼ҵ带 �̿��ؼ� 
			ListStr.add(s); // ArrayList ��ü�� ListStr�� ���ڿ��� �߰�, index�� ���ʷ� �Էµ�
			// System.out.println(ListStr); // ListStr �迭�� ������ �ִ� �ε��� �� ��� ���
		}
		in.close();
		return ListStr; // �迭 ����
	}

	public static void main(String args[]) throws IOException {
		List<String> ListInTxt = fileLineRead("data1.txt");
		String[] UserData =  new String[100]; //  ���� count ������ ���� ��� �����ϱ�
		String[] UserData2 =  new String[100];
		String[] UserDataStr = new String[100]; // cut before : 
		//		List<String> UserDataStr = new ArrayList<String>();

		for(int i = 0; i < ListInTxt.size(); i++){ // �迭�� length ���� �ϳ� �۰�!
			//�������� ���е� �� ���ڿ��� ListInTxt.get() �ε����� ���ʷ� ��� ����!
			System.out.println("Line(" + i + ")" + " " + ListInTxt.get(i));
			//			UserData = ListInTxt.get(i).split(":");
			//System.out.println(UserData[UserData.length-1]);
		}	
		//
		for(int i = 0; i < ListInTxt.size() ; i++) {
			UserData = ListInTxt.get(i).split(":"); // �ؽ�Ʈ ������ �� ���� :�� �������� �迭�� ���� (2�κ����� ����)
			UserDataStr[i] = UserData[UserData.length-1]; // ���ϰ� ���� =>  string�̴ϱ� �׳� string���� ����! (���� �ڵ��ϱ�!)
			UserData2 = UserData[UserData.length-1].split("\\(��"); // UserData�� �� �κ��� ����ؾ� �Ѵٴ� ���� �˾��� ���� ������ ( ������ Ž�� ��� �ʿ��� ��!)
			System.out.println("-----------------------------------------------");
			System.out.println("final");
			UserDataStr[i] = UserData2[0];
			System.out.println(UserDataStr[i]);
			System.out.println(UserDataStr[i].length());
			String str = " -------------- ���ڿ��� �¿쿡 ������ �ִ� ��� Trim �Լ� ����� ��� -------------  ";
			System.out.println(str);
			
			UserDataStr[i] = UserDataStr[i].trim();
			
			System.out.println(UserDataStr[i]); // ���������� �츮�� ����� �ϴ� ��
			System.out.println("���ڿ� ũ�� " + UserDataStr[i].length());
			
		}
		
		
		
//			//debugging
			//System.out.println("not change ");
			//System.out.println(UserDataStr[i]);
			
			
			//for(int j = 0; j < UserData.length; j++) {
			
				
				
//				UserDataStr[j] = UserData[UserData.length-1];
//				System.out.println("change");
//				System.out.println(UserDataStr[j]);
				
//			}

			//		System.out.println(UserData2.length);
			//		if () {

			//		UserDataStr = new ArrayList<String>(Arrays.asList(UserData[UserData.length-1]));

		}

	}


//		System.out.println(" " );
//		for(int i = 0; i < ListInTxt.size() ; i++) {
//		System.out.println(UserDataStr[i]);
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//////		for(int i =0; i < 100; i++) {
//////			System.out.println(UserData[i]);
//////		}
//////		
////		for (int i = 0; i < UserData.length; i++) {
////			System.out.println(UserData[UserData.length-1]); // �迭�� ������ ���� ���
////		}
//
//
//	}
//}