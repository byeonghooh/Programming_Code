import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List; // 인터페이스 클래스, java.util.collection interface 구현
import java.util.Scanner;

public class text_parsing {

	// tokenizer 사용! 

	// 파일 내 라인 읽는 목적 
	public static List<String> fileLineRead(String name) throws IOException // java List<String> 함수로 만듬 (크기 지정 제한 없음)
	{
		List<String> ListStr = new ArrayList<String>(); // ListStr이라는 ArrayList 객체 생성
		BufferedReader in = new BufferedReader(new FileReader(name)); // 입력 스트림(FileReader 객체)를 BufferedReader 매개변수로 사용, BufferedReader 객체 생성
		String s; 
		while ((s = in.readLine()) != null) { // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서 
			ListStr.add(s); // ArrayList 객체인 ListStr에 문자열값 추가, index에 차례로 입력됨
			// System.out.println(ListStr); // ListStr 배열이 가지고 있는 인덱스 값 모두 출력
		}
		in.close();
		return ListStr; // 배열 리턴
	}
	
	
public static void main(String args[]) throws IOException {
		
ArrayList<String> list = new ArrayList<String>();
		
//		int count = 0;
		String DirectoryPath= " "; // DP
		
		File file = new File(DirectoryPath);
//		FileWriter fw = new FileWriter(file, true);
		
		Scanner scan = new Scanner(System.in); // scan을 통해 디렉토리 path 입력
		System.out.println("Enter DirectoryPath");
		
		DirectoryPath = scan.nextLine(); // 키보드로 문자열 입력 받아 DP에 저장 
		// 입력 예시 : C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company
		
		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles();  // 파일리스트 배열에 주소 저장
		
//		System.out.println(Arrays.toString(fileList)); // 배열 값 확인 
	
//		if(fileList.length > 0){ // for the check
//		    for(int i=0; i < fileList.length; i++){ // fieList 갯수
////		    	System.out.println(File.listFiles());
//		  System.out.println("path 객체 내 파일리스트" + ":" +  fileList[i]) ; // 지금 여기에 다 담겨져 있음
//		 
//		    }
//		}
//		
		for(File f: fileList) { // fileList의 첫번째 인덱스 값부터 가져옴
			String str = f.getPath(); // 파일 명만 가져옴 
			if(f.isDirectory()) {
//				System.out.println("directory 존재");
//				System.out.print("Directory : ");
//				System.out.print(str + "\t\n");
			}
			
			else {
				if(str.endsWith(".txt")) { 	// txt 파일 str만 담기 test
					
//					System.out.println(f); // 
					System.out.println("txt파일 : " + str + "\t" + f.length() + "bytes");
					
//					System.out.print("List 안에 들어 있는 값" + (++count) );
//					System.out.println("---절대경로 저장---- ");
						list.add(str);
												
				}
			}
		}
//		
//		for(int i = 0 ; i < list.size() ; i++){ // for checking (파일 경로 저장)
//	        System.out.println("list[" + i + "] = " + list.get(i));
//	    }
		
	for(int k = 0 ; k < list.size() - 1; k++) {
		List<String> ListInTxt = fileLineRead(list.get(k)); // 상기 list에 저장된 str 값에서 받아 옴
		String[] UserData =  new String[100]; //  추후 count 때려서 넣을 방법 생각하기
		String[] UserData2 =  new String[100];
		String[] UserDataStr = new String[100]; // cut before :  cut after 예:
		//		List<String> UserDataStr = new ArrayList<String>();

//		for(int i = 0; i < ListInTxt.size(); i++){ // 배열의 length 보다 하나 작게! // for the  checking
//			//개행으로 구분된 각 문자열은 ListInTxt.get() 인덱스에 차례로 담겨 있음!
//			System.out.println("Line(" + i + ")" + " " + ListInTxt.get(i));
//			System.out.println(" ");
//			//			UserData = ListInTxt.get(i).split(":");
//			//System.out.println(UserData[UserData.length-1]);
//		}	
//		
		//
		for(int i = 0; i < ListInTxt.size() ; i++) {

			UserData = ListInTxt.get(i).split(":"); // 텍스트 파일의 각 행을 :을 기준으로 배열에 저장 (2부분으로 나뉨)
			UserDataStr[i] = UserData[UserData.length-1]; // : 이후 담기, 편하게 생각 =>  string이니까 그냥 string으로 보관! (쉽게 코딩하기!)
			//debugging
//			System.out.println(ListInTxt.get(0)); // 안 잘랐을 때 (각 그 행을 나타냄)
			
			if ( i == 0 && !( (ListInTxt.get(0).contains("학과")) ||  (ListInTxt.get(0).contains("학생")) || (ListInTxt.get(0).contains("없음")) ) )  { // 현재는 기업 사용자만 이 if문이 실행되도록 해놓았음
				 // && 후반부에 어떤 것이라도 걸리면 문자열 합침 실행
				//debugging 
				//System.out.println("working?");
				
//				System.out.println("-----------------------------------------------");
//				System.out.println("Already trim");
				UserDataStr[0] = UserData[UserData.length-2].trim(); // 0에만 들어가게 되는 이슈 발생 
				UserDataStr[1] = UserData[UserData.length-1].trim();

				UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // 문자열 합치기 (이슈 해결)
//				for debugging
//				System.out.println(UserDataStr[0]);

			}
			//			

			else { // if 제외하고 모든 경우임 (no problem)
				
				UserData2 = UserData[UserData.length-1].split("\\(예"); // UserData의 앞 부분을 사용해야 한다는 것을 알았을 때의 문제임 ( 일일이 탐색 고려 필요할 듯!)
//				System.out.println("-----------------------------------------------");
//				System.out.println("Last step");
				UserDataStr[i] = UserData2[0];
			}

//			System.out.println(UserDataStr[i]);
//
//			System.out.println(UserDataStr[i].length());
//			String str = " -------------- 문자열에 좌우에 공백이 있는 경우 Trim 함수 사용한 결과 -------------  ";
//			System.out.println(str);

			UserDataStr[i] = UserDataStr[i].trim();
//
//			System.out.println(UserDataStr[i]); // 최종적으로 우리가 얻고자 하는 것
//			System.out.println("문자열 크기 " + UserDataStr[i].length());

		}


		System.out.println("--------------모아보기----------------"); 

		for(int i = 0; i < ListInTxt.size() ; i++) {
//			count++;
			System.out.println(UserDataStr[i]) ; // 최종적으로 우리가 얻고자 하는 것
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
////			System.out.println(UserData[UserData.length-1]); // 배열의 마지막 원소 출력
////		}
//
//
//	}
//}