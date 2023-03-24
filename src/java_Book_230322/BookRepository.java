package java_Book_230322;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
	private static BookRepository repository = new BookRepository();
	private BookRepository() {}
	public static BookRepository getInstance() {
		return repository;
	}
	List<BookDTO> list = new ArrayList<>();
	
	public boolean save(BookDTO bookDTO) {
		return list.add(bookDTO);
	}
	
	public List<BookDTO> findAll(){
		return list;
	}
	public boolean checkId(String id) {
		for(BookDTO b : list) {
			if(b.getId().equals(id)) {
				return false; 
			}
		}
		return true;
	}
	
	public boolean loginCheck(String id, String pw) {
		for(BookDTO b : list) {
			if(id.equals(b.getId()) && pw.equals(b.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public BookDTO finById(String id) {
		for(BookDTO b : list) {
			if(b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}
	
	public BookDTO findByIdPw(String name, String phone) {
		for(BookDTO b : list) {
			if(b.getName().equals(name) && b.getPhone().equals(phone)) {
				return b;
			}
		}
		return null;
	}
	
	public boolean pwUpdate(String pw, String id) {
		for(BookDTO b : list) {
			if(b.getId().equals(id)) {
				b.setPassword(pw);
				return true;
			}
		}
		return false;
	}

	public boolean update(String id, String pw, BookDTO bookDTO) {
		for(BookDTO b : list) {
			if(b.getId().equals(id) && b.getPassword().equals(pw)) {
				b.setName(bookDTO.getName());
				b.setPhone(bookDTO.getPhone());
				b.setPassword(bookDTO.getPassword());
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(String pw) {
		for(BookDTO b : list) {
			if(b.getPassword().equals(pw)) {
				list.remove(b);
				return true;
			}
		}
		return false;
	}
	
//	public boolean chkBook(String bno) {
//		for(AdminDTO a : alist) {
//			if(a.getBno().equals(bno)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	
}