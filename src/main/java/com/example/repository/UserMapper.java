package com.example.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.MUser;

@Mapper
public interface UserMapper {

	/** ユーザー登録 */
	public int insertOne(MUser user);
	/** ユーザー取得 */
	public List<MUser> findMany();
	/**ユ－ザー取得(１件)*/
public MUser findOne(int employeeId);
	
	/** ユーザー更新(1件) */
	public void updateOne(@Param("employeeId") int employeeId,
	@Param("employeePass") String employeePass,
	@Param("employeeName") String employeeName,
	@Param("mail")String mail,
	@Param("phone")String phone,
	@Param("anniversary")Date anniversary);
	
	/** ユーザー削除(1件) */
	public int deleteOne(@Param("employeeId") int employeeId);
}
