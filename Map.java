import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;

public class Map {
	
	String A = Test.G;
	String B = Test.F;

	Map(){
		
		if (!B.equals("")) {
			try {
				String url = "https://map.naver.com/v5/search/";
				url += URLEncoder.encode(A, "UTF-8");
				Desktop.getDesktop().browse(new URI(url));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		
//		Map m = new Map();
		

	}

}
