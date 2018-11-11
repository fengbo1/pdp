package pdp.norm.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.dao.NormDAO;
import pdp.norm.pojo.Norm;
import ccb.hibernate.HibernateSessionFactory;

public class NormToUpdate {
	private int id;
	private String type;
	private Norm norm;
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
	public Norm getNorm() {
		return norm;
	}
	public void setNorm(Norm norm) {
		this.norm = norm;
	}
	public String execute() throws Exception
	{
		NormDAO ndao = new NormDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			norm = ndao.findAllById(id);
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
