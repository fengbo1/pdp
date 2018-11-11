package pdp.norm.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.dao.NormDAO;
import pdp.norm.pojo.Norm;
import ccb.hibernate.HibernateSessionFactory;

public class NormDel {
	private int id;
	private String type;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		Norm norm = new Norm();
		NormDAO ndao = new NormDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			norm = ndao.findAllById(id);
			ndao.delete(norm);
			message = "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return "success";
	}
}
