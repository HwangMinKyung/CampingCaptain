package com.camping.biz.realreview.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camping.biz.dao.RealReviewDAO;
import com.camping.biz.dto.RealReviewVO;

import com.camping.biz.realreview.RealReviewService;

import utils.Criteria;

@Service("reviewsService")
public class RealReviewServiceImpl implements RealReviewService {

	@Autowired
	private RealReviewDAO reviewsDao;

	@Override
	public List<RealReviewVO> listReview(RealReviewVO vo) {
		return reviewsDao.listReview(vo);
	}

	@Override
	public RealReviewVO detailReviews(int rseq) {
		return reviewsDao.detailReviews(rseq);
	}

	@Override
	public int updateViewCount(int rseq) {
		return reviewsDao.updateViewCount(rseq);
	}

	@Override
	public int countReviewlist(String title) {
		return reviewsDao.countReviewlist(title);
	}

	@Override
	public List<RealReviewVO> getListWithPaging(Criteria criteria, String title) {
		return reviewsDao.getListWithPaging(criteria, title);
	}

	@Override
	public void insertReview(RealReviewVO vo) {
		reviewsDao.insertReview(vo);
	}

	@Override
	public List<RealReviewVO> seemyreview(RealReviewVO vo) {
		return reviewsDao.seemyreview(vo);
	}

	@Override
	public void deletereviews(int rseq) {
		reviewsDao.deletereviews(rseq);
	}

	@Override
	public void modifyreviews(RealReviewVO vo) {
		reviewsDao.modifyreviews(vo);
	}

	@Override
	public List<RealReviewVO> getListWithPaging2(Criteria criteria, String id, String title) {
		return reviewsDao.getListWithPaging2(criteria, id, title);
	}

	@Override
	public List<RealReviewVO> areaList(RealReviewVO vo) {
		return reviewsDao.areaList(vo);
	}

	@Override
	public int countReviewlist2(RealReviewVO vo) {
		return reviewsDao.countReviewlist2(vo);
	}

}
