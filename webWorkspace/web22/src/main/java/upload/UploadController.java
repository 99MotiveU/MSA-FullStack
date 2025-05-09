package upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/upload.do")
public class UploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getRealPath("upload");
		System.out.println(path);
		MultipartRequest mreq = null;
		FileRenamePolicy frp=new DefaultFileRenamePolicy();
		int max=1024*1024*5;
		mreq=new MultipartRequest(req, path,max,frp);
		System.out.println(mreq.getParameter("msg"));
		System.out.println(mreq.getOriginalFileName("file1"));
		req.setAttribute("fname", mreq.getFilesystemName("file1"));
		req.setAttribute("origin", mreq.getOriginalFileName("file1"));
		req.getRequestDispatcher("upload.jsp").forward(req, resp);
	}
}












