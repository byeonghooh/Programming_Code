
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // 인터페이스 클래스, java.util.collection interface 구현

public class Text_UserData_Parsing {

	public static void main(String[] args) throws IOException {

		int Number_Of_Txt_File = 0;
		int count1 = 0;
		int count2 = 0;

		String User_Divider = "없음";
		String User_Name = "없음";
		String Email_Address = "없음";
		String Institution = "없음";
		String Institution_Department = "없음";
		String Institution_Location_OR_UserResidence = "없음";
		String Duty_OR_Research = "없음";
		String Key_Issuance_Purpose = "없음";
		String Service_Access_Path = "없음";
		String Institution_Information_Homepage_Address = "없음";

		String User_Divider_Value[] = {"개인", "학교", "기업"};
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
		File[] fileList = path.listFiles(); // 파일리스트 배열에 주소 저장

		for (File f : fileList) { // fileList의 첫번째 인덱스 값부터 가져옴
			String str = f.getPath(); // 파일 명만 가져옴
			if (f.isDirectory()) {
			} else {
				// .txt로 끝나는 파일(txt 파일) 경로 저장

				if (str.endsWith(".txt")) {
					Number_Of_Txt_File++;
					System.out.println(Number_Of_Txt_File + "번째" + " " + "txt파일 : " + str + "\t" + f.length() + "bytes");
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
		//				// 모두 없음으로 넣기
		//
		//				bufferedWriter2.write("없음" + "\t" + "없음" + "\t" + "없음" + "\t" + "없음" + "\t" + "없음"
		//						+ "\t" + "없음" + "\t" + "없음" + "\t" + "없음" + "\t" + "없음" + "\t"
		//						+ "없음" );
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
		
		for (int k = 0; k < list.size(); k++) // 파일리스트를 어디까지 읽을 것인가.. 기본적으로 파일 주소 제외..
		{
			List<String> ListStr = new ArrayList<String>(); // ListStr이라는 ArrayList 객체 생성
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // 입력 스트림(FileReader 객체)를 // 설마 한 번만 읽고 끝나나?
			BufferedReader in2 = new BufferedReader(new FileReader(list.get(k)));
			// BufferedReader 매개변수로 사용,
			// BufferedReader 객체 생성

			//			String p = " ";
			//			int line_counter = 0;
			//			while ( (p = in.readLine()) != null ) // 라인 없을 때까지 읽음 // 라인의 size 측정
			//			{ // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서 
			//				ListStr.add(p); // ArrayList 객체인 ListStr에 문자열값 추가, index에 차례로 입력됨
			//				                       // 이전 값 처리 목적
			//				line_counter++;
			//			}
			
			int count = 0;
			int addLineIndex = -1;
			String s = " ";
			String AllText = " ";
			while ( (s= in.readLine()) != null) 
			{
				AllText += s; // 한 줄의 스트링
				
			}
			
//			System.out.println(AllText); 

			 // 없음으로 초기화
	         User_Divider = "없음";
	         User_Name = "없음";
	         Email_Address = "없음";
	         Institution = "없음";
	         Institution_Department = "없음";
	         Institution_Location_OR_UserResidence = "없음";
	         Duty_OR_Research = "없음";
	         Key_Issuance_Purpose = "없음";
	         Service_Access_Path = "없음";
	         Institution_Information_Homepage_Address = "없음";
			
		
//			String Previous_User_Name = " "; 
			while ( (s = in2.readLine()) != null ) 
			{// 라인 없을 때까지 읽음 // 라인의 size 측정 { // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서

				System.out.println(s);

				// User_Name(사용자 이름)
			
				if(s.contains("키발급신청")){
					// System.out.println("제목 있다" + count1++);
					User_Name_Value = s.split("\\]");
					System.out.println("내용 있다" + User_Name_Value[1].substring(1, 4));
					User_Name = User_Name_Value[1].substring(1, 4);
					System.out.println("진짜 칼럼 값" + " : " + User_Name);
					//Previous_User_Name = User_Name;
				}
				
//				//예외 사항, 하지 말기!
//				if(s.contains("김종율") ) { // ** (OOO님)
//					User_Name = "김종율";
//				}
//			}
				
				// Email_Address
				int Email_Address_Last_Idx = 0;
				int Email_Address_First_Idx = 0;
				
				if(s.contains("보낸 사람") && !s.contains("이문영") && !s.contains("김원영") && s.contains("@")) { // 없으면 안 담음 // 한줄짜리는 여기서 다 담김
					
					Email_Address_Last_Idx = AllText.indexOf(">");
					AllText =AllText.substring(0, Email_Address_Last_Idx);
			        Email_Address_First_Idx = AllText.indexOf("<");

//			        Debugging
//					System.out.println("이메일 첫번째 인덱스 위치" + Email_Address_First_Idx);
//					System.out.println("이메일 마지막 인덱스 위치" + Email_Address_Last_Idx);
//					System.out.println(AllText.substring(Email_Address_First_Idx+1));

			        Email_Address = AllText.substring(Email_Address_First_Idx+1);
				}
				
				else if(Email_Address.equals("없음") && s.contains("@")) { // 처음에 데이터 나온다 가정
					
					Email_Address_Last_Idx = AllText.indexOf(">");
					AllText =AllText.substring(0, Email_Address_Last_Idx); // 끝 인덱스는 포함 X 이고, allText 정제 ( > 기준으로 짤림 )
					Email_Address_First_Idx = AllText.indexOf("<");

//			        Debugging
//					System.out.println("이메일 첫번째 인덱스 위치" + Email_Address_First_Idx);
//					System.out.println("이메일 마지막 인덱스 위치" + Email_Address_Last_Idx);
//					System.out.println(AllText.substring(Email_Address_First_Idx+1)); // 시작 인덱스는 포함임
					
					Email_Address = AllText.substring(Email_Address_First_Idx+1);
					
//					System.out.println("이메일 후에 한칸 띄어 있다" + (++count2) );
					
				}
				
				// Institution_Department
			
				int First_Idx = 0;
				int Last_Idx = 0;
			
				if(s.contains("부서")) { // 없으면 안 담음 // 한줄짜리는 여기서 다 담김

					First_Idx = s.indexOf("부서");
					Institution_Department_Value = s.split("부서"); // 관리자가 입력하는 정보
					
					if (Institution_Department.equals("없음")) {
					
					Institution_Department = s.substring(First_Idx+3).trim(); // 첫번째 저장된 값
					System.out.println("부서명 : " + Institution_Department);
					}
				
				}
				
				if(s.contains("학과")) { // 없으면 안 담음 // 한줄짜리는 여기서 다 담김

					First_Idx = s.indexOf("학과");
					Institution_Department_Value = s.split("학과"); // 관리자가 입력하는 정보
//					Institution_Department_Value = s.split("학과 :");
//					Institution_Department_Value = s.split("학과  :");
					
					if (Institution_Department.equals("없음") && Institution_Department_Value.length == 2) {
					
					Institution_Department = s.substring(First_Idx+4).trim(); // 첫번째 저장된 값
					System.out.println("학과명 : " + Institution_Department);
					}
				
				}
				
				// User_Divider
				if(AllText.contains("개인사용자") ) { // || s.contains("개인")
					User_Divider = User_Divider_Value[0];
				}
				
				if(s.contains("학과") || AllText.contains("학교")) { // 
					User_Divider = User_Divider_Value[1];
				}
				
				
				if (s.contains("1)") && (s.contains("회사") || s.contains("부서")) && User_Divider.equals("없음")) 
				{
					User_Divider = User_Divider_Value[2];
					addLineIndex = count + 1; 
					}
			    else {
			    	if (addLineIndex == count && (s.contains("http") || s.contains("co")) ) {
			    		User_Divider = "회사";
			    	}
			    }
				
				
				
				
				count++;
			}
			
			if (file.isFile() && file.canWrite()) {
				if (first_row_flag == 0) { // 첫째 줄 칼럼명 삽입

					bufferedWriter.write("사용자구분" + "\t" + "이름" + "\t" + "이메일 주소" + "\t" + "소속기관명" + "\t" + "소속부서(학과)명"
							+ "\t" + "소속기관위치 또는 거주지역" + "\t" + "담당업무/연구" + "\t" + "발급목적" + "\t" + "서비스경로" + "\t"
							+ "소속기관정보및홈페이지주소" + "\t");
					bufferedWriter.newLine();

					first_row_flag++;
				}

				bufferedWriter.write("\"" + User_Divider + "\"" + "\t" + "\"" + User_Name + "\"" + "\t" + "\"" + Email_Address + "\"" + "\t" + "\"" + Institution + "\"" + "\t"
				+ "\"" + Institution_Department + "\"" + "\t");
				//				bufferedWriter.write("없음" + "\t" + "\"" + I_D_V[I_D_V.length-1] + "\"" + "\t" );
				bufferedWriter.newLine();

				// bufferedWriter.write("없음" + "\t" + "없음" + "\t" + "없음" + "\t" + "\"" + "\"" +
				// "\t" +"\"" + UserDataStr[1] + "\"" + "\t" +"\"" + UserDataStr[2] + "\""
				// + "\t" +"\"" + UserDataStr[3] + "\"" + "\t" +"\"" + UserDataStr[4] + "\"" +
				// "\t" +"\"" + UserDataStr[5] + "\"" + "\t" + UserDataStr[0]);
				// bufferedWriter.newLine();

			}
		
		}
		bufferedWriter.close();

	}
}
