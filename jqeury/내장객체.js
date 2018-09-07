//여러가지 내장 객체 소개


//1. 날짜 객체
let date = new Date();

document.write(date.getFullYear() + "년", "<br>");
document.write(date.getMonth() + 1 + "월", "<br>");
document.write(date.getDate() + "일", "<br>");
document.write(date.getDay() + "요일", "<br>", "<br>");


//2. 수학 객체
let num = 1.56;

document.write(Math.round(num) + "<br>"); // 반올림
document.write(Math.floor(num) + "<br>"); // 소숫점 절삭
document.write(Math.ceil(num) + "<br>"); // 무조건 올림
document.write(Math.random() + "<br>", "<br>");


//3. 문자 객체
let str = String("string");

document.write(str.charAt(1) + "<br>"); // 자바와 동일
document.write(str.indexOf("t") + "<br>"); // 해당 글자가 몇번째인지 반환
