package pdp.norm.action;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.dao.NormDAO;
import pdp.norm.pojo.Norm;
import ccb.hibernate.HibernateSessionFactory;

public class NormAdd {
	private String message;
	private String name;
	private String type;
	private String level;
	private String target;
	private double score;
	private String rule;
	private String remark;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String execute() throws Exception
	{
		Norm norm = new Norm();
		NormDAO ndao = new NormDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			norm.setLevel("");
			norm.setName(name);
			norm.setRemark(remark);
			norm.setRule(rule);
			norm.setScore(score);
			norm.setTarget(target);
			norm.setType(type);
			ndao.merge(norm);
			message = "新增成功";
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
