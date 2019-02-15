import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List; // �������̽� Ŭ����, java.util.collection interface ����
import java.util.Scanner;

public class text_parsing {

	// tokenizer ���! 

	// ���� �� ���� �д� ���� 
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
		
ArrayList<String> list = new ArrayList<String>();
		
//		int count = 0;
		String DirectoryPath= " "; // DP
		
		File file = new File(DirectoryPath);
//		FileWriter fw = new FileWriter(file, true);
		
		Scanner scan = new Scanner(System.in); // scan�� ���� ���丮 path �Է�
		System.out.println("Enter DirectoryPath");
		
		DirectoryPath = scan.nextLine(); // Ű����� ���ڿ� �Է� �޾� DP�� ���� 
		// �Է� ���� : C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company
		
		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles();  // ���ϸ���Ʈ �迭�� �ּ� ����
		
//		System.out.println(Arrays.toString(fileList)); // �迭 �� Ȯ�� 
	
//		if(fileList.length > 0){ // for the check
//		    for(int i=0; i < fileList.length; i++){ // fieList ����
////		    	System.out.println(File.listFiles());
//		  System.out.println("path ��ü �� ���ϸ���Ʈ" + ":" +  fileList[i]) ; // ���� ���⿡ �� ����� ����
//		 
//		    }
//		}
//		
		for(File f: fileList) { // fileList�� ù��° �ε��� ������ ������
			String str = f.getPath(); // ���� �� ������ 
			if(f.isDirectory()) {
//				System.out.println("directory ����");
//				System.out.print("Directory : ");
//				System.out.print(str + "\t\n");
			}
			
			else {
				if(str.endsWith(".txt")) { 	// txt ���� str�� ��� test
					
//					System.out.println(f); // 
					System.out.println("txt���� : " + str + "\t" + f.length() + "bytes");
					
//					System.out.print("List �ȿ� ��� �ִ� ��" + (++count) );
//					System.out.println("---������ ����---- ");
						list.add(str);
												
				}
			}
		}
//		
//		for(int i = 0 ; i < list.size() ; i++){ // for checking (���� ��� ����)
//	        System.out.println("list[" + i + "] = " + list.get(i));
//	    }
		
	for(int k = 0 ; k < list.size() - 1; k++) {
		List<String> ListInTxt = fileLineRead(list.get(k)); // ��� list�� ����� str ������ �޾� ��
		String[] UserData =  new String[100]; //  ���� count ������ ���� ��� �����ϱ�
		String[] UserData2 =  new String[100];
		String[] UserDataStr = new String[100]; // cut before :  cut after ��:
		//		List<String> UserDataStr = new ArrayList<String>();

//		for(int i = 0; i < ListInTxt.size(); i++){ // �迭�� length ���� �ϳ� �۰�! // for the  checking
//			//�������� ���е� �� ���ڿ��� ListInTxt.get() �ε����� ���ʷ� ��� ����!
//			System.out.println("Line(" + i + ")" + " " + ListInTxt.get(i));
//			System.out.println(" ");
//			//			UserData = ListInTxt.get(i).split(":");
//			//System.out.println(UserData[UserData.length-1]);
//		}	
//		
		//
		for(int i = 0; i < ListInTxt.size() ; i++) {

			UserData = ListInTxt.get(i).split(":"); // �ؽ�Ʈ ������ �� ���� :�� �������� �迭�� ���� (2�κ����� ����)
			UserDataStr[i] = UserData[UserData.length-1]; // : ���� ���, ���ϰ� ���� =>  string�̴ϱ� �׳� string���� ����! (���� �ڵ��ϱ�!)
			//debugging
//			System.out.println(ListInTxt.get(0)); // �� �߶��� �� (�� �� ���� ��Ÿ��)
			
			if ( i == 0 && !( (ListInTxt.get(0).contains("�а�")) ||  (ListInTxt.get(0).contains("�л�")) || (ListInTxt.get(0).contains("����")) ) )  { // ����� ��� ����ڸ� �� if���� ����ǵ��� �س�����
				 // && �Ĺݺο� � ���̶� �ɸ��� ���ڿ� ��ħ ����
				//debugging 
				//System.out.println("working?");
				
//				System.out.println("-----------------------------------------------");
//				System.out.println("Already trim");
				UserDataStr[0] = UserData[UserData.length-2].trim(); // 0���� ���� �Ǵ� �̽� �߻� 
				UserDataStr[1] = UserData[UserData.length-1].trim();

				UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // ���ڿ� ��ġ�� (�̽� �ذ�)
//				for debugging
//				System.out.println(UserDataStr[0]);

			}
			//			

			else { // if �����ϰ� ��� ����� (no problem)
				
				UserData2 = UserData[UserData.length-1].split("\\(��"); // UserData�� �� �κ��� ����ؾ� �Ѵٴ� ���� �˾��� ���� ������ ( ������ Ž�� ��� �ʿ��� ��!)
//				System.out.println("-----------------------------------------------");
//				System.out.println("Last step");
				UserDataStr[i] = UserData2[0];
			}

//			System.out.println(UserDataStr[i]);
//
//			System.out.println(UserDataStr[i].length());
//			String str = " -------------- ���ڿ��� �¿쿡 ������ �ִ� ��� Trim �Լ� ����� ��� -------------  ";
//			System.out.println(str);

			UserDataStr[i] = UserDataStr[i].trim();
//
//			System.out.println(UserDataStr[i]); // ���������� �츮�� ����� �ϴ� ��
//			System.out.println("���ڿ� ũ�� " + UserDataStr[i].length());

		}


		System.out.println("--------------��ƺ���----------------"); 

		for(int i = 0; i < ListInTxt.size() ; i++) {
//			count++;
			System.out.println(UserDataStr[i]) ; // ���������� �츮�� ����� �ϴ� ��
//			System.out.print(" " + count);
		}


	}

}
	
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