package com.example.demo.jdbc;

import java.util.List;

public interface ISimpleBbsDao {
	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public Integer countDao();
	public int writeDao(final String writer, final String title, final String content);
	public int deleteDao(final String id);
}
