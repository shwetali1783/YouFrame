import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.ImageData;

public class UplaodDAO {

	public static int uploadImage(String recordId,String imagename){
		//ImageData patient = new ImageData();
		int status = 0;
		try {
			PreparedStatement ps = null;
			Connection conn= uploadUtil.getConnection();
			ps = conn.prepareStatement("INSERT INTO upload_record (image_path, image_name) VALUES (?,?)");

			ps.setString(1,recordId);
			ps.setString(2,imagename);
			status = ps.executeUpdate();
			conn.close();
			ps.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return status;
		//return true;
	}

	public static ArrayList<ImageData> getAllImage(){
		ArrayList<ImageData> mImageData = new ArrayList<ImageData>();
		try {
			Connection conn=uploadUtil.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs=statement.executeQuery("SELECT *  FROM `upload_record`");
			while(rs.next()) {
				ImageData list = new ImageData();
				list.setId(rs.getString(rs.findColumn("image_id")));
				list.setImagePath(rs.getString(rs.findColumn("image_path")));
				list.setImageName(rs.getString(rs.findColumn("image_name")));
				mImageData.add(list);
			}
			conn.close();
			rs.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return mImageData;
	}
	
}
