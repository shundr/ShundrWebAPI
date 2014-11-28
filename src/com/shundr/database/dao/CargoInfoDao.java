/**
 * 
 */
package com.shundr.database.dao;

import java.util.List;

import com.shundr.database.bean.CargoInfo;
import com.shundr.response.bean.CargoInfoList;

/**
 * @author Snailer
 *
 */
public interface CargoInfoDao {

	/**KGCheng
	 * 通过    起始位置   和    终点位置    搜索货物
	 * @param cargoSrcPlace
	 * @param cargoDstPlace
	 * @return
	 */
	List<CargoInfo> searchCargoListbyPlace(String cargoSrcPlace,
			String cargoDstPlace);

	/**KGCheng
	 *  插入一条货物信息
	 * @param newCargo
	 */
	void saveCargoInfo(CargoInfo newCargo);

	

}
