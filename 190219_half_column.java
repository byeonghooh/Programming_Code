
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // 인터페이스 클래스, java.util.collection interface 구현

public class text_parsing {

   public static void main(String[] args) throws IOException {

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
      String I_D_V[] =new String[10];
      String Institution_Location_OR_UserResidence_Value[] = new String[10];
      String Duty_OR_Research_Value[] =new String[10];
      String Key_Issuance_Purpose_Value[] = new String[10];
      String Service_Access_Path_Value[] = new String[10];
      String Institution_Information_Homepage_Address_Value[] =new String[10];
      
      for (int i = 0; i <User_Name_Value.length; i++) {
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
      
      File file = new File("C:\\Users\\HyoungJong\\Desktop\\Trash\\parsing\\UserData.csv");
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));


      ArrayList<String> list = new ArrayList<String>();

      String DirectoryPath= " "; // DP
      int flag = 0;

      DirectoryPath = "C:\\Users\\HyoungJong\\Desktop\\Trash\\parsing";

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

      String[] UserData_ =  new String[10000]; //  : 을 활용 // 고려사항 : 추후 count 때려서 넣을 방법 생각하기
      String[] UserData2 =  new String[10000];
      String[] UserDataStr = new String[10000]; // cut before ":"  , cut after "예:"


      for(int k = 0 ; k < list.size(); k++)  // 파일리스트를 어디까지 읽을 것인가.. 기본적으로 파일 주소 제외..
      { 
         List<String> ListStr = new ArrayList<String>(); // ListStr이라는 ArrayList 객체 생성
         BufferedReader in = new BufferedReader(new FileReader(list.get(k))); // 입력 스트림(FileReader 객체)를 BufferedReader 매개변수로 사용, BufferedReader 객체 생성

         int count = 0;
         int addLineIndex = -1;
         String s;
         
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
         
         // 모든 라인 다 더해서 하나의 string으로 만들기
         String allText = "";
         while ( (s = in.readLine()) != null )
         {
        	 allText += s;
         }
         
         in = new BufferedReader(new FileReader(list.get(k)));

         while ( (s = in.readLine()) != null ) // 라인 없을 때까지 읽음 // 라인의 size 측정
         { // 한 줄 단위로 처리할 수 있는 readLine 메소드를 이용해서 
        	 
        	 
        	// 기관위치 또는 거주지역 파싱
        	 if( (s.contains("지역:") || s.contains("지역 :") ) && Key_Issuance_Purpose.equals("없음") )
        	 {
        		 Institution_Location_OR_UserResidence_Value = s.split(":");
        		 
        		 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence_Value[1];
        		 
        		 if(Institution_Location_OR_UserResidence.contains("(예"))
        			 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.substring(0, Institution_Location_OR_UserResidence.indexOf("(예"));
        		 
        		 if(Institution_Location_OR_UserResidence.contains(","))
        			 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.replace(",", "/");
        		 
        		 Institution_Location_OR_UserResidence = Institution_Location_OR_UserResidence.trim();
        	 }

        	 // 기관위치 또는 거주지역 파싱 예외사항
        	 else if(s.contains("시")&& Key_Issuance_Purpose.equals("없음"))
        	 {
        		 if(s.indexOf("시") + 3 == s.indexOf("구") || s.indexOf("시") + 4 == s.indexOf("구")) // O구, OO구
        		 {
        			 String subString = s.substring(s.indexOf("시"));
        			 Institution_Location_OR_UserResidence = s.substring(s.indexOf("시") - 2, s.indexOf("시") + subString.indexOf("구") + 1);
        		 }
        	 }
        	 
        	 
        	// 담당 업무 파싱
        	 if((s.contains("업무:") || s.contains("업무 :") || s.contains("연구:")) && Key_Issuance_Purpose.equals("없음"))
        	 {
        		 Duty_OR_Research_Value = s.split(":");
        		 
        		 Duty_OR_Research = Duty_OR_Research_Value[1];
        		 
        		 if(Duty_OR_Research.contains("(예"))
        			 Duty_OR_Research = Duty_OR_Research.substring(0, Duty_OR_Research.indexOf("(예"));
        		 
        		 if(Duty_OR_Research.contains(","))
        			 Duty_OR_Research = Duty_OR_Research.replace(",", "/");
        		 
        		 Duty_OR_Research = Duty_OR_Research.trim();
        		 
        		 // 위에 데이터가 공백인 경우 없음으로 처리
        		 if(Duty_OR_Research.equals(""))
        			 Duty_OR_Research = "없음"; // 
        	 }
        	// 담당 업무 파싱 예외사항
        	 else if((s.contains("개발")) && Duty_OR_Research.equals("없음") && s.contains(")")) // 예외 사항 모두 묶음 (개발이 많은 사항 발생)
        	 {
        		 int startIndex = s.indexOf(")");
        		 Duty_OR_Research = s.substring(startIndex + 1);
        		 
        		//  Duty_OR_Research = Duty_OR_Research.replace(",", "");
        		 
        		 Duty_OR_Research = Duty_OR_Research.trim();
        	 }
        	 
        	 
        	// 발급 목적 파싱
        	 if((s.contains("목적:") || s.contains("목적 :")) && Key_Issuance_Purpose.equals("없음"))
        	 {
        		 Key_Issuance_Purpose_Value = s.split(":");
        		 
        		 Key_Issuance_Purpose = Key_Issuance_Purpose_Value[1];
        		 
        		 if(Key_Issuance_Purpose.contains("(예"))
        			 Key_Issuance_Purpose = Key_Issuance_Purpose.substring(0, Key_Issuance_Purpose.indexOf("(예"));
        		 
        		//  if(Key_Issuance_Purpose.contains(","))
        		// 	 Key_Issuance_Purpose = Key_Issuance_Purpose.replace(",", "/");
        		 
        		 Key_Issuance_Purpose = Key_Issuance_Purpose.trim();
        		 
        		 // 위에 데이터가 공백인 경우 없음으로 처리
        		 if(Key_Issuance_Purpose.equals(""))
        			 Key_Issuance_Purpose = "없음";
        		 else
        			 addLineIndex = count + 1; // 없음
        	 }
        	// 엔터가 되어있는 경우 처리
        	 else 
        	 {
        		 if(addLineIndex == count && !(s.contains(":"))) // 다음 줄
        			 Key_Issuance_Purpose += s; // 문자열 붙이기
        		 
        		 if(Key_Issuance_Purpose.contains("(예"))
        			 Key_Issuance_Purpose = Key_Issuance_Purpose.substring(0, Key_Issuance_Purpose.indexOf("(예"));
        	 }
        	// 발급 목적 파싱 예외사항
        	 if((s.contains("공부") || s.contains("제어")) && Key_Issuance_Purpose.equals("없음"))
        	 {
        		 int startIndex = s.indexOf(")");
        		 Key_Issuance_Purpose = s.substring(startIndex + 1);
        		 
        		 Key_Issuance_Purpose = Key_Issuance_Purpose.replace(",", "");
        		 
        		 Key_Issuance_Purpose = Key_Issuance_Purpose.trim();
        	 }
        	 
        	 
        	 // 검색 경로 파싱
        	 if(s.contains("경로") && Service_Access_Path.equals("없음"))
        	 {
        		 Service_Access_Path_Value = s.split(":");
        		 
        		 Service_Access_Path = Service_Access_Path_Value[1];
        		 
        		 if(Service_Access_Path.contains("(예"))
        			 Service_Access_Path = Service_Access_Path.substring(0, Service_Access_Path.indexOf("(예"));
        		 
        		 Service_Access_Path = Service_Access_Path.trim();
        		 
        		 // 공백인 경우 없음으로 처리
        		 if(Service_Access_Path.equals(""))
        			 Service_Access_Path = "없음";
        	 }
        	 // 검색 경로 파싱 예외사항 (경로란 텍스트없이 바로 인터넷이란 답변이 존재...)
        	 else if(s.contains("인터넷") && Service_Access_Path.equals("없음"))
        		 Service_Access_Path = "인터넷";
        	 
            count++;
         }
         
         // 이메일 주소 파싱 (전부 다 한 줄로 만들어서 처리)
    	 if(allText.contains("http"))
    	 {
    		 int Homepage_Address_FirstIndex = allText.indexOf("http");
    		 int Homepage_Address_LastIndex = 0;
    		 
    		 String subText = allText.substring(Homepage_Address_FirstIndex);

    		 Homepage_Address_LastIndex = subText.indexOf(")") - 1; // 2) 전까지 자름 ( 홈페이지 설명 추가 위해서 )
    		 
    		 Institution_Information_Homepage_Address = allText.substring(Homepage_Address_FirstIndex, Homepage_Address_FirstIndex + Homepage_Address_LastIndex);
    		 
    		 Institution_Information_Homepage_Address = Institution_Information_Homepage_Address.replace("	", "");

    		 Institution_Information_Homepage_Address = Institution_Information_Homepage_Address.trim();
    	 }

         if(file.isFile() && file.canWrite() ) 
         {
            if (flag == 0) { // 첫째 줄 칼럼명 삽입 (놔두기)

               bufferedWriter.write("사용자구분" + "\t" + "이름" + "\t" + "이메일 주소" + "\t" + "소속기관명" + "\t" + "소속부서(학과)명" + "\t" + "소속기관위치 또는 거주지역" + "\t" 
                     + "담당업무/연구" + "\t" + "발급목적" + "\t" + "서비스경로" + "\t" + "소속기관정보및홈페이지주소" + "\t");
               bufferedWriter.newLine();

               flag++;
            }

            bufferedWriter.write("\"" + User_Divider + "\"" + "\t" + 
            User_Name + "\t "  + 
            Email_Address + "\t "  + 
            Institution + "\t " + 
            Institution_Department + "\t " + 
            Institution_Location_OR_UserResidence + "\t " + 
            Duty_OR_Research + "\t "  +
            Key_Issuance_Purpose + "\t "  + 
            Service_Access_Path + "\t "  + 
            Institution_Information_Homepage_Address
            ); // \t : 다음 셀로 이동

            bufferedWriter.newLine();
         }
      }
      bufferedWriter.close();
   }
}


