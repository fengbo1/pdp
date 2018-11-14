package pdp.userinfo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.userinfo.dao.UserInfoDAO;
import pdp.userinfo.pojo.Rater;

import ccb.hibernate.HibernateSessionFactory;

public class FindRater {
	private List<Rater> lista;
	private List<Rater> listb;
	private List<Rater> listc;
	private List<Rater> listd;
	private List<Rater> liste;
	private String resta;
	private String restb;
	private String restc;
	private String restd;
	private String reste;
	public List<Rater> getLista() {
		return lista;
	}
	public void setLista(List<Rater> lista) {
		this.lista = lista;
	}
	public List<Rater> getListb() {
		return listb;
	}
	public void setListb(List<Rater> listb) {
		this.listb = listb;
	}
	public List<Rater> getListc() {
		return listc;
	}
	public void setListc(List<Rater> listc) {
		this.listc = listc;
	}
	public List<Rater> getListd() {
		return listd;
	}
	public void setListd(List<Rater> listd) {
		this.listd = listd;
	}
	public List<Rater> getListe() {
		return liste;
	}
	public void setListe(List<Rater> liste) {
		this.liste = liste;
	}
	public String getResta() {
		return resta;
	}
	public void setResta(String resta) {
		this.resta = resta;
	}
	public String getRestb() {
		return restb;
	}
	public void setRestb(String restb) {
		this.restb = restb;
	}
	public String getRestc() {
		return restc;
	}
	public void setRestc(String restc) {
		this.restc = restc;
	}
	public String getRestd() {
		return restd;
	}
	public void setRestd(String restd) {
		this.restd = restd;
	}
	public String getReste() {
		return reste;
	}
	public void setReste(String reste) {
		this.reste = reste;
	}
	public String execute() throws Exception
	{
		String sql = "";
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
			
			
			
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
