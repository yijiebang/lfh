package com.reinfo.ipoly.module.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reinfo.ipoly.common.config.IpolyConfig;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.common.util.FileUtil;
import com.reinfo.ipoly.module.mappers.ImgflMapper;
import com.reinfo.ipoly.module.mappers.TchflMapper;
import com.reinfo.ipoly.module.models.Imgfl;
import com.reinfo.ipoly.module.models.Stafl;
import com.reinfo.ipoly.module.models.Tchfl;

@Service("imgflService")
public class ImgflService extends BaseServiceImpl<Imgfl, Object, ImgflMapper> {

	@Autowired
	@Qualifier("tchflDao")
	protected TchflMapper tchflDao;

	public void batch(List<Imgfl> list, Stafl stafl) throws Exception {
		Tchfl tchfl = tchflDao.getOneBy(Criteria.newCriteria().addWhere(Tchfl.DBStrTchId, "efs_size"));
		List<Imgfl> addList = new ArrayList<>();
		List<Imgfl> updateList = new ArrayList<>();
		for (Imgfl imgfl : list) {
			imgfl.setImgFileAdate(new Date());
			imgfl.setImgCuser(stafl.getStaUser());
			if (StringUtils.isNotBlank(imgfl.getImgFileBase64())) {
				imgfl.setImgFileBlob(FileUtil.base64ToBytes(imgfl.getImgFileBase64()));
				// imgfl.setImgFileBlob(imgfl.getImgFile());
			} else if (StringUtils.isNotBlank(imgfl.getTmpImgFileName())) {
				imgfl.setImgFileBlob(
						FileUtil.getStrArray(IpolyConfig.getInstance().get("temp.dir") + imgfl.getTmpImgFileName()));
			}
			if (imgfl.getImgFileBlob() != null) {
				if (tchfl != null) {
					long maxFileSize = tchfl.getTchChr1().multiply(new BigDecimal("" + (1024 * 1024))).longValue();
					if (imgfl.getImgFileBlob().length > maxFileSize) {
						throw new ApplicationException(SystemCode.FILE_SIZE_TOO_LARGE.getCode(),
								"File size too large[uploadFileSize={},maxFileSize={}]", imgfl.getImgFile().length,
								maxFileSize);
					}
				}
			}
			if (imgfl.getImgSeqno() == null) {
				imgfl.setImgCdate(new Date());
				imgfl.setImgCuser(stafl.getStaUser());

				// 提供默认值
				imgfl.setImgSt("A");
				imgfl.setImgClmseq(0l);
				imgfl.setImgCopy("Y");
				imgfl.setImgCat(" ");
				imgfl.setImgOffice(" ");
				imgfl.setImgDept(" ");
				imgfl.setImgCls(" ");
				imgfl.setImgAgt(" ");
				imgfl.setImgYear(2000L);
				imgfl.setImgId(" ");
				imgfl.setImgSec(" ");
				imgfl.setImgEndst(0l);
				imgfl.setImgClaim(" ");
				imgfl.setImgVoucher(" ");
				imgfl.setImgTtyId(" ");
				imgfl.setImgTtyUwyr(0l);
				imgfl.setImgTtySec(" ");
				imgfl.setImgSec(" ");
				imgfl.setImgPolicyno(" ");
				imgfl.setImgEndstno(" ");
				imgfl.setImgClaimno(" ");

				addList.add(imgfl);
			} else {
				updateList.add(imgfl);
			}
		}

		if (!addList.isEmpty()) {
			this.getDao().insert(addList);
		}
		if (!updateList.isEmpty()) {
			for (Imgfl imgfl : updateList) {
				this.getDao().updateBy(imgfl,
						Criteria.newCriteria().addWhere(Imgfl.DBStrImgClicode, imgfl.getImgClicode())
								.addWhere(Imgfl.DBStrImgSeqno, imgfl.getImgSeqno()));
			}
		}
	}
}
