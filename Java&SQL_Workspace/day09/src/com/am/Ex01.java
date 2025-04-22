package com.am;

//추상클래스
// - 추상메서드를 0개 이상 갖는 클래스
// - 상속을 통해서만 사용함을 강제하는 클래스
abstract class Lec01{
	static int su1 = 1111;
	int su2 =2222;
	public Lec01(String msg){
		System.out.println("생성자 호출"+msg);
	}
	protected Lec01() {}
	Lec01(int s){}
	private Lec01(double a) {}
	
	public void func01() {}
	//추상 메서드 - 메서드의 선언은 있지만 구현은 없는 메서드
	public abstract void func02();;// 추상메서드가 없어도 추상클래스 가능
	public static void func03(){}
	//추상은 non-static에 한해서 사용 -> static일 경우 특정 클래스 안에만 있을 뿐 실제론 함께 있다고 생각하면됨 : 객체 생성시 스태틱 키워드가 붙은 것은 제외하고 만듬
	


}

public class Ex01 extends Lec01 {
	public Ex01() {
		super("");
	}
	
	@Override
	public void func02() {//구현이 없는 추상메서드를 오버라이딩
		}
	

	public static void main(String[] args) {
//		Lec01 parent = new Lec01();
		System.out.println(Lec01.su1);
		Lec01.func03();
		Ex01 me = new Ex01();
		}

}
