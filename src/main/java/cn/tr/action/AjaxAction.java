package cn.tr.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ִ��Ajax��action
 * 
 * @author Steven
 * 
 * 
 */
public class AjaxAction extends HttpServlet {
	private String[] str;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// �������ջ�ȡ���������Ľ��
		List<String> strList = new ArrayList<String>();
		// StringBuffer sb = new StringBuffer();
		// ��ȡǰ̨������ַ���ȥ�ո�ת����Сд
		String content = req.getParameter("content").trim().toLowerCase();
		
		// ���������ַ������Ҳ�Ϊ��
		if (content != null && !"".equals(content)) {
			// �����������Ľ���Ž�������
			for (String strTemp : str) {
				// ���ַ�����ͷ
				if (strTemp.toLowerCase().startsWith(content)) {
					strList.add(strTemp);
					// sb.append(strTemp);
					// sb.append("<br/>");
				}
//				if (strTemp.toLowerCase().indexOf(content) != -1) {
//					strList.add(strTemp);
//				}
			}
		}
		// if (strList.size() > 10) {
		// // �����ֻ����ǰʮ��Ԫ��
		// strList = strList.subList(0, 10);
		// }
		// ��ŵ�request���Է�Χ��
		req.setAttribute("strList", strList);
		// �������ҳ�������
		req.getRequestDispatcher("WEB-INF/jsp/showAjax.jsp").forward(req, resp);
		// PrintWriter print = resp.getWriter();
		// print.write(sb.toString());
	}

	@Override
	public void init() throws ServletException {
		// ��ʼ����ʼ����
		// �൱�����ݿ�
		str = new String[] { "about", "above", "afraid", "after", "afternoon",
				"again", "age", "ago", "agree", "air", "airplane", "airport",
				"all", "almost", "along", "already", "also", "always",
				"American", "and", "angry", "away", "autumn", "aunt", "August",
				"ask", "as", "art", "arrive", "around", "arm", "April",
				"apple", "appear", "apartment", "anything", "anyone", "any",
				"answer", "another", "animal", "boy", "banana", "band",
				"idiom", "illuminate", "highlight", "heritage", "grief",
				"grab", "glitter", "legitimate", "likelihood", "media",
				"mediate", "negligible", "narrative", "offence", "offensive",
				"overthrow", "periodic", "publicity", "qualification",
				"qualitative", "reign", "repay", "replacement", "revolve",
				"scared", "seminar", "token", "transient", "update",
				"vegetation", "virgin", "zinc", "yell", "yoke", "youngster",
				"whereby", "ward", "vicious", "versatile", "tuck", "trigger",
				"transient", "transaction", "theme", "handbook", "grim",
				"extract", "entity", "edit", "distract", "discount",
				"differentiate", "destiny", "delegate", "couch", "nba" };
	}
}
