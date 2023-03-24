package java_Book_230322;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BookService service = BookService.getInstance();
		AdminService aservice = AdminService.getInstance();
		Admin admin = Admin.getInstance();
		boolean loginOk = false;
		
		while(true) {
			System.out.println("==================== 일보도서관 ====================");
			if(loginOk) {
				System.out.println("1.My도서리스트 2.도서대여 3.도서반납 4.회원정보수정 5.회원탈퇴 6.로그아웃 0.종료");
			}else {
				System.out.println("1.회원가입 2.로그인 3.아이디/비밀번호 찾기 4.도서리스트 0.종료");
			}
			
			System.out.print("선택> ");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				if(loginOk) {
					
				}else {
					service.save();
				}
			}else if(menu == 2) {
				if(loginOk) {
					aservice.checkBook();
				}else {
					loginOk = service.loginCheck();
				}
			}else if(menu == 3) {
				if(loginOk) {
					loginOk = service.loginCheck();
				}else {
					service.findByIdPw();
				}
			}else if(menu == 4) {
				if(loginOk) {
					service.update();
				}else {
					aservice.selectAll();
				}
			}else if(menu == 5 && loginOk) {
				service.delete();
			}else if(menu == 6 && loginOk) {
				service.logout();
				loginOk = false;
			}else if(menu == 9999) {
				admin.adminMenu();
			}else if(menu == 0) {
				break;
			}else {
				System.out.println("\n다시 입력해주세요.");
			}
			System.out.println();
		}
		System.out.println("\n시스템을 종료합니다.");
	}

}
