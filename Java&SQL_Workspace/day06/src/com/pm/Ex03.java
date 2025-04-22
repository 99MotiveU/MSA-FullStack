package com.pm;

public class Ex03 {

    public static void main(String[] args) {
        // 문자열의 Create, Read, Update, Delete (CRUD) 예제

        // create: 문자열 생성
        String msg = "ABCDabcd1234";  // 초기 문자열을 생성

        // read: 문자열의 정보를 읽기
        System.out.println(msg.length());  // 문자열의 길이 출력
        System.out.println(msg.contains("bc"));  // 문자열에 "bc"가 포함되어 있는지 확인 (true/false)
        System.out.println(msg.charAt(4));  // 문자열에서 인덱스 4 위치에 있는 문자 출력 ('a')

        // update: 문자열을 수정 (업데이트)
        msg = msg.replace("abcd", "aBCd");  // "abcd"를 "aBCd"로 교체
        System.out.println(msg);  // 교체된 문자열 출력

        msg = msg.concat("!@#$");  // 문자열 끝에 "!@#$" 추가
        System.out.println(msg);  // 변경된 문자열 출력

        // delete: 문자열 삭제 (대체 또는 삭제)
        msg = msg.replace("aBCd", "a");  // "aBCd"를 "a"로 교체 (사실상 삭제하는 효과)
        System.out.println(msg);  // 교체된 문자열 출력

        // "bc"가 문자열에 포함되어 있는지 다시 확인
        System.out.println(msg.contains("bc"));  // "bc"가 포함되어 있는지 확인 (false)
    }
}
