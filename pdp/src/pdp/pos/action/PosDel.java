package pdp.pos.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.dao.NormDAO;
import pdp.norm.pojo.Norm;
import pdp.pos.dao.PositionDAO;
import pdp.pos.pojo.Position;
import ccb.hibernate.HibernateSessionFactory;

public class PosDel {
	private int id;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		Position p = new Position();
		PositionDAO pdao = new PositionDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			p = pdao.findAllById(id);
			pdao.delete(p);
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
