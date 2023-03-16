package com.ssafy.ws.step2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;
import com.ssafy.ws.step2.util.DBUtil;

public class MovieDaoImpl implements MovieDao{

	private final DBUtil util = DBUtil.getInstance();
	
	private static MovieDaoImpl instance = new MovieDaoImpl();
	
	private MovieDaoImpl() {}
	
	public static MovieDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Movie> selectAll() {
		
		List<Movie> mvList = new ArrayList<>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM movie";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setRunningTime(rs.getInt("runningtime"));
				mvList.add(movie);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, stmt, rs);
		}
		return mvList;
	}
	
}
