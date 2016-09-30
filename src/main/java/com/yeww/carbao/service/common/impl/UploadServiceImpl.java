package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.service.common.IUploadService;
import com.yeww.carbao.utils.StringUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/12.
 */
@Service
public class UploadServiceImpl implements IUploadService {

    @Value("${uploadUrl}")
    private String uploadUrl;

    @Value("${uploadReturnUrl}")
    private String uploadReturnUrl;

    @Override
    public String upload(HttpServletRequest request) {
        String path = uploadUrl;
        String returnUrl = uploadReturnUrl;

        FileOutputStream outputStream = null;
        try {

            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(999999999);
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return null;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name + "=" + value);
                } else {//如果fileitem中封装的是上传文件
                    String filename = item.getName();
                    if (StringUtil.isEmpty(filename)) {
                        return null;
                    }
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    if (filename.endsWith(".html") || filename.endsWith(".htm")) {
                        path += "html/";
                        returnUrl += "html/";
                    } else if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".gif")) {
                        path += "img/";
                        returnUrl += "img/";
                    } else {
                        path += "file/";
                        returnUrl += "file/";
                    }
                    File dir = new File(path);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    filename = System.currentTimeMillis() + filename;
                    returnUrl += filename;
                    path += filename;
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(path);
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }

                    in.close();
                    out.close();
                    item.delete();
                    return returnUrl;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
