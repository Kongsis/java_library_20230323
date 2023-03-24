package java_Book_230322;

import java.util.Scanner;

public class Admin {
	private static Admin admin = new Admin();
	private Admin() {}
	public static Admin getInstance() {
		return admin;
	}
	
	BookMain bookMain = new BookMain();
	Scanner sc = new Scanner(System.in);
	BookService service = BookService.getInstance();
	AdminService aservice = AdminService.getInstance();
	
	public void adminMenu() {
		while(true) {
			System.out.println("==================================== 일보도서관 관리자페이지 ====================================");
			System.out.println("1.도서등록 2.도서리스트 3.도서검색 4.도서수정 5.도서삭제 6.도서대여 7.도서반납 8.회원리스트 0.돌아가기");
			System.out.print("선택> ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case(1):
				aservice.insertBook();
				continue;
			
			case(2):
				aservice.selectAll();
				continue;
			
			case(3):
				aservice.search();
				continue;
			
			case(4):
				aservice.updateBook();
				continue;
			
			case(5):
				aservice.deleteBook();
				continue;
			
			case(6):
				aservice.checkBook();
				continue;
			
			case(7):
				aservice.reBook();
				continue;
				
			case(8):
				service.findAll();
				continue;
				
			case(0):
				break;
			default:
				System.out.println("\n잘못입력하셨습니다.");
				System.out.print("다시입력> ");
				break;
			}
			break;
		}
	}
}
