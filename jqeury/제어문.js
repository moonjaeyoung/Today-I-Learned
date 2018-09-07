function f() {
    let a = prompt("입력하세요", "0");

    if (a > 100) {
        document.write("100보다 큽니다.")
    } else {
        document.write("100보다 작습니다.")
    }
    //if문

    switch (a) {
        case 10:
            document.write("10");
            break;
        case 20:
            document.write("20");
            break;
        default:
            document.write("10과 20이 아닙니다.");
            break;
    }
    //switch문

    while (a <= 100) {
        document.write("반복~", "<br>");
        a++
    }

    for (let i = 0; i < 10; i++) {
        document.write("for문");
    }


}

f();