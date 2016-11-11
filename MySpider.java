import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MySpider {
	static int count = 0;
	public static void main(String[] args) {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		String s = "";
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\hpuwx\\Desktop\\各类设计资料，需要的留邮箱_设计师_天涯论坛.html"));
			bw = new BufferedWriter(new FileWriter("C:\\USers\\hpuwx\\Desktop\\EmailAddress.txt"));
			while((s=br.readLine()) != null) {
				parse(s,bw);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void parse(String s, BufferedWriter bw) throws IOException {
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]{3,5}");
		Matcher m = p.matcher(s);
		
		while(m.find()) {
			count ++;
			String emails = m.group();
			bw.write(count+": "+emails);
			bw.newLine();
			bw.flush();
			System.out.println(emails);
		}
		
	}

}
