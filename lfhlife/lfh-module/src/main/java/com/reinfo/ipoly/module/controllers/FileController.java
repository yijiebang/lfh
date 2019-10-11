package com.reinfo.ipoly.module.controllers;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.reinfo.ipoly.common.config.ConstantContext;
import com.reinfo.ipoly.common.config.IpolyConfig;
import com.reinfo.ipoly.common.util.FileUtil;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;

@Controller
@RequestMapping(value = "file")
public class FileController extends BaseWebController {
	public static final Logger LOG = LoggerFactory.getLogger(FileController.class);

	/**
	 * 上传文件，base64
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "uploadByBase64.json")
	public String uploadByBase64(@RequestBody Map<String, String> parameter) throws Exception {
		Assert.notNull(parameter, "文件后缀不能为空");
		String suffix = parameter.get("suffix");// 后缀
		String base64Str = parameter.get("file");// base64 str
		Assert.hasLength(suffix, "上传类型不能为空");
		Assert.hasLength(base64Str, "附件内容不能为空");
		File tempFile = new File(IpolyConfig.getInstance().get("temp.dir"));
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		String name = "ipoly_" + new Date().getTime();
		String fileName = name + "." + suffix;

		FileUtil.generateFile(base64Str, IpolyConfig.getInstance().get("temp.dir") + fileName);
		return fileName;
	}

	/**
	 * 上传文件，流上传
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "upload.json")
	public String upload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("file") CommonsMultipartFile file) throws Exception {
		file.getOriginalFilename();
		long startTime = System.currentTimeMillis();
		LOG.info("[{}]开始上传", file.getOriginalFilename());
		File tempFile = new File(IpolyConfig.getInstance().get("temp.dir"));
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		String name = "ipoly_" + new Date().getTime();
		String fileName = name + "." + suffix;
		File newFile = new File(IpolyConfig.getInstance().get("temp.dir") + fileName);
		file.transferTo(newFile);
		LOG.info("[{}]上传完成时间：" + String.valueOf(System.currentTimeMillis() - startTime) + " ms",
				file.getOriginalFilename());
		return fileName;
	}
}
