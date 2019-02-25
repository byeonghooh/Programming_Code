
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
		
//		Java_Txt_parsing_gui Text_Parsing_GUI = new Java_Txt_parsing_gui();
		
//		Text_Parsing_GUI.setVisible(true);
		
		
		String DirectoryPath = args[0];  
		
	/*	args = new String[2];
		args[0] = "Enter DirectoryPath : ";
		args[1] = new*/
		
		
		int Number_Of_Txt_File = 0;
		int count = 0;

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

		String User_Divider_Value[] = { "개인", "학교", "기업" };
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
		
		
//		System.out.println(" Main 함수 - GUI 함수 값 " + Text_Parsing_GUI.getDirectoryPath());
//		DirectoryPath = Text_Parsing_GUI.getDirectoryPath();
		//System.out.println(Text_Parsing_GUI.getDirectoryPath());

		// 파일 경로 저장
		File path = new File(DirectoryPath);
//		System.out.println("Path 찍나요:?" + path);
		File[] fileList = path.listFiles(); // 파일리스트 배열에 주소 저장

//		System.out.println("path.listFile 값 " + fileList);
		
		for (File f : fileList) { // fileList의 첫번째 인덱스 값부터 가져옴
			String str = f.getPath(); // 파일 명만 가져옴
			if (f.isDirectory()) {
			} 
			else {
				// .txt로 끝나는 파일(txt 파일) 경로 저장
				if (str.endsWith(".txt")) {
					Number_Of_Txt_File++;
					System.out
							.println(Number_Of_Txt_File + "번째" + " " + "txt파일 : " + str + "\t" + f.length() + "bytes");
					list.add(str);
				}
			}
		}

		// 파일 리스트 읽기
		for (int k = 0; k < list.size(); k++) {
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // 입력 스트림(FileReader 객체)를 // 설마 한 번만 읽고
																					// 끝나나? 넵
			BufferedReader in2 = new BufferedReader(new FileReader(list.get(k)));

			int addLineIndex_User_Divider = -1;
			int addLineIndex_Key = -1;
			int addLineIndex_Duty = -1;
			int addLineIndex_Service = -1;

			String s = " "; // 이슈1
			String AllText = " ";
			while ((s = in.readLine()) != null) {
				AllText += s; // 한 줄의 스트링
			}

			// 없음으로 초기화
			User_Divider = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			User_Name = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Email_Address = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Institution = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Institution_Department = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Institution_Location_OR_UserResidence = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Duty_OR_Research = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Key_Issuance_Purpose = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Service_Access_Path = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			Institution_Information_Homepage_Address = "없음(사용자 미입력)";

			//
			while ((s = in2.readLine()) != null) {// 라인 없을 때까지 읽음 // 라인의 size 측정 { // 한 줄 단위로 처리할 수 있는 readLine 메소드를
													// 이용해서

				// line by line Debugging
				System.out.println(s);

				// User_Divider
				if (AllText.contains("개인사용자")) { // || s.contains("개인")
					User_Divider = User_Divider_Value[0];
				}

				if (s.contains("학과") || AllText.contains("학교")) { //
					User_Divider = User_Divider_Value[1];
				}

				if (s.contains("1)") && (s.contains("회사") || s.contains("부서"))
						&& User_Divider.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) {
					User_Divider = User_Divider_Value[2];
					addLineIndex_User_Divider = count + 1;
				} else {
					if (addLineIndex_User_Divider == count && (s.contains("http") || s.contains("co"))) {
						User_Divider = User_Divider_Value[2];
					}
				}

				// User_Name
				if (s.contains("키발급신청")) {
					User_Name_Value = s.split("\\]");
					System.out.println("내용 있다" + User_Name_Value[1].substring(1, 4));
					User_Name = User_Name_Value[1].substring(1, 4);
					System.out.println("진짜 칼럼 값" + " : " + User_Name);
				}

				// User_Email_Address
				int Email_Address_Last_Idx = 0;
				int Email_Address_First_Idx = 0;

				if (s.contains("보낸 사람") && !s.contains("이문영") && !s.contains("김원영") && s.contains("@")) { // 없으면 안 담음 //
																											// 한줄짜리는 여기서
																											// 다 담김

					if(AllText.contains(">")) {
					Email_Address_Last_Idx = AllText.indexOf(">");
					Email_Address = AllText.substring(0, Email_Address_Last_Idx);
					Email_Address_First_Idx = Email_Address.indexOf("<");

					Email_Address = Email_Address.substring(Email_Address_First_Idx + 1).trim();
					System.out.println("체크 포인트 1 : " + Email_Address);

					if (Email_Address.contains("wykim@etri.re.kr")) {
						Email_Address = "관리자가 확인 필요";
						System.out.println("관리자 이메일 제외 1" + Email_Address);

					}
					}
				}

				else if (Email_Address.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)") && s.contains("@")) { // 처음에 데이터 나온다 가정

					Email_Address_Last_Idx = AllText.indexOf(">");
					Email_Address = AllText.substring(0, Email_Address_Last_Idx); // 끝 인덱스는 포함 X 이고, allText 정제 ( > 기준으로
																					// 짤림 )
					Email_Address_First_Idx = Email_Address.indexOf("<");

					Email_Address = Email_Address.substring(Email_Address_First_Idx + 1);
					System.out.println("체크 포인트 2 : " + Email_Address);

					if (Email_Address.contains("wykim@etri.re.kr")) {
						Email_Address = "관리자가 확인 필요";
						System.out.println("관리자 이메일 제외 2" + Email_Address);

					}
				}

				// User Email 예외 사항 - 잡는 거 비효율적 (케이스 너무 많음)
//				else if(s.contains("보낸 사람") && s.contains("@")) {
//					//Email_Address_First_Idx = AllText.indexOf("보낸 사람");
//					
//					Email_Address_Last_Idx = AllText.indexOf("보낸 날짜");
//					Email_Address = AllText.substring(0, Email_Address_Last_Idx);
//					Email_Address_First_Idx = Email_Address.indexOf("보낸 사람");
//					Email_Address = Email_Address.substring(Email_Address_First_Idx+6, Email_Address_Last_Idx).trim();
//					
//					//Email_Address = AllText.substring(Email_Address_First_Idx, Email_Address_Last_Idx).trim();
//					
//					System.out.println("체크 포인트 3 : "+ Email_Address);
//				}

				// Institution
				int Institution_First_Idx = 0;
				int Institution_Last_Idx = 0;

				if (s.contains("키를 신청하실때 소속정보를")) {
					Institution_First_Idx = s.indexOf("소속정보를");
					Institution_Last_Idx = s.indexOf("라고 입력");
					Institution_Last_Idx = s.indexOf("라고");

					System.out.println("첫번째 인덱스 값 : " + Institution_First_Idx);
					System.out.println("마지막 인덱스 값 : " + Institution_Last_Idx);

					Institution = s.substring(Institution_First_Idx + 5, Institution_Last_Idx - 1).trim();
				}

				else if (AllText.contains("개인사용자") || AllText.contains("개인목적")) {

					if (s.contains("소속기관 정보")) {
						Institution_Value = s.split(":");
						if (Institution_Value.length >= 2) {
							Institution = Institution_Value[1].trim();
						}

					} else {
						Institution = "소속기관 없음(개인사용자)";
						Institution_Department = "소속부서 없음(개인사용자)";
					}
				}

				// Institution_Department

				int Institution_Department_First_Idx = AllText.indexOf("부서");
				int Institution_Department_Last_Idx = 0;

				// 부서가 1번에 위치해 있을 때 - 2번 전에서 끊음
				if (s.contains("1)") && (s.contains("부서:") || s.contains("부서 :"))
						&& Institution_Department != "소속부서 없음(개인사용자)") {

					String subText_Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();

					if ((subText_Institution_Department.contains("지역") || subText_Institution_Department.contains("위치")) && (subText_Institution_Department.contains("2)")
							|| subText_Institution_Department.contains("2."))) {
						Institution_Department_Last_Idx = subText_Institution_Department.indexOf("2");

						System.out.println("2)의 위치 탐색" + Institution_Department_Last_Idx);

						Institution_Department = AllText.substring(Institution_Department_First_Idx + 3,
								Institution_Department_First_Idx + Institution_Department_Last_Idx).trim();
						System.out.println("ID_1!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					} else {
						Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();
						System.out.println("ID_2!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					}

				}

				// 부서가 2번에 위치해있을 때 - 3번 전에서 끊음
				else if ((s.contains("2)") || s.contains("2.")) && (s.contains("부서:") || s.contains("부서 :"))
						&& Institution_Department != "소속부서 없음(개인사용자)") {
					String subText_Institution_Department_2 = AllText.substring(Institution_Department_First_Idx)
							.trim();

//					if (Institution_Department == "없음") {
					if ((subText_Institution_Department_2.contains("3)")
							|| subText_Institution_Department_2.contains("3."))) {
						Institution_Department_Last_Idx = subText_Institution_Department_2.indexOf("3");
						System.out.println("3)의 위치 탐색" + Institution_Department_Last_Idx);

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

				Institution_Department_First_Idx = AllText.indexOf("학과");
				Institution_Department_Last_Idx = 0;

				// 부서가 1번에 위치해 있을 때 - 2번 전에서 끊음
				if (s.contains("1)") && (s.contains("학과:") || s.contains("학과 :"))
						&& Institution_Department != "소속부서 없음(개인사용자)") {
//					Sysout
					String subText_Institution_Department_3 = AllText.substring(Institution_Department_First_Idx)
							.trim();

					if (subText_Institution_Department_3.contains("지역")
							&& (subText_Institution_Department_3.contains("2)")
									|| subText_Institution_Department_3.contains("2."))) {
						Institution_Department_Last_Idx = subText_Institution_Department_3.indexOf("2)");

						System.out.println("2)의 위치 탐색" + Institution_Department_Last_Idx);

						Institution_Department = AllText.substring(Institution_Department_First_Idx + 4,
								Institution_Department_First_Idx + Institution_Department_Last_Idx).trim();
						System.out.println("ID_1!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					} else {
						Institution_Department = AllText.substring(Institution_Department_First_Idx).trim();
						System.out.println("ID_2!!!!!!!!!!!!!!!!!!!!!! : " + Institution_Department);

					}

				}

				// Institution_Location_OR_UserResidence

				if ((s.contains("지역:") || s.contains("지역 :"))
						&& Institution_Location_OR_UserResidence.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) {
					Institution_Location_OR_UserResidence_Value = s.split(":");

					if (Institution_Location_OR_UserResidence_Value.length == 2) {
						Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence_Value[1].trim();
					}
					if (Institution_Location_OR_UserResidence.contains("(예")) // 확인필요
						Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence
								.substring(0, Institution_Location_OR_UserResidence.indexOf("(예")).trim();

					if (Institution_Location_OR_UserResidence == "") {
						Institution_Location_OR_UserResidence = "빈칸의 이유(스페이스=>엄서요)";
					}

					// 확인요 Institution_Location_OR_UserResidence =
					// Institution_Location_OR_UserResidence.trim();
				}

				// 기관위치 또는 거주지역 파싱 예외사항
				else if (s.contains("시") && Institution_Location_OR_UserResidence.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) // 시
																															// 구까지만
																															// 출력
																															// (나머지
																															// 데이터는
																															// 버림)
				{
					System.out.println("바보");
					if (s.indexOf("시") + 3 == s.indexOf("구") || s.indexOf("시") + 4 == s.indexOf("구")) // O구, OO구
					{
						System.out.println("바보2");
						String subString = s.substring(s.indexOf("시")); // 시부터 시작해서 문자열 가져옴
						Institution_Location_OR_UserResidence = s
								.substring(s.indexOf("시") - 2, s.indexOf("시") + subString.indexOf("구") + 1).trim();
						System.out.println("소속기관지역!!!!!" + Institution_Location_OR_UserResidence);
					}
				}

				// Duty_OR_Research

				int Duty_OR_Research_First_Idx = 0;

				if ((s.contains("업무:") || s.contains("업무 :") || s.contains("연구:"))
						&& Duty_OR_Research.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) {
					Duty_OR_Research_Value = s.split(":");
					if (Duty_OR_Research_Value.length == 2) {
						Duty_OR_Research = Duty_OR_Research_Value[1];
					}

					if (Duty_OR_Research.contains("(예")) {
						Duty_OR_Research = Duty_OR_Research.substring(0, Duty_OR_Research.indexOf("(예"));
					}
//	        		 else addLineIndex_Duty = count + 1; // 이슈 2

					Duty_OR_Research = Duty_OR_Research.trim();

					// 위에 데이터가 공백인 경우 없음으로 처리 -> 두번째 사용자 양식에서 읽게 만들기
					if (Duty_OR_Research.equals(""))
						Duty_OR_Research = "없음"; // 확인
//					  else addLineIndex_Duty = count + 1; // 없음 X ( 데이터 못 잡는 경우 )
					addLineIndex_Duty = count + 1; // 밑에서 걸리니까 else에 넣을 필요 없음
				}

				// 담당 업무 파싱 예외사항
				else if (!s.contains("부서") && (s.contains("개발"))
						&& Duty_OR_Research.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)") && s.contains(")")) // 예외 사항 모두 묶음
																										// (개발이 많은 사항
																										// 발생)
				{
					Duty_OR_Research_First_Idx = s.indexOf(")");
					Duty_OR_Research = s.substring(Duty_OR_Research_First_Idx + 1).trim();

					Duty_OR_Research = Duty_OR_Research.trim();
				}

				// 바로 위에 코드 수정한 것
				else if (addLineIndex_Duty == count && !(s.contains(":"))) {
					// 다음 즐
					Duty_OR_Research = s.trim(); // 없음 삭제
				}

				// Key_Issuance_Purpose
				int Key_Issuance_Purpose_First_Idx = 0;

				if ((s.contains("목적:") || s.contains("목적 :"))
						&& Key_Issuance_Purpose.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) {

					Key_Issuance_Purpose_Value = s.split(":");

					if (Key_Issuance_Purpose_Value.length == 2) {
						Key_Issuance_Purpose = Key_Issuance_Purpose_Value[1].trim();
					}

					if (Key_Issuance_Purpose.contains("(예"))
						Key_Issuance_Purpose = Key_Issuance_Purpose.substring(0, Key_Issuance_Purpose.indexOf("(예"))
								.trim();

					Key_Issuance_Purpose = Key_Issuance_Purpose.trim();

					// 위에 데이터가 공백인 경우 없음으로 처리

					addLineIndex_Key = count + 1;

				}

				// 바로 위에 코드 수정한 것
				else if (addLineIndex_Key == count && !(s.contains(":"))) {
					// 다음 즐
					if (Key_Issuance_Purpose.contains("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)"))
						Key_Issuance_Purpose = s;
					else
						Key_Issuance_Purpose += s;
				}

				// 발급 목적 파싱 예외사항
				if ((s.contains("공부") || s.contains("제어"))
						&& Key_Issuance_Purpose.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) {
					Key_Issuance_Purpose_First_Idx = s.indexOf(")");
					Key_Issuance_Purpose = s.substring(Key_Issuance_Purpose_First_Idx + 1).trim();

					Key_Issuance_Purpose = Key_Issuance_Purpose.trim();
				}

				// Service_Access_Path
				// 검색 경로 파싱
				if ((s.contains("경로") || s.contains("경로:") || s.contains("경로 :"))
						&& Service_Access_Path.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)")) {
					Service_Access_Path_Value = s.split(":");

					if (Service_Access_Path_Value.length == 2) {
						Service_Access_Path = Service_Access_Path_Value[1].trim();
					}

					if (Service_Access_Path.contains("(예"))
						Service_Access_Path = Service_Access_Path.substring(0, Service_Access_Path.indexOf("(예"))
								.trim();

					Service_Access_Path = Service_Access_Path.trim();

					// 위에 사용자가 데이터 입력 안 한 경우 초기값 설정
//	        		 if(Service_Access_Path.equals(""))
//	        			 Service_Access_Path = "없음";

					addLineIndex_Service = count + 1;
				}

				// Enter 처리 (
				else if (addLineIndex_Service == count && !(s.contains(":"))) {
					// 다음 즐
					if (Service_Access_Path.contains("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)"))
						Service_Access_Path = s;
					else
						Service_Access_Path += s;
				}

				// 검색 경로 파싱 예외사항 (경로란 텍스트없이 바로 인터넷이란 답변이 존재...)
				else if (s.contains("인터넷") && Service_Access_Path.equals("관리자가 입력 필요(형식 미준수 또는 파일 깨짐)"))
					Service_Access_Path = "인터넷";

				count++;
			}

			// Institution_Information_Homepage_Address
			// 홈페이지 주소 및 소속 기관 설명 파싱 (전부 다 한 줄로 만들어서 처리)
			int Homepage_Address_FirstIndex = AllText.indexOf("http");
			int Homepage_Address_LastIndex = 0;

			if (AllText.contains("http")) {
				String subText = AllText.substring(Homepage_Address_FirstIndex);

				if (subText.contains(")")) {
					Homepage_Address_LastIndex = subText.indexOf(")") - 1; // 2) 전까지 자름 ( 홈페이지 설명 추가 위해서 )

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

				Homepage_Address_LastIndex = subText.indexOf(")") - 1; // 2) 전까지 자름 ( 홈페이지 설명 추가 위해서 )

				Institution_Information_Homepage_Address = AllText.substring(Homepage_Address_FirstIndex,
						Homepage_Address_FirstIndex + Homepage_Address_LastIndex).trim();

				Institution_Information_Homepage_Address = Institution_Information_Homepage_Address.trim();
			}

			// 개인 사용자 구분 조건 최종 체크
			if (Institution == "소속기관 없음(개인사용자)" && Institution_Department == "소속부서 없음(개인사용자)") {
				User_Divider = User_Divider_Value[0];
			}

			Institution_Department = Institution_Department.replaceAll(" ", "");
			Institution_Department = Institution_Department.trim();

			if (Institution_Department.length() == 0) {
				Institution_Department = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
			}

			Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.replaceAll(" ", "");
			Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.trim();

			if (Institution_Location_OR_UserResidence.length() == 0) {
				Institution_Location_OR_UserResidence = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
			}

			Duty_OR_Research = Duty_OR_Research.replaceAll(" ", "");
			Duty_OR_Research = Duty_OR_Research.trim();

			/*
			 * if (Duty_OR_Research.length() == 0) { Duty_OR_Research=
			 * "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)"; }
			 */
			
			/*
			 * if (Duty_OR_Research == "") { // 주소값 비교 (객체의 동일성 판단)
			 * 
			 * Duty_OR_Research = "관리자가 확인 필요(질문 형식 다름 or 형식 미준수)"; }
			 */
			
			  if (Duty_OR_Research.equals("")) { // 객체의 값 비교
			  
			  Duty_OR_Research = "관리자가 확인 필요(질문 형식 다름 or 형식 미준수)"; }
			 
			Key_Issuance_Purpose = Key_Issuance_Purpose.replaceAll(" ", "");
			Key_Issuance_Purpose = Key_Issuance_Purpose.trim();

			if (Key_Issuance_Purpose.length() == 0) {
				Key_Issuance_Purpose = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
			}
			
			

			Service_Access_Path = Service_Access_Path.replaceAll(" ", "");
			Service_Access_Path = Service_Access_Path.trim();

			if (Service_Access_Path.length() == 0) {
				Service_Access_Path = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
			}
			
			if(Duty_OR_Research.length() < 4 && Key_Issuance_Purpose.length() < 4   ) {
				Duty_OR_Research = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
				Key_Issuance_Purpose = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
				Service_Access_Path = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
				
				
			}
			
			//  주변으로만 짤리는 케이스임
			if(Service_Access_Path.contains("주변") && Service_Access_Path.length() < 3) {
				System.out.println("truetrue");
				Service_Access_Path = "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
			}
			
			if( Institution.length() > 40 ||  Institution_Department.length() > 40  ||  Institution_Location_OR_UserResidence.length() > 40
				|| Duty_OR_Research.length() > 40 || (Key_Issuance_Purpose.length() > 40 && !Key_Issuance_Purpose.contains("니다"))
				|| Service_Access_Path.length() > 100 ) 
			{
				Institution_Department = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
				Institution_Location_OR_UserResidence = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
				Duty_OR_Research = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
				Key_Issuance_Purpose = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
				Service_Access_Path = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";				
				Institution_Information_Homepage_Address = "관리자가 확인 필요(질문 형식 다름 또는 형식 미준수)";
			}
			
//			
//			if ( ) {
//				Service_Access_Path =  "관리자가 입력 필요(형식 미준수 또는 파일 깨짐)";
//			}

//			if (Institution_Location_OR_UserResidence== null) {
//				
//				Institution_Location_OR_UserResidence= "관리자가 확인 필요(질문 형식 다름 or 형식 미준수)";
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
				if (first_row_flag == 0) { // 첫째 줄 칼럼명 삽입

					bufferedWriter.write("사용자구분" + "\t" + "이름" + "\t" + "이메일 주소" + "\t" + "소속기관명" + "\t" + "소속부서(학과)명"
							+ "\t" + "소속기관위치 또는 거주지역" + "\t" + "담당업무/연구" + "\t" + "발급목적" + "\t"
							+ "서비스(open API 사이트) 접근 경로" + "\t" + "소속기관정보및홈페이지주소" + "\t");
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
