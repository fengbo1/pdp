package pdp.pos.action;

public class BeforePosAdd {
	private String chu;
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String execute() throws Exception
	{	
		return "success";
	}
}
