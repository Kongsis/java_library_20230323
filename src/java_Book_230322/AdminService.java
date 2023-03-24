package java_Book_230322;

import java.util.List;
import java.util.Scanner;

public class AdminService {
	private static AdminService aservice = new AdminService();
	private AdminService() {}
	public static AdminService getInstance() {
		return aservice;
	}
	
	private Scanner sc = new Scanner(System.in);
	private BookRepository repository = BookRepository.getInstance();
	private AdminRepository arepository = AdminRepository.getInstance();
	
	public void insertBook() {
		AdminDTO adminDTO = new AdminDTO();
		System.out.print("도서제목> ");
		adminDTO.setTitle(sc.next());
		System.out.print("작가명> ");
		adminDTO.setWriter(sc.next());
		adminDTO.setDivision(false);
		
		if(arepository.inserBook(adminDTO)) {
			System.out.println("\n도서등록이 완료되었습니다.");
		}else {
			System.out.println("\n오류가 발생하였습니다.");
		}
	}
	
	public void selectAll() {
		List<AdminDTO> list = arepository.selectAll();
		System.out.println("\n책번호\t도서제목\t작가명\t구분\t도서등록일\t\t\t대여일자\t\t\t반납일자");
		System.out.println("------------------------------------------------------------------------------------------------");
		for(AdminDTO a : list) {
			System.out.println(a.toString());
		}
	}
	
	public void search() {
		System.out.print("검색어> ");
		String n = sc.next();
		List<AdminDTO> serchList = arepository.search(n);
		System.out.println("\n책번호\t도서제목\t작가명\t구분\t도서등록일\t\t\t대여일자\t\t\t반납일자");
		System.out.println("------------------------------------------------------------------------------------------------");
		for(AdminDTO a : serchList) {
			System.out.println(a.toString());
		}
	}
	
	public void updateBook() {
		System.out.print("수정할 책번호> ");
		String bno = sc.next();
		AdminDTO adminDTO = arepository.findByBno(bno);
		if(adminDTO == null) {
			System.out.println("\n조회할 수 없는 책번호 입니다.");
		}else {
			System.out.print("수정할 도서제목> ");
			adminDTO.setTitle(sc.next());
			System.out.print("수정할 작가명> ");
			adminDTO.setWriter(sc.next());
			if(arepository.updateBook(bno, adminDTO)) {
				System.out.println("\n수정 되었습니다.");
			}else {
				System.out.println("\n오류가 발생하였습니다.");
			}
		}
	}
	
	public void deleteBook() {
		System.out.print("삭제할 책번호> ");
		String bno = sc.next();
		if(arepository.deleteBook(bno)) {
			System.out.println("\n도서가 삭제되었습니다.");
		}else {
			System.out.println("\n오류가 발생하였습니다.");
		}
	}
	
	public void checkBook() {
//		AdminDTO adminDTO = new AdminDTO();
		System.out.print("도서번호를 입력해주세요> ");
		String bno = sc.next();
		if(arepository.chkDivision(bno)) {
			if(arepository.chkBook(bno)) {
				System.out.println("\n도서가 대여되었습니다.");
//				adminDTO.setDivision(true);
//				adminDTO.setOutDate(adminDTO.getOutDate());
//				System.out.println(adminDTO);
				
			}else {
				System.out.println("\n해당도서가 존재하지 않습니다.");
			}
		}else {
			System.out.println("\n대여되어 반납되지 않은 도서입니다.");
		}

	}
	
	public void reBook() {
		System.out.print("반납할 도서번호를 입력해주세요> ");
		String bno = sc.next();
		if(arepository.rechkDivision(bno)) {
			if(arepository.reBook(bno)) {
				System.out.println("\n도서가 반납되었습니다.");
			}else {
				System.out.println("\n해당도서가 존재하지 않습니다.");
			}
		}else {
			System.out.println("\n이미 반납이 완료된 도서입니다.");
		}
	}
}
