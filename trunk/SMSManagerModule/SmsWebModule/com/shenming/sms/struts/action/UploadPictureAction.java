//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package com.shenming.sms.struts.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.struts.form.UploadPictureForm;
import com.shenming.sms.util.Tool;


/** 
 * MyEclipse Struts
 * Creation date: 05-31-2006
 * 
 * XDoclet definition:
 * @struts.action path="/createBasicInfo" name="createBasicInfoForm" input="/createBasicInfo.jsp" scope="request" validate="true"
 * @struts.action-forward name="mainPage" path="/main.jsp"
 * @struts.action-forward name="createError" path="/error.jsp"
 */
public class UploadPictureAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UploadPictureForm uploadPictureForm = (UploadPictureForm) form;
		
		FormFile pic = uploadPictureForm.getPic();
		String filename = getPictureFileName(request);
		String msg = "";
		if (isNull(pic.getFileName())) {
			request.setAttribute("message", "請指定欲上傳之檔案!");
		} else if (!isNull(pic.getFileName())) {
			Tool.logDebug("[UploadPictureAction.java]Uploaded file: " + pic.getFileName() + "; new file name: "
					+ filename);
			File test = new File("./");
			FileOutputStream fts = null;
			try {
				String fullFilename = request.getRealPath("/") + Tool.getStringProperty("UPLOAD_PICTURE_FOLDER")+ filename;
				Tool.logDebug("[UploadPictureAction.java] Environment test=> Is director: " +test.isDirectory() + 
						"\r\nAbs Path: " + test.getAbsolutePath() + 
						"\r\nCanonical Path: "+ test.getCanonicalPath() + 
						"\r\nReal Path" + test.getPath()+
						"\r\nfullFileName: "+fullFilename);
				fts = new FileOutputStream(fullFilename);
				msg= "您的照片已經上載成功!";
				request.setAttribute("message",msg);
			} catch (IOException e) {
				e.printStackTrace();
				Tool.logDebug("[UploadPictureAction.java] Upload file error: "+e.getMessage());
			} finally {
				try {
					fts.write(pic.getFileData());
					if(!ProductManager.updateProductPictureName(new Integer(uploadPictureForm.getIdx()), getPictureFileName(request))){
						request.setAttribute("message","無法更新資料庫!");
						return mapping.findForward("success");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fts.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		if(msg != null){
			request.setAttribute("filename",filename);
			Tool.logDebug("Upload file's filename: "+ filename);
			uploadPictureForm.setPic(null);
			return mapping.findForward("success");
		}
		return null;
	}

	private boolean isNull(Object o) {
		if (o == null || "".equals(o)) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getPictureFileName(HttpServletRequest request){
		UploadPictureForm form = (UploadPictureForm)request.getAttribute("uploadPictureForm");
		String idx = form.getIdx();
		
		String filename = form.getPic().getFileName();
		String[] arg = filename.split("\\.");
		if(arg.length>1){
			String filetype = arg[arg.length-1];
			System.out.println("File Type: "+filetype);
			return idx+"."+filetype;
		} else {
			return null;
		}
	}

}
