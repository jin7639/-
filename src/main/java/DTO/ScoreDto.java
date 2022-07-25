package DTO;

public class ScoreDto {

	private String sno;
	private String sname;
	private int ekor;
	private int emath;
	private int eeng;
	private int ehist;
	private int sum;
	private int avg;
	public ScoreDto(String sno, String sname, int ekor, int emath, int eeng, int ehist, int sum, int avg) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
		this.sum = sum;
		this.avg = avg;
	}
	public ScoreDto() {
		super();
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getEkor() {
		return ekor;
	}
	public void setEkor(int ekor) {
		this.ekor = ekor;
	}
	public int getEmath() {
		return emath;
	}
	public void setEmath(int emath) {
		this.emath = emath;
	}
	public int getEeng() {
		return eeng;
	}
	public void setEeng(int eeng) {
		this.eeng = eeng;
	}
	public int getEhist() {
		return ehist;
	}
	public void setEhist(int ehist) {
		this.ehist = ehist;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	
	
}
