package com.my.sts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	String path="D:\\stsWorkspace\\upload\\";

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String uploadForm() {
		return "index";
	}
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String uploadResult(Model model ,MultipartFile[] files,String msg,HttpServletRequest req) {
		System.out.println("upload");
		System.out.println(msg);
		List<Map<String,String>> arr=new ArrayList<>();
		System.out.println(files.length);
		for(MultipartFile file1:files) {
			System.out.println(file1);
			String origin=file1.getOriginalFilename();
			String name=System.currentTimeMillis()+"_"+origin;
			File f=new File(path+name);
			try {
				file1.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Map<String,String> map=new HashMap<>();
			map.put("origin", origin);
			map.put("name", name);
			arr.add(map);
		}
		model.addAttribute("arr", arr);
		return "result";
	}
	
	@GetMapping("/download")
	public void down(String origin,String newName,HttpServletResponse resp) {
		resp.setContentType("application/actet-stream");
		//Content-Disposition: attachment; filename="origin"
		resp.setHeader("Content-Disposition", "attachment; filename=\""+origin+"\"");
		File f=new File(path+newName);
		try(
				InputStream is=new FileInputStream(f);
				OutputStream os=resp.getOutputStream();
				){
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}
		} catch (FileNotFoundException e) {
					e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	@GetMapping("{origin:.+}")
	@GetMapping("{origin}")
	public void down2(@PathVariable String origin,String newName,HttpServletResponse resp) {
		resp.setContentType("application/actet-stream");
		File f=new File(path+newName);
		try(
				InputStream is=new FileInputStream(f);
				OutputStream os=resp.getOutputStream();
				){
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}
		} catch (FileNotFoundException e) {
					e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}








