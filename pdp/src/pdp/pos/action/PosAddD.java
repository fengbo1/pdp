package pdp.pos.action;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pdp.norm.pojo.Norm;
import pdp.pos.dao.PositionDAO;
import pdp.pos.pojo.Position;
import ccb.hibernate.HibernateSessionFactory;

public class PosAddD {
	private String[] norm;
	private int posid;
	private String message;
	private List<Norm> list;
	public String[] getNorm() {
		return norm;
	}
	public void setNorm(String[] norm) {
		this.norm = norm;
	}
	public int getPosid() {
		return posid;
	}
	public void setPosid(int posid) {
		this.posid = posid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Norm> getList() {
		return list;
	}
	public void setList(List<Norm> list) {
		this.list = list;
	}
	public String execute() throws Exception
	{
		Query query;
		String rst = "success";
		String hql = "";
		String normcun = "";
		String normpropcun = "";
		Session session = HibernateSessionFactory.getSession();
	 	    Transaction trans = session.beginTransaction();
		if(norm!=null&&norm.length!=0)
		{	
		  normcun =norm[0];
		 for(int i=1;i<norm.length;i++)
	    {
			normcun += "、";
			normcun += norm[i];
	    }
		}
		if(norm==null||norm.length==0)
		{
			message="指标未选！";
			rst = "failed";
		}
		
 	   if(rst.equals("failed"))
	    {
 		  hql = "from Norm as n where n.type='normd'";
 		 System.out.println(hql);
 		query = session.createQuery(hql);
 		list = query.list();
	    }
 	   else
 	   {
 		  PositionDAO pdao=new PositionDAO();
 			Position p =new Position();
 			
 	 	    p=pdao.findAllById(posid);
 	 	    
 	 	    p.setNormd(normcun);
 	 	    p.setNormpropd(normpropcun);
 	 	    p.setStatus(5);
 	 	    pdao.merge(p);
 	 	    message="添加成功";
 	   }
		
	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return rst;
	}
}
