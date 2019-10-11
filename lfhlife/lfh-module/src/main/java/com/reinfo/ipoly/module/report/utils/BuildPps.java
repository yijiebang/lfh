package com.reinfo.ipoly.module.report.utils;

import java.util.LinkedList;

import com.reinfo.ipoly.module.models.Pol;
import com.reinfo.ipoly.module.models.Polval;
import com.reinfo.ipoly.module.models.Pps;
import com.reinfo.ipoly.module.models.Rider;

public interface BuildPps {
	Pps buildPpsData();	
	LinkedList<Rider> buildPpsRiderData();
	LinkedList<Pol> buildPpsPolData();
	LinkedList<Polval> buildPpsPolvalData();
}
