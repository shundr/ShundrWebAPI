/**
 * 
 */
package com.shundr.response.bean;

import java.util.List;

import com.shundr.database.bean.CargoInfo;


/**
 * @author Snailer
 *
 */
public class CargoInfoList {
	private List<CargoInfo> cargoInfoList=null;

	public List<CargoInfo> getCargoInfoList() {
		return cargoInfoList;
	}

	public void setCargoInfoList(List<CargoInfo> cargoInfoList) {
		this.cargoInfoList = cargoInfoList;
	}
}
