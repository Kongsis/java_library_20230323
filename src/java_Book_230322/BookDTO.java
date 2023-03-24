package java_Book_230322;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookDTO {
	private static int number = 100;
	private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");
	
	private String bno;
	private String name;
	private String phone;
	private String id;
	private String password;
	private String title;
	private String writer;
	private String date;
	
	public BookDTO() {
		this.bno = "B"+number++;
		this.date = DTF.format(LocalDateTime.now()); 
	}
	
	public String getBno() {
		return bno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getDate() {
		return date;
	}
	@Override
	public String toString() {
		return name + "\t" + phone + "\t" + id + "\t" + password + "\t" + date;
	}
}
