import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*s*
 * 
 */

/**
 * @author imrul
 *
 */
public class testCal {
	public static void main(String[] args) {
		 
		BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
			String filePath = System.getProperty("user.dir")+"/src/EGEW_513_SWM_Ch_4_Storg_collect_transp.txt";
			br = new BufferedReader(new FileReader(filePath));
			File file = new File(System.getProperty("user.dir")+"/src/testFiles/EGEW_513_SWM_Ch_4_Storg_collect_transp.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.print(sCurrentLine);
		    	// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}
				bw.write(sCurrentLine);
				System.out.print(sCurrentLine);
			}
			bw.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 
	}

}
//mport java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
// 
//public class BufferedReaderExample {
// 
//	public static void main(String[] args) {
// 
//		BufferedReader br = null;
// 
//		try {
// 
//			String sCurrentLine;
// 
//			br = new BufferedReader(new FileReader("C:\\testing.txt"));
// 
//			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
//			}
// 
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null)br.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
// 
//	}
//}