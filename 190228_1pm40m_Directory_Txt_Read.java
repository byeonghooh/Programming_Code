import java.io.File;
import java.util.ArrayList;

public class Directory_Txt_Read {

	private int Number_Of_Txt_File = 0;

	public ArrayList<String> Txt_Read_In_Directory(String DirectoryPath) {

		ArrayList<String> list = new ArrayList<String>();

		// 파일 경로 저장
		File path = new File(DirectoryPath);
		File[] fileList = path.listFiles(); // 파일리스트 배열에 주소 저장

		for (File f : fileList) { // fileList의 첫번째 인덱스 값부터 가져옴
			String str = f.getPath(); // 파일 명만 가져옴
			if (f.isDirectory()) {
			} 
			else {
				// .txt로 끝나는 파일(txt 파일) 경로 저장
				if (str.endsWith(".txt") && str.contains("키발급신청")) {
					Number_Of_Txt_File++;
					System.out.println(Number_Of_Txt_File + "번째" + " " + "txt파일 : " + str + "\t" + f.length() + "bytes");
					list.add(str);
				}
			}
		}
		return list;
	}

}
