
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.model.ImageData;

/**
 * Servlet implementation class upload_image
 */
@WebServlet("/upload_image")
public class upload_image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload_image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<ImageData> images  = UploadService.getAllImage();
		request.setAttribute("imageRecord", images); 
		//System.out.print(images.size());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

    private final String UPLOAD_DIRECTORY = "H:/Shwetali/workplace/YouFrame/WebContent/img";
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		//process only if its multipart content
		String path  = "", imagename="";
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                @SuppressWarnings("unchecked")
				List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = "image_"+System.currentTimeMillis();
                        String name1 =  new File(item.getName()).getName();
                        //System.out.print(new java.util.Date());
                        
                        name +="."+ FilenameUtils.getExtension(name1);
                        imagename = name;
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        path = "img\\"+ name;
                    }
                }
            
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
               
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
               //System.out.print("Hello ex" );
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");

            System.out.print("Hello Soorryy");
        }
		
		
		
		

		int result = UploadService.uploadImage(path,imagename);
		doGet(request, response);
//		ArrayList<ImageData> images  = UploadService.getAllImage();
//		request.setAttribute("imageRecord", images); 
//		//System.out.print(images.size());
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
