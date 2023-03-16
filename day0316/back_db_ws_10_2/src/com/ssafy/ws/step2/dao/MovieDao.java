package com.ssafy.ws.step2.dao;

import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

public interface MovieDao {
	//전체 게시글을 몽땅 들고 오쎄용
	public List<Movie> selectAll();

	
}
