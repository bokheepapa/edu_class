package sec01.exam02;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// 로또 번호 추출기 : 1 ~ 45 >>> 0 ~ 44 + 1
		Scanner scanner = new Scanner(System.in);
		
		while(true) {	
			System.out.println("############################");
			System.out.print("몇 회 출력 할까요?(0은 종료) : ");
			int round = scanner.nextInt();
			System.out.println("############################");
			
			if(round < 0) {
				System.out.println("1 이상 입력해 주세요.");
			}
			else if(round == 0) {
				System.out.println("종료.");
				break;
			}
			else {
				int[][] lotto_num = new int[round][6];
				int cnt = 0;
				int round_cnt = 0;
				boolean exist = false; 
				
				while(true) {
					
					int num = (int)(Math.random() * 45) + 1;

					for(int i = 0; i < 6 ; i++) {
						if(lotto_num[round_cnt][i] == num) {
							exist = true;
							break;
						}
						else {
							exist = false;
						}
					}
					
					if(!exist) {
						lotto_num[round_cnt][cnt] = num;
						cnt++;
					}
					
					if(cnt == 6) {
						if(round_cnt == round - 1) {
							break;
						}
						else {
							cnt = 0;
							round_cnt++;
						}					
					}
				}
				
				for(int i = 0 ; i < lotto_num.length ; i++) {
					System.out.print("#" + (i + 1) + " : ");
					for(int j = 0 ; j < 6 ; j++) {
						System.out.print(lotto_num[i][j]);
						System.out.print(" ");
					}
					System.out.println("");
				}
				
			}
			System.out.println("");
		}
		scanner.close();
	}

}
