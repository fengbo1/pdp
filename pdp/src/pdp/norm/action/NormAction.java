package pdp.norm.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import pdp.norm.bean.NormBean;
import pdp.norm.pojo.Norm;
import pdp.util.Util;

public class NormAction {

	private static final Log log = LogFactory.getLog(NormAction.class);
	private String newnumber;
	private String type;
	private List<NormBean> list;
	private String pdppos;//pdp岗位
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = Util.pagesize;
	/**
	* 总页数
	*/
	private int totalPages = -1;
	/**
	* 当前页
	*/
	private int currentPage = -1;
	/**
	* 上一页
	*/
	private int previousPage = 1;
	/**
	* 下一页
	*/
	private int nextPage = 1;
	/**
	* 第一页
	*/
	private int firstPage = 1;
	/**
	* 最后一页
	*/
	private int lastPage = 1;
	/**
	* 总记录条数
	*/
	private long totalRows = -1;
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public List<NormBean> getList() {
		return list;
	}
	public void setList(List<NormBean> list) {
		this.list = list;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPdppos() {
		return pdppos;
	}
	public void setPdppos(String pdppos) {
		this.pdppos = pdppos;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public String execute() throws Exception
	{
		String hql = "";
		Query query;
		String result = "success";
		List<Norm> listn = new ArrayList<Norm>();
		list = new ArrayList<NormBean>(); 
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from Norm where type='"+type+"'";
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows =session.createQuery(hql).list().size();
			initPageProperties();
			listn = query.list();
			for(int i=0;i<listn.size();i++)
			{
				Norm n = listn.get(i);
				NormBean nb = new NormBean();
				nb.setId(n.getId());
				nb.setType(Util.NormToString(type));
				nb.setLevel("");
				nb.setNormname(n.getName());
				nb.setRule(n.getRule());
				nb.setTarget(n.getTarget());
				nb.setStdscore(String.valueOf(n.getScore()));
				nb.setRemark(n.getRemark());
				list.add(nb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	/**
	 * 初始化页面属性<br>
	 * 必须在已获得totalRows值之后再调用该函数<br>
	 * 调用方式为：<br>
	 * 
	 * 给totalRows赋值<br>
	 * 调用initPageProperties(form)方法<br>
	 * 给list赋值<br>
	 * 调用initAttribute(request)方法<br>
	 * 
	 * 该方法在调用查询语句之前调用<br>
	 * pageSize为系统默认的分页的大小，如要更改pageSize，应在掉用setPageSize方法后再调用该方法<br>
	 * 
	 * 
	 */
	protected void initPageProperties() {

		if (totalRows == -1) {
			log.error("没有初始化totalRows参数！");
		}

		firstPage = 1;
		
		currentPage = currentPage <= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}
}
