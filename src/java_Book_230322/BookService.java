package java_Book_230322;

import java.util.List;
import java.util.Scanner;

public class BookService {
	private static BookService service = new BookService();
	private BookService() {}
	public static BookService getInstance() {
		return service;
	}
	
	private Scanner sc = new Scanner(System.in);
	private BookRepository repository = BookRepository.getInstance();
	private AdminRepository arepository = AdminRepository.getInstance();
	String loginId = null;
	String loginPassword = null;
	
	public void save() {
		BookDTO bookDTO = new BookDTO();
		boolean checkResult = true;
		String id = null;
		do {
			System.out.print("아이디> ");
			id = sc.next();
			if (repository.checkId(id)) {
				System.out.println("사용가능한 아이디입니다.");
				checkResult = false;
			} else {
				System.out.println("이미 사용중인 아이디입니다.");
			}
		} while (checkResult);
		bookDTO.setId(id);
		System.out.print("비밀번호> ");
		bookDTO.setPassword(sc.next());
		System.out.print("이름> ");
		bookDTO.setName(sc.next());
		System.out.print("전화번호> " );
		bookDTO.setPhone(sc.next());
		if (repository.save(bookDTO)) {
			System.out.println("\n회원가입이 완료되었습니다.");
		} else {
			System.out.println("\n회원가입 중 오류가 발생하였습니다.");
		}
	}
	
	public boolean loginCheck() {
		System.out.print("아이디> ");
		String id = sc.next();
		System.out.print("비밀번호> ");
		String pw = sc.next();
		if(repository.loginCheck(id, pw)) {
			System.out.println("\n로그인 성공");
			loginId = id;
			loginPassword = pw;
			return true;
		}else {
			System.out.println("\n로그인 실패");
			return false;
		}
	}
	
	public void findByIdPw() {
		System.out.print("이름> ");
		String name = sc.next();
		System.out.print("전화번호> ");
		String phone = sc.next();
		BookDTO bookDTO = repository.findByIdPw(name, phone);
		if(bookDTO == null) {
			System.out.println("\n찾을 수 없는 사용자 입니다.");
		}else {
			System.out.print("찾기(1.아이디 2.비밀번호)> ");
			int i = sc.nextInt();
			if(i == 1) {
				System.out.println("\n"+bookDTO.getId());
			}else if(i == 2) {
				System.out.print("아이디> ");
				String id = sc.next();
				BookDTO b = repository.finById(id);
				if(b == null) {
					System.out.println("\n등록되지 않은 아이디입니다.");
				}else {
					System.out.print("수정할 비밀번호 입력> ");
					String pw = sc.next();
					if(repository.pwUpdate(pw, id)) {
						System.out.println("\n비밀번호가 수정되었습니다.");
					}else {
						System.out.println("\n수정에 실패하였습니다.");
					}
				}
			}else {
				System.out.println("\n다시선택");
			}
		}
	}
	
	public void update() {
		System.out.print("비밀번호 확인> ");
		String password = sc.next();
		if(password.equals(loginPassword)) {
			BookDTO bookDTO = new BookDTO();
			System.out.print("수정할 이름> ");
			bookDTO.setName(sc.next());
			System.out.print("수정할 전화번호> ");
			bookDTO.setPhone(sc.next());
			System.out.print("수정할 비밀번호> ");
			String updatePassword = sc.next();
			if(repository.update(loginId, loginPassword, bookDTO)) {
				loginPassword = updatePassword;
				System.out.println("\n회원정보가 수정되었습니다.");
			}else {
				System.out.println("\n오류가 발생하였습니다.");
			}
		}else {
			System.out.println("\n비밀번호가 일치하지 않습니다");
		}
	}
	
	public void delete() {
		System.out.print("삭제할 회원의 비밀번호> ");
		String pw = sc.next();
		if(repository.delete(pw)) {
			System.out.println("\n탈퇴가 완료되었습니다. 감사합니다.");
		}else {
			System.out.println("\n오류가 발생하였습니다.");
		}
		
	}
	
	public void logout() {
		loginId = null;
		loginPassword = null;
		System.out.println("\n로그아웃 되었습니다.");
	}
	
//	public void chkBook() {
////		AdminDTO adminDTO = new AdminDTO();
//		System.out.print("도서번호를 입력해주세요> ");
//		String bno = sc.next();
//		if(arepository.chkBook(bno)) {
//			System.out.println("\n도서가 대여되었습니다.");
////			adminDTO.setDivision(true);
////			adminDTO.setOutDate(adminDTO.getOutDate());
////			System.out.println(adminDTO);
//			
//		}else {
//			System.out.println("\n해당도서가 존재하지 않습니다.");
//		}
//	}
	
	public void findAll() {
		List<BookDTO> list = repository.findAll();
		System.out.println("이름\t전화번호\t아이디\t비밀번호\t가입일자");
		System.out.println("-----------------------------------------------------");
		for(BookDTO b : list) {
			System.out.println(b.toString());
		}
	}
	
	public void mybookList() {
		BookDTO bookDTO = repository.finById(loginId);
//		String id = loginId;
//		String pw = loginPassword;
		List<AdminDTO> list = arepository.mybookList(bookDTO, loginId, loginPassword);
		System.out.println("\n책번호\t도서제목\t작가명\t구분\t도서등록일\t\t\t대여일자\t\t\t반납일자");
		System.out.println("------------------------------------------------------------------------------------------------");
		for(AdminDTO a : list) {
			System.out.println(a.toString());
		}
	}
}
