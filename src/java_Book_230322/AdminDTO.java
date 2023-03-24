
package java_Book_230322;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminDTO {
	private static int number = 100;
	private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");
	
	private String bno;
	private String title;
	private String writer;
	private boolean division; //구분 false(대여가능) true(대여)
	private String upDate; //등록일자
	private String outDate; //대여일자
	private String inDate; //반납일자
	private boolean indivision; //반납여부
	public AdminDTO() {
		this.bno = "B"+number++;
		this.upDate = DTF.format(LocalDateTime.now()); 
	}
	public String getBno() {
		return bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public boolean isDivision() {
		return division;
	}
	public void setDivision(boolean division) {
		this.division = division;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate() {
		if(division = true) {
			this.outDate = DTF.format(LocalDateTime.now());
		}
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate() {
		if(indivision = true) {
			this.inDate = DTF.format(LocalDateTime.now());
		}
	}
	public boolean isIndivision() {
		return indivision;
	}
	public void setIndivision(boolean indivision) {
		this.indivision = indivision;
	}
	@Override
	public String toString() {
		return bno + "\t" + title + "\t" + writer + "\t" + division + "\t" + upDate + "\t" + outDate + "\t" + inDate;
	}
}
