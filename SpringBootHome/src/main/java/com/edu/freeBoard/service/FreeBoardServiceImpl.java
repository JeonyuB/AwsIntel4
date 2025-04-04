package com.edu.freeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.freeBoard.dao.FreeBoardDao;
import com.edu.freeBoard.domain.FreeBoardVo;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{

	@Autowired
	public FreeBoardDao freeBoardDao;
	
	@Override
	public List<FreeBoardVo> freeBoardSelectList(int start, int end) {
		// TODO Auto-generated method stub
		return freeBoardDao.freeBoardSelectList(start, end);
	}

	@Override
	public int freeBoardSelectTotalCount() {
		// TODO Auto-generated method stub
		return freeBoardDao.freeBoardSelectTotalCount();
	}

}
