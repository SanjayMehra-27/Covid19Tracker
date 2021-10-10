package utility;

public class Covid19 {
	
	private String confirmed;
	private String date;
	private String time;
	private String deaths;
	private String recovered;
	private String last_update;
	private String province;
	
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Covid19 [confirmed=" + confirmed + ", date=" + date + ", deaths=" + deaths + ", recovered=" + recovered
				+ ", last_update=" + last_update + ", province=" + province + "]";
	}
	
	

}
