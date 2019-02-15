import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // 인터페이스 클래스, java.util.collection interface 구현

public class text_parsing {


	public static void main(String args[]) throws IOException {

	    File file2 = new File("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company\\Writer7.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

		ArrayList<String> list = new ArrayList<String>();

		//		int count = 0;
		String DirectoryPath= " "; // DP

		DirectoryPath = "C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company";

		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles();  // 파일리스트 배열에 주소 저장

		for(File f: fileList) { // fileList의 첫번째 인덱스 값부터 가져옴
			String str = f.getPath(); // 파일 명만 가져옴
			if(f.isDirectory()) {
			}
			else {
				// .txt로 끝나는 파일(txt 파일) 경로 저장
				if(str.endsWith(".txt")) 
				{ 	
					System.out.println("txt파일 : " + str + "\t" + f.length() + "bytes");
					list.add(str);
				}
			}
		}

		// -------------------------------------------------------------------------------------------

//		File file2 = new File("C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\2.company\\Writer3.csv");
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
//
//		String username  = " ";
//		String department = " ";
//		String location = " ";
//		String csvrow = " ";

		String[] UserData =  new String[100]; //  고려사항 : 추후 count 때려서 넣을 방법 생각하기
		String[] UserData2 =  new String[100];
		String[] UserDataStr = new String[100]; // cut before ":"  , cut after "예:"

		for(int k = 0 ; k < list.size() -1; k++)  // 파일리스트를 어디까지 읽을 것인가.. 기본적으로 파일 주소 제외..
		{ 
			List<String> ListStr = new ArrayList<String>(); // ListStr이라는 ArrayList 객체 생성
			BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // 입력 스트림(FileReader 객체)를 BufferedReader 매개변수로 사용, BufferedReader 객체 생성

			int count = 0;
			String s;
			while ( (s = in.readLine()) != null ) // 라인 없을 때까지 읽음 // 라인의 size 측정
			{ // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서 
				count++;
				ListStr.add(s); // ArrayList 객체인 ListStr에 문자열값 추가, index에 차례로 입력됨

				//				System.out.println(" ");

				//				System.out.println(s);
				// System.out.println(ListStr); // ListStr 배열이 가지고 있는 인덱스 값 모두 출력
			}

			for(int i = 0; i < ListStr.size(); i++) 
			{

				UserData = ListStr.get(i).split(":"); // 텍스트 파일의 각 행을 :을 기준으로 배열에 저장 (2부분으로 나뉨)
				UserDataStr[i] = UserData[UserData.length-1]; // : 이후 담기, 편하게 생각 =>  string이니까 그냥 string으로 보관!

				if ( i == 0 && UserData.length-2 != -1 && 
						!( (ListStr.get(0).contains("학과")) ||  (ListStr.get(0).contains("학생")) || (ListStr.get(0).contains("없음")) ) )  { // 현재는 기업 사용자만 이 if문이 실행되도록 해놓았음

					UserDataStr[0] = UserData[UserData.length-2].trim(); // 0에만 들어가게 되는 이슈 발생, 회사 소개 or 홈페이지 주소
					UserDataStr[1] = UserData[UserData.length-1].trim(); // 홈페이지 주소 or 회사 소개
					UserDataStr[0] = UserDataStr[0].concat(UserDataStr[1]); // 문자열 합치기 (이슈 해결)
					//username = UserDataStr[0];

				}

				else { // if 제외하고 모든 경우임 (no problem)
					UserData2 = UserData[UserData.length-1].split("\\(예"); // UserData의 앞 부분을 사용해야 한다는 것을 알았을 때의 문제임 ( 일일이 탐색 고려 필요할 듯!)
					UserDataStr[i] = UserData2[0];

				}
				UserDataStr[i] = UserDataStr[i].trim();
			}
			
			for(int i = 0; i < ListStr.size() ; i++) 
			{
				//				count++;
				//				System.out.print(" " + count + " ");
				System.out.println(UserDataStr[i]) ; // 최종적으로 우리가 얻고자 하는 것
//				System.out.println(ListStr.size());
				
			}

//			for(int i = 0; i <ListStr.size(); i++) {

				if(file2.isFile() && file2.canWrite() ) 
				{
					bufferedWriter.write("\"" +  UserDataStr[0] + "\"" + "\t" +"\"" +  UserDataStr[1] + "\"" + "\t" +"\"" +  UserDataStr[2] + "\"" 
													+ "\t" +"\"" +  UserDataStr[3] + "\"" + "\t" +"\"" +  UserDataStr[4] + "\"" + "\t" +"\"" +  UserDataStr[5] + "\"");
					bufferedWriter.newLine();	

				}
//			}
				
			

			}
		bufferedWriter.close();
		}
}
	