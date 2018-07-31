/**
 * 
 */
package com.hanbit.Job_Portal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanbit.Job_Portal.bo.LoginBO;
import com.hanbit.Job_Portal.bo.ManagementSettingsBO;
import com.hanbit.Job_Portal.constants.ExtraConstants;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.request.vo.LoginVO;
import com.hanbit.Job_Portal.request.vo.UserManagementRequestVO;
import com.hanbit.Job_Portal.response.vo.ResponseVO;
import com.hanbit.Job_Portal.utils.Encryptor;
/*import com.itextpdf.text.pdf.codec.Base64.OutputStream;*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author Bharat Kumar
 * 
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody ResponseVO validateUser(@RequestBody LoginVO loginvo)
			throws ClassNotFoundException, BusinessException, SQLException {

		LoginBO loginbo = new LoginBO();
		ResponseVO responsevo = new ResponseVO();

		loginvo.setPassword(Encryptor.encrypt(ExtraConstants.key1, ExtraConstants.key2, loginvo.getPassword()));

		try {
			responsevo = loginbo.validateUser(loginvo);
		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}
		return responsevo;
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	ResponseVO forgotpassword(@RequestBody LoginVO loginvo)
			throws ClassNotFoundException, BusinessException, SQLException {

		LoginBO loginbo = new LoginBO();
		System.out.println("userid========>"+loginvo.getUsername());
		ResponseVO responsevo = new ResponseVO();

		try {
			responsevo = loginbo.forgotpassword(loginvo);
			responsevo.setResult("Success");
		}
		 catch (BusinessException e) {
				String message = e.getMessage();
				responsevo.setErrorMessage(message);
			}
		catch (MessagingException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}
		return responsevo;
	}
	
@RequestMapping(value ="/savefile", method=RequestMethod.POST, produces="application/json")
	
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model,HttpSession session)
	         throws IOException {

	
			InputStream in = null;
	        FileOutputStream out = null;
	        String file_name="";
	        boolean success = false;

	      // Save file on system
	System.out.println("------------->"+file);
	
	String path=session.getServletContext().getRealPath("/");  
    String filename=file.getOriginalFilename();  
    
    System.out.println("FileName=========>"+filename+"<----------->"+path+"====================---------->"+file.getOriginalFilename());
      
    System.out.println(path+"\\"+filename);  
    try{  
    	
    	file_name = "FileUploaded";
        String drivename = "";
        drivename = "C://FileUploaded//";
      
        File directory = new File(drivename);
        if (directory.exists()) {
            System.out.println("Directory already exists ...");
        } else {
            System.out.println("Directory not exists, creating now");
            success = directory.mkdir();
        }
        
        byte barr[]=file.getBytes();  
        BufferedOutputStream bout=new BufferedOutputStream(  
            new FileOutputStream(drivename+"/"+filename));  
    		bout.write(barr); 
   
   
   				File oldFile = new File(drivename+"/"+filename);
               File newFile = new File("D:\\jar\\oldFile.docx");
    
               in = new FileInputStream(oldFile);
               out = new FileOutputStream(newFile);
    
               byte[] moveBuff = new byte[1024];
    
               int butesRead;
    
               while ((butesRead = in.read(moveBuff)) > 0) {
                   out.write(moveBuff, 0, butesRead);
               }
    
               in.close();
               out.close();
    
               oldFile.delete();
    
   
               System.out.println("The File was successfully moved to the new folder");

   
   /*Path temp = Files.move
           (Paths.get(path+"/"+filename), 
           Paths.get("D:\\Jar"));
   
   	System.out.println("Temp====>"+temp);
    
           if(temp != null)
           {
               System.out.println("File renamed and moved successfully");
           }
           else
           {
               System.out.println("Failed to move the file");
           }
           
   bout.flush();  
   bout.close();  
    }catch(Exception e){System.out.println(e);}  
    
    Path temp = Files.move
            (Paths.get(path+"\\"+filename), 
            Paths.get("D:/file.docx"));
    
    	System.out.println("Temp====>"+temp);
     
            if(temp != null)
            {
                System.out.println("File renamed and moved successfully");
            }
            else
            {
                System.out.println("Failed to move the file");
            }
	*/
	
	    /*  if (!file.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File("D:/SingleFileUpload", file.getOriginalFilename())));
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();

	         model.addAttribute("msg", "File uploaded successfully.");
	      } else {
	         model.addAttribute("msg", "Please select a valid file..");
	      } */
		
    
    
		ResponseVO responsevo=new ResponseVO();
		
		
		//System.out.println(""+mrregistrationvo.getMrMobile_NOVO());
		//	responsevo=mrregistartionbo.addimage(mrregistrationvo);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		return "success";
	}




@RequestMapping(value = "/user/edit/{SrNo}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
public @ResponseBody ResponseVO edituser(@PathVariable("SrNo") int SrNo,
		@RequestBody UserManagementRequestVO usermanagementvo)
		throws ClassNotFoundException, BusinessException, SQLException {

	ManagementSettingsBO managementsettingsbo = new ManagementSettingsBO();
	ResponseVO responsevo = new ResponseVO();

	usermanagementvo.setUserPassword(
			Encryptor.encrypt(ExtraConstants.key1, ExtraConstants.key2, usermanagementvo.getUserPassword()));
	usermanagementvo.setNewPassword(
			Encryptor.encrypt(ExtraConstants.key1, ExtraConstants.key2, usermanagementvo.getNewPassword()));
	usermanagementvo.setConfirmPassword(
			Encryptor.encrypt(ExtraConstants.key1, ExtraConstants.key2, usermanagementvo.getConfirmPassword()));

	usermanagementvo.setSrNo(SrNo);

	try {
		responsevo.setResult(managementsettingsbo.edituser(usermanagementvo));
	} catch (BusinessException e) {
		String message = e.getMessage();
		responsevo.setErrorMessage(message);
	}

	return responsevo;
}

	
}
