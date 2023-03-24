package java_Book_230322;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
	private static AdminRepository arepository = new AdminRepository();
	private AdminRepository() {}
	public static AdminRepository getInstance() {
		return arepository;
	}
	List<AdminDTO> list = new ArrayList<>();
	
	public boolean inserBook(AdminDTO adminDTO) {
		return list.add(adminDTO);
	}
	
	public List<AdminDTO> selectAll(){
		return list;
	}
	
	public List<AdminDTO> search(String n){
		List<AdminDTO> serchList = new ArrayList<>();
		for(AdminDTO a : list) {
			if(n.equals(a.getBno()) || n.equals(a.getTitle()) || n.equals(a.getWriter())) {
				serchList.add(a);
			}
		}
		return serchList;
	}
	
	public AdminDTO findByBno(String bno) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno)) {
				return a;
			}
		}
		return null;
	}
	
	public boolean updateBook(String bno, AdminDTO adminDTO) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno)) {
				a.setTitle(adminDTO.getTitle());
				a.setWriter(adminDTO.getWriter());
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteBook(String bno) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno)) {
				list.remove(a);
				return true;
			}
		}
		return false;
	}
	
	public boolean chkBook(String bno) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno)) {
				a.setDivision(true);
				a.setOutDate();
				return true;
			}
		}
		return false;
	}
	
	public boolean chkDivision(String bno) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno) && a.isDivision() == true) {
				return false;
			}
		}
		return true;
	}
	
	public boolean reBook(String bno) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno)) {
				a.setDivision(false);
				a.setIndivision(true);
				a.setInDate();
				return true;
			}
		}
		return false;
	}
	
	public boolean rechkDivision(String bno) {
		for(AdminDTO a : list) {
			if(a.getBno().equals(bno) && a.isDivision() == false) {
				return false;
			}
		}
		return true;
	}
	
	public List<AdminDTO> mybookList(BookDTO bookDTO, String id, String pw) {
		List<AdminDTO> mylist = new ArrayList<>();
		for(AdminDTO a : list) {
			if(bookDTO.getId().equals(id) && bookDTO.getPassword().equals(pw)) {
				mylist.add(a);
			}
		}
		return mylist;
	}
}
