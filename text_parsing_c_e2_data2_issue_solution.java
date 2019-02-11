import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List; // 인터페이스 클래스, java.util.collection interface 구현

public class text_parsing {

	// tokenizer 사용! 

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
		List<String> ListInTxt = fileLineRead("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company\\c_data4.txt");
		String[] UserData =  new String[100]; //  추후 count 때려서 넣을 방법 생각하기
		String[] UserData2 =  new String[100];
		String[] UserDataStr = new String[100]; // cut before :  cut after 예:
		//		List<String> UserDataStr = new ArrayList<String>();

		for(int i = 0; i < ListInTxt.size(); i++){ // 배열의 length 보다 하나 작게!
			//개행으로 구분된 각 문자열은 ListInTxt.get() 인덱스에 차례로 담겨 있음!
			System.out.println("Line(" + i + ")" + " " + ListInTxt.get(i));
			//			UserData = ListInTxt.get(i).split(":");
			//System.out.println(UserData[UserData.length-1]);
		}	
		//
		for(int i = 0; i < ListInTxt.size() ; i++) {

			UserData = ListInTxt.get(i).split(":"); // 텍스트 파일의 각 행을 :을 기준으로 배열에 저장 (2부분으로 나뉨)
			UserDataStr[i] = UserData[UserData.length-1]; // : 이후 담기, 편하게 생각 =>  string이니까 그냥 string으로 보관! (쉽게 코딩하기!)
			
		    if (i == 0) {
//		    	debugging : System.out.println("working?");
		    	UserDataStr[0] = UserData[UserData.length-2].trim(); // 0에만 들어가게 되는 이슈 발생 
		    	UserDataStr[1] = UserData[UserData.length-1].trim();
		    	
		    	UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // 문자열 합치기 (이슈 해결)
		    	System.out.println(UserDataStr[0]);
		    	
		    }
//			
		    
		    else {
			UserData2 = UserData[UserData.length-1].split("\\(예"); // UserData의 앞 부분을 사용해야 한다는 것을 알았을 때의 문제임 ( 일일이 탐색 고려 필요할 듯!)
			System.out.println("-----------------------------------------------");
			System.out.println("final");
			UserDataStr[i] = UserData2[0];
			System.out.println(UserDataStr[i]);
			System.out.println(UserDataStr[i].length());
			String str = " -------------- 문자열에 좌우에 공백이 있는 경우 Trim 함수 사용한 결과 -------------  ";
			System.out.println(str);
			
			UserDataStr[i] = UserDataStr[i].trim();
			
			System.out.println(UserDataStr[i]); // 최종적으로 우리가 얻고자 하는 것
			System.out.println("문자열 크기 " + UserDataStr[i].length());
			
		}
		}
		
		System.out.println("--------------모아보기----------------"); 
			
			for(int i = 0; i < ListInTxt.size() ; i++) {
				
				System.out.println(UserDataStr[i]); // 최종적으로 우리가 얻고자 하는 것
			}
			
	}

}