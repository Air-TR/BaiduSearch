package cn.tr.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 执行Ajax的action
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
		// 用来接收获取符合条件的结果
		List<String> strList = new ArrayList<String>();
		// StringBuffer sb = new StringBuffer();
		// 获取前台输入的字符，去空格，转换成小写
		String content = req.getParameter("content").trim().toLowerCase();
		
		// 如果输入的字符存在且不为空
		if (content != null && !"".equals(content)) {
			// 将符合条件的结果放进集合中
			for (String strTemp : str) {
				// 以字符串开头
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
		// // 结果集只保存前十个元素
		// strList = strList.subList(0, 10);
		// }
		// 存放到request属性范围中
		req.setAttribute("strList", strList);
		// 将结果在页面中输出
		req.getRequestDispatcher("WEB-INF/jsp/showAjax.jsp").forward(req, resp);
		// PrintWriter print = resp.getWriter();
		// print.write(sb.toString());
	}

	@Override
	public void init() throws ServletException {
		// 初始化初始数据
		// 相当于数据库
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
