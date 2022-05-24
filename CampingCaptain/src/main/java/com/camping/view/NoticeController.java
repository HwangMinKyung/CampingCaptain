package com.camping.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.camping.biz.dto.AdminVO;
import com.camping.biz.dto.NoticeVO;
import com.camping.biz.notice.NoticeService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	/*
	 * �������� �󼼺���, ��ȸ�� ���� - ��ȸ��,ȸ��
	 */
	@RequestMapping(value = "/notice_detail", method = RequestMethod.GET)
	public String noticeDetail(HttpSession session, NoticeVO vo, Model model, int nseq) {

		noticeService.updateViewCount(vo.getNseq()); // ��ȸ�� ����

		NoticeVO noticeDetail = noticeService.detailNotice(nseq);
		model.addAttribute("noticeVO", noticeDetail);

		return "notice/noticeDetail";
	}

	/*
	 * �������� �󼼺���, ��ȸ�� ���� - ������
	 */
	@RequestMapping(value = "/master_manage_notice_detail", method = RequestMethod.GET)
	public String masterNoticeDetail(HttpSession session, NoticeVO vo, Model model, int nseq) {

		AdminVO loginAdmin = (AdminVO) session.getAttribute("loginAdmin");
		noticeService.updateViewCount(vo.getNseq()); // ��ȸ�� ����

		NoticeVO noticeDetail = noticeService.detailNotice(nseq);
		model.addAttribute("noticeVO", noticeDetail);
		model.addAttribute("admin", loginAdmin.getName());

		return "notice/master_noticeDetail";
	}

	/*
	 * ��������(����¡ ó��) ��ȸ - ��ȸ��,ȸ��
	 */
	@RequestMapping(value = "/notice_list", method = RequestMethod.GET)
	public String noticeList(@RequestParam(value = "key", defaultValue = "") String title, Criteria criteria,
			HttpSession session, Model model) {

		List<NoticeVO> noticeList = noticeService.getListWithPaging(criteria, title);

		PageMaker pageMaker = new PageMaker();
		int totalCount = noticeService.countNoticetList(title);

		pageMaker.setCriteria(criteria); // ���� �������� �������� �׸� �� ���� ����
		pageMaker.setTotalCount(totalCount); // ��ü �������� ��� ���� ���� �� ������ ���� �ʱ�ȭ

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeListSize", noticeList.size());
		model.addAttribute("pageMaker", pageMaker);

		return "notice/noticeList"; // �������� ����Ʈ ȭ������ ����
	}

	/*
	 * ��������(����¡ ó��) ��ȸ - ������
	 */

	@RequestMapping(value = "/master_manage_notice_list", method = RequestMethod.GET)
	public String masterNoticeList(@RequestParam(value = "key", defaultValue = "") String title, Criteria criteria,
			HttpSession session, Model model) {

		// �������� ��� ��ȸ - �������� 10���� ��ȸ
		List<NoticeVO> noticeList = noticeService.getListWithPaging(criteria, title);

		// ȭ�鿡 ǥ���� ������ ��ư ���� ����
		PageMaker pageMaker = new PageMaker();
		int totalCount = noticeService.countNoticetList(title);

		pageMaker.setCriteria(criteria); // ���� �������� �������� �׸� �� ���� ����
		pageMaker.setTotalCount(totalCount); // ��ü �������� ��� ���� ���� �� ������ ���� �ʱ�ȭ

		model.addAttribute("noticeList", noticeList); // ${noticeList} �Ӽ����� ��� ȭ�鿡 ȣ���Ѵ�
		model.addAttribute("noticeListSize", noticeList.size());
		model.addAttribute("pageMaker", pageMaker);

		return "notice/master_manage_notice_list"; // �������� ����Ʈ ȭ������ ����
	}

	/*
	 * ȸ�� �������� ��� ������ �̵�(�Ѱ�����)
	 */
	@RequestMapping(value = "/master_notice_manage_form", method = RequestMethod.GET)
	public String masterNoitceManageForm(HttpSession session, NoticeVO vo) {
		return "notice/master_notice_manage_form";
	}

	/*
	 * ȸ�� �������� ���(�Ѱ�����)
	 */
	@RequestMapping(value = "/master_notice_manage", method = RequestMethod.GET)
	public String masterNoticeWrite(HttpSession session, NoticeVO vo) {

		noticeService.insertNotice(vo);
		return "redirect:master_manage_notice_list";

	}

	/*
	 * ȸ�� �������� ���� ������ �̵�(�Ѱ�����)
	 */
	@RequestMapping(value = "/master_manage_notice_update_form", method = RequestMethod.GET)
	public String masterQuestionUpdateForm(@RequestParam("nseq") int nseq, Model model) {

		NoticeVO NoitceDetail = noticeService.detailNotice(nseq);
		model.addAttribute("noticeVO", NoitceDetail);

		return "notice/master_notice_update_form";
	}

	/*
	 * ȸ�� �������� ����(�Ѱ�����)
	 */
	@RequestMapping(value = "/master_manage_notice_update", method = RequestMethod.GET)
	public String masterManageNoticeUpdate(HttpSession session, NoticeVO vo) {

		noticeService.updateNotice(vo);
		return "redirect:master_manage_notice_list";
	}

	/*
	 * ȸ�� �������� ����(�Ѱ�����)
	 */
	@RequestMapping(value = "/master_manage_notice_delete", method = RequestMethod.GET)
	public String masterManageNoticeDelete(HttpSession session, NoticeVO vo, int nseq) {

		noticeService.deleteNotice(nseq);
		return "redirect:master_manage_notice_list";
	}

}
