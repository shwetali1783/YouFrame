import java.util.ArrayList;

import com.model.ImageData;

public class UploadService {
	//Search Patient by id
	public static int uploadImage(String recordId,String imagename) {
		return UplaodDAO.uploadImage(recordId,imagename);
	}


	public static ArrayList<ImageData> getAllImage() {
		ArrayList<ImageData> pat = UplaodDAO.getAllImage();
		return pat;
	}
}
