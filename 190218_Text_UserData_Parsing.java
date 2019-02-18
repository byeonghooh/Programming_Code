
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
		File[] fileList = path.listFiles(); // 파일리스트 배열에 주소 저장

		for (File f : fileList) { // fileList의 첫번째 인덱스 값부터 가져옴
			String str = f.getPath(); // 파일 명만 가져옴
			if (f.isDirectory()) {
			} else {
				// .txt로 끝나는 파일(txt 파일) 경로 저장

				if (str.endsWith(".txt")) {
					count++;
					System.out.println(count + "번째" + " " + "txt파일 : " + str + "\t" + f.length() + "bytes");
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

		String[] UserData_ = new String[10]; // : 을 활용 // 고려사항 : 추후 count 때려서 넣을 방법 생각하기
		String[] UserData2 = new String[10];
		String[] UserDataStr = new String[10]; // cut before ":" , cut after "예:"

		// String s;
		// s.contains("d");

		
		
		for (int k = 0; k < list.size(); k++) // 파일리스트를 어디까지 읽을 것인가.. 기본적으로 파일 주소 제외..
		{
			List<String> ListStr = new ArrayList<String>(); // ListStr이라는 ArrayList 객체 생성
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // 입력 스트림(FileReader 객체)를
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
			

	
			String s = " ";
			String Previous_User_Name = " "; 
			  while ( (s = in.readLine()) != null ) 
			  {// 라인 없을 때까지 읽음 // 라인의 size 측정 { // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서
				  
//			  ListStr.add(s);
				 // line_counter++;
				  
				   System.out.println(s);
				   
				   // 보낸 사람 if문 고려!
				   
				   // User_Name(사용자 이름)
				   if(s.contains("키발급신청")){
					  // System.out.println("제목 있다" + count1++);
					   User_Name_Value = s.split("\\]");
					   System.out.println("내용 있다" + User_Name_Value[1].substring(1, 4));
					   User_Name = User_Name_Value[1].substring(1, 4);
					   System.out.println("진짜 칼럼 값" + " : " + User_Name);
					   Previous_User_Name = User_Name;
					   if (Previous_User_Name == User_Name) { // 이전 값과 비교
						   User_Name = Previous_User_Name;
					   }
					   
				   }
				   
				   // Email_Address
				   if(s.contains("보낸 사람") && !s.contains("이문영") && !s.contains("김원영") && s.contains("@")) {
					   System.out.println("보낸사람 있다" + (++count1) );
					   
					   Email_Address_Value = s.split("<");
					   System.out.println("메일 있다" + Email_Address_Value[1]);
					   
				   }
				   
				   else if(s.contains("보낸 사람") && !s.contains("@")) { // 관리자는 무조건 첫 줄에 이름이나 아이디 나타남!
					   System.out.println("한칸 띄어 있다" + "위에 if문에 배제되는지 체크할 값 : " + count1 + " /" + (++count2) );
//					   System.out.println(line_counter + " :        " + ListStr.get(line_counter));
					   
					   if (s.contains("보낸 사람") && s.contains("@")) {
						 System.out.println("메일 뒤 저장 완료");  
						   
					   }					   
					   
				   }
				   
				   
			  }
				    
				   
				  

//			while ((s = in.readLine()) != null) // 라인 없을 때까지 읽음 // 라인의 size 측정
//			{ // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서
//				// 이름 출력
//				if (s.contains("키발급신청") == false) {
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

//				System.out.println(++i + "번째 파일");
//				Institution_Department = s.substring(s.lastIndexOf("1") + 2); 
//				Institution_Department = Institution_Department.trim();
//				I_D_V[I_D_V.length - 1] = Institution_Department;
//				
//				System.out.println("Last IDV 1" +" ------------" + I_D_V[I_D_V.length-1]);
//				if(Institution_Department != null) {
//					System.out.println("Last ID : " + "----------------" +  Institution_Department + ++i);
//				}

//				if (s.contains(":") && !s.contains("http") )  //  : 은 있으나 홈페이지가 아닌 경우
//				{
//					
//					
//					I_D_V = s.split(":");
//					
//					if( I_D_V[I_D_V.length - 1] == null || I_D_V[I_D_V.length - 1].contains("없음") ) {
//					  I_D_V[I_D_V.length - 1] = "없음" ;
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
			// System.out.println("ㅇㅇㅇㅇㅇ");
			// }

//				count++;
//				System.out.println(count);

			// ListStr.add(s); // ArrayList 객체인 ListStr에 문자열값 추가, index에 차례로 입력됨

			// System.out.println(" ");

			// System.out.println(s);
			// System.out.println(ListStr); // ListStr 배열이 가지고 있는 인덱스 값 모두 출력

//
//			if (ListStr.size() == count ) {
//				System.out.println("있는 거" + count);
//			}
			// for(int i = 0; i < ListStr.size(); i++)
			// {
			//
			// UserData_Criterion_1 = ListStr.get(i).split(":"); // 텍스트 파일의 각 행을 :을 기준으로 배열에
			// 저장 (2부분으로 나뉨)
			// UserDataStr[i] = UserData_Criterion_1[UserData_Criterion_1.length-1]; // : 이후
			// 담기, 편하게 생각 => string이니까 그냥 string으로 보관!
			//
			// if ( i == 0 && UserData_Criterion_1.length-2 != -1 &&
			// !( (ListStr.get(0).contains("학과")) || (ListStr.get(0).contains("학생")) ||
			// (ListStr.get(0).contains("없음")) ) ) { // 현재는 기업 사용자만 이 if문이 실행되도록 해놓았음
			//
			// UserDataStr[0] = UserData_Criterion_1[UserData_Criterion_1.length-2].trim();
			// // 0에만 들어가게 되는 이슈 발생, 회사 소개 or 홈페이지 주소
			// UserDataStr[1] = UserData_Criterion_1[UserData_Criterion_1.length-1].trim();
			// // 홈페이지 주소 or 회사 소개
			// UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // 문자열 합치기 (이슈 해결)
			// //username = UserDataStr[0];
			//
			// }
			//
			// else { // if 제외하고 모든 경우임 (no problem)
			// UserData2 =
			// UserData_Criterion_1[UserData_Criterion_1.length-1].split("\\(예"); //
			// UserData의 앞 부분을 사용해야 한다는 것을 알았을 때의 문제임 ( 일일이 탐색 고려 필요할 듯!)
			// UserDataStr[i] = UserData2[0];
			//
			// }
			// UserDataStr[i] = UserDataStr[i].trim();
			// }

			// System.out.println("최종 결과");
			// for(int i = 0; i < ListStr.size() ; i++)
			// {
			// // count++;
			// // System.out.print(" " + count + " ");
			// System.out.println(ListStr.get(i).toString());
			//// System.out.println(UserDataStr[i]) ; // 최종적으로 우리가 얻고자 하는 것
			// // System.out.println(ListStr.size());
			//
			// }

			// for(int i = 0; i <ListStr.size(); i++) {

			if (file.isFile() && file.canWrite()) {
				if (flag == 0) { // 첫째 줄 칼럼명 삽입

					bufferedWriter.write("사용자구분" + "\t" + "이름" + "\t" + "이메일 주소" + "\t" + "소속기관명" + "\t" + "소속부서(학과)명"
							+ "\t" + "소속기관위치 또는 거주지역" + "\t" + "담당업무/연구" + "\t" + "발급목적" + "\t" + "서비스경로" + "\t"
							+ "소속기관정보및홈페이지주소" + "\t");
					bufferedWriter.newLine();

					flag++;
				}

				bufferedWriter.write("없음" + "\t" + "\"" + User_Name + "\"" + "\t");
//				bufferedWriter.write("없음" + "\t" + "\"" + I_D_V[I_D_V.length-1] + "\"" + "\t" );
				bufferedWriter.newLine();

				// bufferedWriter.write("없음" + "\t" + "없음" + "\t" + "없음" + "\t" + "\"" + "\"" +
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
